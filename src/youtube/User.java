package youtube;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private String name;
	private String password;
	private String email;
	private Set<User> subscriberList;
	private Set<Video> favouriteVideoList;
	private Set<PlayList> playLists;
	private Set<Video> uploadedVideos;
	private boolean loggedIn;
	
	public void upload(Video v) {
		
	}
	
	public void deleteVideo(Video v) {
		
	}
	
	public void changeName(String newName) {
		
	}
	
	public void changePassword(String newPassword) {
		
	}
	
	public void changeEmail(String newEmail) {
		
	}
	
	public void subscribeTo(User user) {
		
	}
	
	public void comment(String commentMsg, Video video) {
		
	}
	
	public void reply(String replyMsg, Comment comment) {
		
	}
	
	public void like(Video video) {
		
	}
	
	public void like(Comment comment) {
		
	}
	
	public void dislike(Video video) {
		
	}
	
	public void dislike(Comment comment) {
		
	}
	
	public void addVideoToPlayList(PlayList playList, Video video) {
		
	}

	public void removeVideoFromPlayList(PlayList playList, Video video) {
		
	}
	
	public void logOut() {
		
	}
	
	private boolean isLogged() {
		if(!this.loggedIn) {
			//redirect to register page
			return false;
		}
		return true;
	}
	
}
