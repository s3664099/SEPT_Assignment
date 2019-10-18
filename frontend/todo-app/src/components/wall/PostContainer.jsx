import React, {Component} from 'react'
import './PostContainer.css'
import CommentBox from './CommentBox'
import WallDataService from '../../api/todo/WallDataService.js'
import AuthenticationService from './AuthenticationService.js'
import {withRouter} from 'react-router-dom'
import moment from 'moment'


// import Popup from "reactjs-popup"
// import NewPost from './NewPost.jsx'


class PostContainer extends Component {


  constructor(props){
    console.log(" post constructor")
    
    super(props)
    this.state ={
      name: this.props.match.params.name,
      posts:[]
    }

    //name = this.props.match.params.name;

    console.log(this.state)
    this.refreshPosts = this.refreshPosts.bind(this)
    this.addPostClicked = this.addPostClicked.bind(this)
    this.editPostButton = this.editPostButton.bind(this)
    this.deletePostButton = this.deletePostButton.bind(this)
    this.likePostButton = this.likePostButton.bind(this)
  }

  componentWillUnmount() {
    console.log('componentWillUnmount on wall')
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log('shouldComponentUpdate on wall')
    console.log(nextProps)
    console.log(nextState)
    return true
  }

  componentDidMount()
  {
    this.refreshPosts();
  }

  refreshPosts(){   
    if (this.state.name === undefined) {
      let username = AuthenticationService.getLoggedInUserName()
      WallDataService.retrieveAllVisiblePosts(username)
      .then(response=>this.setState({
        posts:response.data
      }))
    } else {
      WallDataService.retrieveAllVisiblePosts(this.state.name)
      .then(response=>this.setState({
        posts:response.data
      }))
    }
    console.log(this.state)
  }

  editPostButton(postID){
    console.log('update post' + postID)
    this.props.history.push(`/wall/${postID}`)
  }

  likePostButton(postID){
    console.log('like post' + postID)
    let username = AuthenticationService.getLoggedInUserName()
    WallDataService.likePost(username, postID)
    .then(response=>{
      this.refreshPosts()
    })
  }

  deletePostButton(postID){
    console.log('delete post' + postID)
    let username = AuthenticationService.getLoggedInUserName()
    WallDataService.deletePost(username, postID)
    .then(response=>{
      this.refreshPosts()
    })
  }

  addPostClicked(){
    console.log("new post button clicked")
    this.props.history.push(`/wall/-1`)
  }

  showHideComments() {
    var comment = document.getElementById("commentSection")
    if(comment.style.display ==="none"){
    comment.style.display ="block"
    }else{
    comment.style.display = "none"
    }
  }

    render(){
      let username = AuthenticationService.getLoggedInUserName()

        const userImage = "http://placekitten.com/300/200"

        return (


                   <div className= 'container'>
                       <div><button className="newPostButton" onClick={this.addPostClicked}> Create New Post</button></div>
                   {
                       this.state.posts.map((post)=>(

                        <div  className="postContainer">
                        <div className="userImage">
                        <img className ="profilePic" src={userImage} alt="Profile Pic"></img>
                        <div className="userName">{username}</div>

                        </div>
                        {/*<div className="id"> {console.log(post.postID)} </div>*/ }

                        <div className="userInput">{post.message}</div>
                        <div className ="timeStamp">{moment(post.creationTime).format('DD-MM-YYYY HH:MM')}</div>
                        <div className="postSetting">
                        {/*<button className =f"commentButton" onClick ={()=>this.showHideComments()}>Comments</button>*/}
                        <div className="Likes">{post.likes}<button onClick ={()=>this.likePostButton(post.postID)}>Like</button></div>
                        <button className ="editButton" onClick ={()=>this.editPostButton(post.postID)}>Edit</button>
                        <button className ="deleteButton" onClick ={()=>this.deletePostButton(post.postID)}>Delete</button>
                        </div>
                        <hr></hr>

                        <div>

                        <CommentBox id="commentSection" postID={post.postID} username={username}/>

                        </div>
                    </div>
                    ))
                   }
                    </div>

        );
     }
/*
    );
  }
*/

}


export default withRouter(PostContainer)
//withRouter(PostContainer)
