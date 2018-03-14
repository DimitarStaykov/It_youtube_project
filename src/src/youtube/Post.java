package youtube;

import java.util.Date;
import java.util.Set;

public abstract class Post {
	
	private int likes;
	private int dislikes;
	private Set<Comment> comments;
	private Date date;
	private User postedBy;
	private boolean isEdited;

}
