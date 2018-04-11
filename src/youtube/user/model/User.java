package youtube.user.model;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import youtube.Comment;
import youtube.PlayList;
import youtube.Video;
import youtube.YouTube;

public class User {

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
	protected static final int MIN_NAME_LENGTH = 6;
	protected static final int MAX_NAME_LENGTH = 20;
	//possible info for separate class , To be discussed further
	private Set<Video> recentlyWatched; // can be default playlist object created with the user
	//  we add a pointer after a video is watched
	private Set<Comment> recentComments; // same principle as with videos, pointer to every comment is added here
	private Set<String> searchInputs; // a collection for search inputs 
		
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public User(int id, String username, String email, String password) {
		this(username, email, password);
		this.id = id;
	}
	
	//setters
	public void setName(String name) {
		this.username = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	//getters
	public String getName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Set<User> getSubscriberList() {
		return subscriberList;
	}

	public Set<Video> getFavouriteVideoList() {
		return favouriteVideoList;
	}

	public List<PlayList> getPlayLists() {
		return playLists;
	}

	public Set<Video> getUploadedVideos() {
		return uploadedVideos;
	}

	public Set<Video> getLikedVideos() {
		return likedVideos;
	}

	public Set<Video> getDislikedVideos() {
		return dislikedVideos;
	}

	public Set<Comment> getLikedComments() {
		return likedComments;
	}

	public Set<Comment> getDislikedComments() {
		return dislikedComments;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public Set<Video> getRecentlyWatched() {
		return recentlyWatched;
	}

	public Set<Comment> getRecentComments() {
		return recentComments;
	}

	public Set<String> getSearchInputs() {
		return searchInputs;
	}

}
