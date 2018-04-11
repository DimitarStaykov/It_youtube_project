package youtube.user.model;

import java.util.ArrayList;
import java.util.Date;

public class Playlist {

	private String name;
	private int numberOfVideos;
	private User user;
	private ArrayList<Video> videos;
	private boolean privateP; //if not private -> public
	private Date date;
	
	
	
	public Playlist(){}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfVideos() {
		return numberOfVideos;
	}
	public void setNumberOfVideos(int numberOfVideos) {
		this.numberOfVideos = numberOfVideos;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<Video> getVideos() {
		return videos;
	}
	public void setVideos(ArrayList<Video> videos) {
		this.videos = videos;
	}
	public boolean isPrivateP() {
		return privateP;
	}
	public void setPrivateP(boolean privateP) {
		this.privateP = privateP;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
}