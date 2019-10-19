import React, {Component} from 'react'
import './Wall.css'
import CommentBox from './CommentBox'
import WallDataService from './WallDataService.js'
import AuthenticationService from '../AuthenticationService.js'
import {withRouter} from 'react-router-dom'





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

  likePostButton(postID){
    console.log('like post' + postID)
    let username = AuthenticationService.getLoggedInUserName()

    WallDataService.likePost(username, postID)
    .then(response=>{
      this.refreshPosts()
    })
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
             <div className="Likes">{post.likes}<button className = "likeButton" onClick ={()=>this.likePostButton(post.postID)}>Like</button></div>
             </div>
             <hr></hr>

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
