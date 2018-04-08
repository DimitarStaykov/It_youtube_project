package youtube;

public class Video extends Post{

	private String title;
	private double views;
	private int durationInSeconds;
	private int numberOfComments;
	
	
	public void sortCommentsByMostPopular() {
		
	}
	
	public void sortCommentsByNewest() {
		
	}

	public String getTitle() {
		return title;
	}

	public double getViews() {
		return views;
	}

	public int getDurationInSeconds() {
		return durationInSeconds;
	}

	public int getNumberOfComments() {
		return numberOfComments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Video other = (Video) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
}
