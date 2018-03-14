package youtube;

import java.util.Set;

public class YouTube {

	private Set<User> users;
	private Set<Video> videos;
	
	public boolean upload(Video video) {
		if(this.videos.contains(video)) {
			System.out.println("There is existing video with the same title, rename it and try again.");
			return false;
		}
		this.videos.add(video);
		return true;
	}
	
	public void deleteVideo(Video video) {
		this.videos.remove(video);
	}
	
	public void addUser(User user) {
		
	}

	public boolean existingUserName(String name) {
		for (User user : users) {
			if(user.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
}
