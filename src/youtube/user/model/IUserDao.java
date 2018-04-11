package youtube.user.model;

import java.sql.SQLException;
import java.util.Collection;

import youtube.Comment;
import youtube.PlayList;
import youtube.Video;
import youtube.user.exceptions.WrongCredentialsException;

public interface IUserDao {

//	User getByID(int id) throws Exception;
	void saveUser(User u) throws Exception;
	Collection<User> getAllUsers() throws SQLException;
//	void changeUser(User u) throws Exception;
	
	void upload(User u, Video video);
	void deleteVideo(User u, Video video);
	void changeName(User u, String newName) throws Exception;
	void changePassword(User u, String newPassword);
	void changeEmail(User u, String newEmail);
	void subscribeTo(User user);
	void unsubscribeFrom(User user);
	void comment(String commentMsg, Video video);
	void reply(String replyMsg, Comment comment);
	void like(User u, Video video);
	void like(User u, Comment comment);
	void dislike(User u, Video video);
	void dislike(User u, Comment comment);
	void addVideoToPlayList(User u, PlayList playList, Video video);
	void removeVideoFromPlayList(User u, PlayList playList, Video video);
	void logOut(User u);
	void loginCheck(String username, String password) throws SQLException, WrongCredentialsException;
	
}
