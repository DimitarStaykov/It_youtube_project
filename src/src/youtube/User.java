package youtube;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private static YouTube youtube;
	private String name;
	private String password;
	private String email;
	private Set<User> subscriberList;
	private Set<Video> favouriteVideoList;
	private Set<PlayList> playLists;
	private Set<Video> uploadedVideos;
	private boolean loggedIn;
	private final int minNameLength = 6;
	private final int maxNameLength = 20;
	
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
	
	public void changeName(String newName) {
		if(nameCheck(newName)) {
			this.name = newName;
		}
		else {
			System.out.println("Your username couldn't be changed.");
		}
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
	
	private boolean nameCheck(String name) {
		if(name != null 
				&& name.length() >= this.minNameLength 
				&& name.length() <= this.maxNameLength 
				&& !youtube.existingUserName(name)){
			return true;
		}
		return false;
	}
	
	private boolean isLogged() {
		if(!this.loggedIn) {
			//redirect to register page
			return false;
		}
		return true;
	}

	public String getName() {
		return name;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
