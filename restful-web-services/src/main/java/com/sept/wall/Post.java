import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Post {
	
	//basic post variables
	private int postId;
	private LocalDate date;
	private String post;
	private User user;
	private boolean display;
	
	//this is called when the post is a comment
	private int parentPostId;
	
	//generate a list to store any comments on the posts
	private List<Post> Comments = new ArrayList<Post>();
	
	//A list to store the users who like the post
	private List<User> Likes = new ArrayList<User>();

	//Creates the initial post that was submitted by the user
	//This constructor is called from the front end
	public Post(User user, int postId, String post) {
		
		//This is the owner/creator of the post
		//At this stage posts can only be posted on the user's wall
		this.user = user;
		
		//The text message contained within the post
		this.post = post;
		
		//The post Id is generated based on the ID of the previous
		//post for the user.
		this.postId = postId;
		
		//sets display post to true as this is coming from the front end
		//Thus, it is assumed that a new post will be want to be displayed
		this.display = true;
		
		//creates a timestamp for the post
		this.date = LocalDate.now();
	}
	
	//This method toggles the display value
	public void setDisplay() 
	{
		display = !display;
	}
	
	//returns the current display setting
	public boolean getDisplay()
	{
		return display;
	}

}
