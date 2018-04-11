package youtube.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import youtube.Comment;
import youtube.PlayList;
import youtube.Video;
import youtube.YouTube;
import youtube.user.exceptions.ExistingUserException;
import youtube.user.exceptions.WrongCredentialsException;

public class UserDao implements IUserDao{

	private static UserDao instance;
	private Connection connection;
	private YouTube youtube;
	
	public static UserDao getInstance() {
		if(instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	private UserDao() {
		connection = DBManager.getInstance().getConnection();
		youtube = YouTube.getInstance();
	}
	
	

	@Override
	public Collection<User> getAllUsers() throws SQLException {
		PreparedStatement s = connection.prepareStatement("SELECT id, username, password, email FROM users");
		HashSet<User> users = new HashSet<>();
		ResultSet result = s.executeQuery();
		while(result.next()) {
			User u = new User(	result.getInt("id"),
								result.getString("username"),
								result.getString("password"),
								result.getString("email"));
			users.add(u);
		}
		return users;
	}

	@Override
	public void saveUser(User u) throws SQLException {
		PreparedStatement s = connection.prepareStatement("INSERT INTO users (username, password, email) VALUES (?,?,?)");
		s.setString(1, u.getName());
		s.setString(2, u.getPassword());
		s.setString(3, u.getEmail());
		s.executeUpdate();
	}
	
	@Override
	public void upload(User u, Video video) {
		if(video == null) {
			System.out.println("Couldn't add the video, try again.");
			return;
		}
		if(youtube.upload(video)) {
			u.getUploadedVideos().add(video);
			System.out.println("Your video has been uploaded successfully");
		}
	}

	@Override
	public void deleteVideo(User u, Video video) {
		if(video == null || !u.getUploadedVideos().contains(video)) {
			System.out.println("There was an error while trying to delete this video, try again.");
		}
		u.getUploadedVideos().remove(video);
		youtube.deleteVideo(video);
		System.out.println("You've deleted this video from youtube.");
	}

	@Override
	public void changeName(User u, String newName) throws SQLException {
		if(nameCheck(newName)) {
			u.setName(newName);
		}
		else {
			//TODO throw exetion
			System.out.println("Your username couldn't be changed.");
		}
	}

	@Override
	public void changePassword(User u, String newPassword) {
		if(passwordCheck(newPassword)) {
			u.setPassword(newPassword);
			return;
		}
		//TODO throw exetion
		System.out.println("There was a problem while changing your password, try again.");
	}

	@Override
	public void changeEmail(User u, String newEmail) {
		if(emailCheck(newEmail) && !youtube.existingEmail(newEmail)) {
			u.setEmail(newEmail);
			return;
		}
		//TODO exeption
		System.out.println("Your email is invalid or registered by another user.");
	}

	@Override
	public void subscribeTo(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unsubscribeFrom(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comment(String commentMsg, Video video) {
		if(video != null && commentMsg != null && !commentMsg.isEmpty()) {
			video.addComment(new Comment(commentMsg));
		}
		else {
			System.out.println("Invalid comment or video.");
		}
	}

	@Override
	public void reply(String replyMsg, Comment comment) {
		if(replyMsg != null && !replyMsg.isEmpty() && comment != null) {
			comment.addComment(new Comment(replyMsg));
		}
	}

	@Override
	public void like(User u, Video video) {
		if(video == null) {
			return;
		}
		//if liked already, remove the like..
		if(u.getLikedVideos().contains(video)) {
			video.decreaseLikes();
			u.getLikedVideos().remove(video);
			return;
		}
		//if disliked, remove the dislike and add a like
		if(u.getDislikedVideos().contains(video)) {
			video.decreaseDislikes();
			u.getDislikedVideos().remove(video);
			video.increaseLikes();
			u.getLikedVideos().add(video);
			return;
		}
		video.increaseLikes();
		//fix
		u.getLikedVideos().add(video);
	}

	@Override
	public void like(User u, Comment comment) {
		if(comment == null) {
			return;
		}
		//if liked already, remove the like..
		if(u.getLikedComments().contains(comment)) {
			comment.decreaseLikes();
			u.getLikedComments().remove(comment);
			return;
		}
		//if disliked, remove the dislike and add a like
		if(u.getDislikedComments().contains(comment)) {
			comment.decreaseDislikes();
			u.getDislikedComments().remove(comment);
			comment.increaseLikes();
			u.getLikedComments().add(comment);
			return;
		}
		comment.increaseLikes();
		//fix
		u.getLikedComments().add(comment);
	}

	@Override
	public void dislike(User u, Video video) {
		if(video == null) {
			return;
		}
		if(u.getDislikedVideos().contains(video)) {
			video.decreaseDislikes();
			u.getDislikedVideos().remove(video);
		}
		if(u.getLikedVideos().contains(video)) {
			video.decreaseLikes();
			u.getLikedVideos().remove(video);
			video.increaseDislikes();
			u.getDislikedVideos().add(video);
			return;
		}
		video.increaseDislikes();
		u.getDislikedVideos().add(video);
	}

	@Override
	public void dislike(User u, Comment comment) {
		if(comment == null) {
			return;
		}
		if(u.getDislikedComments().contains(comment)) {
			comment.decreaseDislikes();
			u.getDislikedComments().remove(comment);
		}
		if(u.getLikedComments().contains(comment)) {
			comment.decreaseLikes();
			u.getLikedComments().remove(comment);
			comment.increaseDislikes();
			u.getDislikedComments().add(comment);
			return;
		}
		comment.increaseDislikes();
		u.getDislikedComments().add(comment);
	}

	@Override
	public void addVideoToPlayList(User u, PlayList playList, Video video) {
		if(playList == null || !u.getPlayLists().contains(playList)) {
			System.out.println("You don't have such playlist.");
		}
		if(video != null) {
			playList.addVideo(video);
		}
	}

	@Override
	public void removeVideoFromPlayList(User u, PlayList playList, Video video) {
		if(playList == null || !u.getPlayLists().contains(playList)) {
			System.out.println("You don't have such playlist.");
		}
		if(playList.getVideos().contains(video)) {
			playList.removeVideo(video);
		}
	}

	@Override
	public void logOut(User u) {
		u.setLoggedIn(false);
	}
	
	//checks for correct input
	public void registerCheck(String name, String password, String email) throws WrongCredentialsException, SQLException {
		if(passwordCheck(password) && nameCheck(name) && emailCheck(email)) {
			throw new WrongCredentialsException();
		}
	}
	
	public void existingUserCheck(String name, String email) throws SQLException, ExistingUserException {
		HashSet<User> users = (HashSet<User>) getAllUsers();
		for (User user : users) {
			if(user.getName().equals(name) || user.getEmail().equals(email)) {
				throw new ExistingUserException();
			}
		}
	}
	
	public void loginCheck(String username, String password) throws SQLException, WrongCredentialsException {
		HashSet<User> users = (HashSet<User>) getAllUsers();
		for(User user : users) {
			if(user.getName().equals(username) && user.getPassword().equals(password)) {
				user.setLoggedIn(true);
				return;
			}
		}
		throw new WrongCredentialsException();
	}
	
	private boolean passwordCheck(String password) {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		if(password.matches(regex)) {
			return true;
		}
		return false;
	}
	
	private boolean emailCheck(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		if(email.matches(regex)) {
			return true;
		}
		return false;
	}
	
	private boolean existingUserName(String username) throws SQLException {
		HashSet<User> users = (HashSet<User>) getAllUsers();
		if(users.size() < 1) {
			return false;
		}
		for(User user : users) {
			if(user.getName().equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean nameCheck(String name) throws SQLException {
		if(name != null 
				&& name.length() >= User.MIN_NAME_LENGTH 
				&& name.length() <= User.MAX_NAME_LENGTH 
				&& !existingUserName(name)){
			return true;
		}
		return false;
	}

}
