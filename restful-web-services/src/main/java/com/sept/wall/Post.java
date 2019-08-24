package com.sept.wall;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Post {
	
	//basic post variables
	private int postId;
	private Date date;
	private String post;
	private int studentNumber;
	private boolean display;
	private boolean modified;
	private Date modDate;
	
	//this is called when the post is a comment
	private int parentPostId;
	
	//generate a list to store any comments on the posts
	private List<Post> Comments = new ArrayList<Post>();
	
	//A list to store the users who like the post
	private List<User> Likes = new ArrayList<User>();

	public Post(int postId, String post, Date date) {
		//The text message contained within the post
		this.post = post;
		
		//The post Id is generated based on the ID of the previous
		//post for the user.
		this.postId = postId;
		
		//sets display post to true as this is coming from the front end
		//Thus, it is assumed that a new post will be want to be displayed
		display = true;
		
		//creates a timestamp for the post
		this.date = date;
	}
	
	//Creates the initial post that was submitted by the user
	//This constructor is called from the front end
	public Post(int studentNumber, int postId, String post, Date date) {
		
		//This is the owner/creator of the post
		//At this stage posts can only be posted on the user's wall
		this.studentNumber = studentNumber;
		
		//The text message contained within the post
		this.post = post;
		
		//The post Id is generated based on the ID of the previous
		//post for the user.
		this.postId = postId;
		
		//sets display post to true as this is coming from the front end
		//Thus, it is assumed that a new post will be want to be displayed
		display = true;
		
		//creates a timestamp for the post
		this.date = date;
	}
	
	//This method toggles the display value
	public void setDisplay() 
	{
		//if the display is set to true, it is visible,
		//otherwise it is not visible. The delete option flicks the display
		display = !display;
	}
	
	//returns the current display setting
	public boolean getDisplay()
	{
		return display;
	}
	
	//removes a like, if the users no longer likes the post
	public void removeLike(User liker)
	{
		
		boolean foundLiker = false;
		User liketoRemove = null;
		
		//checks through the users that have liked the post
		for (User like:Likes)
		{
			//if the student has been found
			if(like.studentId == liker.studentId)
			{
				foundLiker = true;
				liketoRemove = like;
			}
		}
		
		if (foundLiker)
			Likes.remove(liketoRemove);
	}
	
	public boolean likePost(User liker)
	{
		//sets flag to determine whether the user has already liked the post
		boolean alreadyLiked = false;
		
		//checks through the users that have liked the post
		for (User like:Likes)
		{
			//if the student has been found
			if(like.studentId == liker.studentId)

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
		this.post = post;
	}
	
	//getters
	public int getUser()
	{
		return studentNumber;
	}
	
	public String getPost()
	{
		return post;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public int getId()
	{
		return postId;
	}
	
	public int getNoLikes()
	{
		//returns the number of users who have liked the post
		return Likes.size();
	}

}
