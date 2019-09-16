package com.sept.rest.webservices.wall;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sept.rest.webservices.user.Students;

@Entity
public class PostID {
	
	//basic post variables
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long PostID;
	private Date Creation_Time;
	private String Message;
	private int OwnerID;
	private boolean Deleted;
	private boolean Edited = false;
	private Date Modified_Time = null;
	
	
	//generate a list to store any comments on the posts
	private List<PostID> Comments = new ArrayList<PostID>();
	
	//A list to store the users who like the post
	private List<Students> Likes = new ArrayList<Students>();
	
	//constrictors
	public PostID(int studentNumber, Long postId, String post, Date date, Date modDate, boolean modified) {
		
		this.OwnerID = studentNumber;
		
		this.Message = post;
		
		this.PostID = postId;

		Deleted = true;
		
		this.Modified_Time = modDate;
		
		this.Edited = modified;
		
		//creates a timestamp for the post
		this.Creation_Time = date;
	}
	
	public PostID(int long1, String Message, Date date) {
		this.OwnerID = long1;
		this.Message = Message;
		this.Creation_Time = date;
	}
	
	public void addComment(PostID comment) {
		Comments.add(comment);
	}

	//getters & setters
	public void setDate(Date date) {
		
		this.Creation_Time = date;
		
	}
	
	public void setUser(int StudentID) {
		this.OwnerID = StudentID;
	}
	
	public Long getPostID()
	{
		return PostID;
	}
	
	//getter and setter for modifications to the post
	public void setModDate() {
		
		//sets the mod date
		Modified_Time = new Date();
		
		//checks whether the post has been modified
		if (!Edited) {
			Edited = !Edited;
		}
		
	}
	
	public Date getModDate() {
		
		return Modified_Time;
	}
	
	public boolean getModFlag() {

		return Edited;
	}
	
	//This method toggles the display value
	public void setDisplay() 
	{
		//if the display is set to true, it is visible,
		//otherwise it is not visible. The delete option flicks the display
		Deleted = !Deleted;
	}
			
	//returns the current display setting
	public boolean getDisplay()
	{
		return Deleted;
	}
	
	//removes a like, if the users no longer likes the post
	public void removeLike(Students liker)
	{
		
		boolean foundLiker = false;
		Students liketoRemove = null;
		
		//checks through the users that have liked the post
		for (Students like:Likes)
		{
			//if the student has been found
			if(like.getStudentID() == liker.getStudentID())
			{
				foundLiker = true;
				liketoRemove = like;
			}
		}
		
		if (foundLiker)
			Likes.remove(liketoRemove);
	}
	
	public boolean likePost(Students liker)
	{
		//sets flag to determine whether the user has already liked the post
		boolean alreadyLiked = false;
		
		//checks through the users that have liked the post
		for (Students like:Likes)
		{
			//if the student has been found
			if(like.getStudentID() == liker.getStudentID())

				//the flag is set
				alreadyLiked = true;
		}
		
		//if the flag has not been set
		if(!alreadyLiked)

			//the user is added to the list of people who liked the post
			Likes.add(liker);
		
		return alreadyLiked;
	}
	
	//setter
	public void editPost(String post)
	{
		this.Message = post;
		this.Edited = true;
		this.Modified_Time = new Date();
	}
	
	//getters
	public int getUser()
	{
		return OwnerID;
	}
	
	public String getPost()
	{
		return Message;
	}
	
	public Date getDate()
	{
		return Creation_Time;
	}
	
	public Long getId()
	{
		return PostID;
	}
	
	public int getNoLikes()
	{
		//returns the number of users who have liked the post
		return Likes.size();
	}

}
