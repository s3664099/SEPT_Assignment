import React, {Component} from 'react'
import BottomBar from './BottomBar'
import './PostContainer.css'
import CommentBox from './CommentBox'
import WallDataService from '../../api/todo/WallDataService.js'
import AuthenticationService from './AuthenticationService.js'
import {withRouter} from 'react-router-dom'
//import moment from 'moment'


// import Popup from "reactjs-popup"
// import NewPost from './NewPost.jsx'



class OtherPost extends Component {

  constructor(props){
    console.log(" post constructor")
    super(props)
    this.state ={
      name: this.props.match.params.name,
      posts:[]
    }
    console.log(this.state)
    this.refreshPosts = this.refreshPosts.bind(this)
    this.addPostClicked = this.addPostClicked.bind(this)
    this.editPostButton = this.editPostButton.bind(this)
    this.deletePostButton = this.deletePostButton.bind(this)
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
    this.props.history.push(`wall/edit/${postID}`)
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
    this.props.history.push(`/wall/create/-1`)
  }

    render(){

        const userImage = "http://placekitten.com/300/200"

        return (


            <div className= 'container'>
           {/* <div><button className="newPostButton" onClick={this.addPostClicked}> Create New Post :)</button></div>*/}
        {
            this.state.posts.map((post)=>(

             <div  className="postContainer">
             <div className="userImage">
             <img className ="profilePic" src={userImage} alt="Profile Pic"></img>
             <div className="userName">{this.state.name}</div>

             </div>

             <div className="userInput">{post.message}</div>
             <div className ="timeStamp">{/*moment(post.creationTime).format('DD-MM-YYYY HH:MM')*/}</div>
             <div className="postSetting">
             {/*<button className ="commentButton" onClick ={()=>this.showHideComments()}>Comments</button>
             <button className ="editButton" onClick ={()=>this.editPostButton(post.postID)}>Edit</button>
             <button className ="deleteButton" onClick ={()=>this.deletePostButton(post.postID)}>Delete</button>*/}
             </div>
             <hr></hr>
             <div>{<BottomBar />}</div>

             <div>

             <CommentBox id="commentSection" postID={post.postID} username={this.state.name}/>

             </div>
         </div>
         ))
        }
         </div>

        );
     }


}


export default withRouter(OtherPost)
