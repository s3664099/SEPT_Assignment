package com.sept.rest.webservices.restfulwebservices.entities;

import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import com.sept.rest.webservices.user.Students;

@Entity
public class Comments {
	
	public Comments() {
		
	}
	
	public Comments(Long commentID, int authorID, Integer parentID, String message, Timestamp creation_Time, Timestamp modified_Time,
			boolean deleted, boolean edited) {
		super();
		this.commentId = commentID;
		this.authorId = authorID;
		this.parentId = parentID;
		this.message = message;
		creationTime = creation_Time;
		modifiedTime = modified_Time;
		this.deleted = deleted;
		this.edited = edited;
	}
	
	//basic post variables
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long commentId;
	private int authorId;
	private Integer parentId;
	private String message;
	private Timestamp creationTime;
	private Timestamp modifiedTime;
	private boolean deleted;
	private boolean edited;
	private String authorName = null;
	
	public Long getCommentID() {
		return commentId;
	}
	public void setCommentID(Long postID) {
		commentId = postID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getAuthorID() {
		return authorId;
	}
	public void setAuthorID(int ownerID) {
		authorId = ownerID;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isEdited() {
		return edited;
	}
	public void setEdited(boolean edited) {
		this.edited = edited;
	}
	public Timestamp getCreation_Time() {
		return creationTime;
	}
	public Timestamp getModified_Time() {
		return modifiedTime;
	}
	public void setCreation_Time(Timestamp creation_Time) {
		creationTime = creation_Time;
	}
	public void setModified_Time(Timestamp modified_Time) {
		modifiedTime = modified_Time;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
//	//generate a list to store any comments on the posts
//	private List<WallPosts> Comments = new ArrayList<WallPosts>();
//	
//	//A list to store the users who like the post
//	private List<Students> Likes = new ArrayList<Students>();


	
	//Creates the initial post that was submitted by the user
	//This constructor is called from the front end
	
	
	
//	//Getter and the setter for database
//	//This getter and setter is the one used for the database when the information
//	//is pulled down and a new copy of the post is required.
//	public WallPosts(int studentNumber, Long postId, String post, Date date, Date modDate, boolean modified) {
//		
//		this.OwnerID = studentNumber;
//		
//		this.Message = post;
//		
//		this.PostID = postId;
//
//		Deleted = true;
//		
//		this.Modified_Time = modDate;
//		
//		this.Edited = modified;
//		
//		//creates a timestamp for the post
//		this.Creation_Time = date;
//	}
	
//	public WallPosts(int long1, String Message, Date date) {
//		this.OwnerID = long1;
//		this.Message = Message;
//		this.Creation_Time = date;
//	}

//	public void setDate(Date date) {
//		
//		this.Creation_Time = date;
//		
//	}
//	
//	public void setUser(int StudentID) {
//		this.OwnerID = StudentID;
//	}
//	
//	//getter and setter for modifications to the post
//	public void setModDate() {
//		
//		//sets the mod date
//		Modified_Time = new Date();
//		
//		//checks whether the post has been modified
//		if (!Edited) {
//			Edited = !Edited;
//		}
//		
//	}
//	
//	public Date getModDate() {
//		
//		return Modified_Time;
//	}
//	
//	public boolean getModFlag() {
//
//		return Edited;
//	}
//	
//	//This method toggles the display value
//	public void setDisplay() 
//	{
//		//if the display is set to true, it is visible,
//		//otherwise it is not visible. The delete option flicks the display
//		Deleted = !Deleted;
//	}
//			
//	//returns the current display setting
//	public boolean getDisplay()
//	{
//		return Deleted;
//	}
//	
//	//removes a like, if the users no longer likes the post
//	public void removeLike(Students liker)
//	{
//		
//		boolean foundLiker = false;
//		Students liketoRemove = null;
//		
//		//checks through the users that have liked the post
//		for (Students like:Likes)
//		{
//			//if the student has been found
//			if(like.getStudentID() == liker.getStudentID())
//			{
//				foundLiker = true;
//				liketoRemove = like;
//			}
//		}
//		
//		if (foundLiker)
//			Likes.remove(liketoRemove);
//	}
//	
//	public boolean likePost(Students liker)
//	{
//		//sets flag to determine whether the user has already liked the post
//		boolean alreadyLiked = false;
//		
//		//checks through the users that have liked the post
//		for (Students like:Likes)
//		{
//			//if the student has been found
//			if(like.getStudentID() == liker.getStudentID())
//
//				//the flag is set
//				alreadyLiked = true;
//		}
//		
//		//if the flag has not been set
//		if(!alreadyLiked)
//
//			//the user is added to the list of people who liked the post
//			Likes.add(liker);
//		
//		return alreadyLiked;
//	}
//	
//	//setter
//	public void editPost(String post)
//	{
//		this.Message = post;
//		this.Edited = true;
//		this.Modified_Time = new Date();
//	}
//	
//	//getters
//	public int getUser()
//	{
//		return OwnerID;
//	}
//	
//	public String getPost()
//	{
//		return Message;
//	}
//	
//	public Date getDate()
//	{
//		return Creation_Time;
//	}
//	
//	public Long getId()
//	{
//		return PostID;
//	}
//	
//	public int getNoLikes()
//	{
//		//returns the number of users who have liked the post
//		return Likes.size();
//	}

}
