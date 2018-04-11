package model;

import java.util.Set;

public class Comment {

	private int likes;
	private int dislikes;
	private Set<Comment> comments;
	private Date date;
	private User postedBy;
	private Video inVideo;
	
	
	
	public Comment(){}
		
	
	
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
	public Video getInVideo() {
		return inVideo;
	}
	public void setInVideo(Video inVideo) {
		this.inVideo = inVideo;
	}
	
	
	
	
}
