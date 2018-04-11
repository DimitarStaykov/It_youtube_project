package youtube;

import java.util.List;
import java.util.Set;

public class User {
	
	private static YouTube youtube;
	private int id;
	private String username;
	private String password;//bcrypt
	private String email;
	private Set<User> subscriberList;
	private Set<Video> favouriteVideoList; // Favourites realno moje da e prosto PlayList object
	private List<PlayList> playLists;
	private Set<Video> uploadedVideos;
	private Set<Video> likedVideos;
	private Set<Video> dislikedVideos;
	private Set<Comment> likedComments;
	private Set<Comment> dislikedComments;
	private boolean loggedIn;
	private final int minNameLength = 6;
	private final int maxNameLength = 20;
	
	//possible info for separate class , To be discussed further
	
	private Set<Video> recentlyWatched; // can be default playlist object created with the user
					   //  we add a pointer after a video is watched
	private Set<Comment> recentComments; // same principle as with videos, pointer to every comment is added here
	private Set<String> searchInputs; // a collection for search inputs 
	
	
	public User(int id, String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	
	public void upload(Video video) {
		if(video == null) {
			System.out.println("Couldn't add the video, try again.");
			return;
		}
		if(youtube.upload(video)) {
			this.uploadedVideos.add(video);
			System.out.println("Your video has been uploaded successfully");
		}
	}
	
	public void deleteVideo(Video video) {
		if(video == null || !this.uploadedVideos.contains(video)) {
			System.out.println("There was an error while trying to delete this video, try again.");
		}
		this.uploadedVideos.remove(video);
		youtube.deleteVideo(video);
		System.out.println("You've deleted this video from youtube.");
	}
	
	//done
//	public void changeName(String newName) {
//		if(nameCheck(newName)) {
//			this.username = newName;
//		}
//		else {
//			System.out.println("Your username couldn't be changed.");
//		}
//	}
	
	//done
	public void changePassword(String newPassword) {
		if(newPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
			this.password = newPassword;
			System.out.println("Your password has been changed.");
			return;
		}
		System.out.println("There was a problem while changing your password, try again.");
	}
	
	//done
	public void changeEmail(String newEmail) {
		if(emailCheck(newEmail) && !youtube.existingEmail(newEmail)) {
			this.email = newEmail;
			System.out.println("Email changed successfully");
			return;
		}
		System.out.println("Your email is invalid or registered by another user.");
	}
	
	public void subscribeTo(User user) {
		if(user != null) {
			this.subscriberList.add(user);
		}
	}
	
	public void unsubscribeFrom(User user) {
		if(user != null && this.subscriberList.contains(user)) {
			this.subscriberList.remove(user);
		}
	}
	
	public void comment(String commentMsg, Video video) {
		if(video != null && commentMsg != null && !commentMsg.isEmpty()) {
			video.addComment(new Comment(commentMsg));
		}
		else {
			System.out.println("Invalid comment or video.");
		}
	}
	
	public void reply(String replyMsg, Comment comment) {
		if(replyMsg != null && !replyMsg.isEmpty() && comment != null) {
			comment.addComment(new Comment(replyMsg));
		}
	}
	
	//done
	public void like(Video video) {
		if(video == null) {
			return;
		}
		//if liked already, remove the like..
		if(this.likedVideos.contains(video)) {
			video.decreaseLikes();
			return;
		}
		//if disliked, remove the dislike and add a like
		if(this.dislikedVideos.contains(video)) {
			video.decreaseDislikes();
			video.increaseLikes();
			return;
		}
		video.increaseLikes();
		this.likedVideos.add(video);
	}	
	//done
	
	public void like(Comment comment) {
		if(comment == null) {
			return;
		}
		//if liked already, remove the like..
		if(this.likedComments.contains(comment)) {
			comment.decreaseLikes();
			return;
		}
		//if disliked, remove the dislike and add a like
		if(this.dislikedComments.contains(comment)) {
			comment.decreaseDislikes();
			comment.increaseLikes();
			return;
		}
		comment.increaseLikes();
		this.likedComments.add(comment);
	}
	//done
	public void dislike(Video video) {
		if(video == null) {
			return;
		}
		if(this.dislikedVideos.contains(video)) {
			video.decreaseDislikes();
		}
		if(this.likedVideos.contains(video)) {
			video.decreaseLikes();
			video.increaseDislikes();
			return;
		}
		video.increaseDislikes();
		this.dislikedVideos.add(video);
	}
	//done
	public void dislike(Comment comment) {
		if(comment == null) {
			return;
		}
		if(this.dislikedComments.contains(comment)) {
			comment.decreaseDislikes();
		}
		if(this.likedComments.contains(comment)) {
			comment.decreaseLikes();
			comment.increaseDislikes();
			return;
		}
		comment.increaseDislikes();
		this.dislikedComments.add(comment);
	}
	//done
	public void addVideoToPlayList(PlayList playList, Video video) {
		if(playList == null || !this.playLists.contains(playList)) {
			System.out.println("You don't have such playlist.");
		}
		if(video != null) {
			playList.addVideo(video);
		}
	}

	//done
	public void removeVideoFromPlayList(PlayList playList, Video video) {
		if(playList == null || !this.playLists.contains(playList)) {
			System.out.println("You don't have such playlist.");
		}
		if(playList.getVideos().contains(video)) {
			playList.removeVideo(video);
		}
	}
	
	public void logOut() {
		this.loggedIn = false;
	}
	
	//done
	private boolean emailCheck(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		if(email.matches(regex)) {
			return true;
		}
		return false;
	}
	//done
//	private boolean nameCheck(String name) {
//		if(name != null 
//				&& name.length() >= this.minNameLength 
//				&& name.length() <= this.maxNameLength 
//				&& !youtube.existingUserName(name)){
//			return true;
//		}
//		return false;
//	}
	//same
	private boolean isLogged() {
		if(!this.loggedIn) {
			//redirect to register page
			return false;
		}
		return true;
	}

	public String getName() {
		return username;
	}

	public String getEmail() {
		return email;
	}
	
	//add users to sets by their name and email
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
