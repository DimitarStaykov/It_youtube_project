package youtube.user.model;

import java.util.Date;
import java.util.Set;

public class Video {

	private int likes;
	private int dislikes;
	private Set<Comment> comments;
	private Date date;
	private User postedBy;
	private String title;
	private String location;
	private double views;
	private int durationInSeconds;
	private int numberOfComments;
	
	
	public Video(String title,String location){	
		this.title = title;
		this.location = location;	
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}


	public int getDislikes() {
		return dislikes;
	}


	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}


	public Set<Comment> getComments() {
		return comments;
	}


	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public User getPostedBy() {
		return postedBy;
	}


	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getViews() {
		return views;
	}


	public void setViews(double views) {
		this.views = views;
	}


	public int getDurationInSeconds() {
		return durationInSeconds;
	}


	public void setDurationInSeconds(int durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}


	public int getNumberOfComments() {
		return numberOfComments;
	}


	public void setNumberOfComments(int numberOfComments) {
		this.numberOfComments = numberOfComments;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	};
	
	
	
}