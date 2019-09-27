import React, {Component} from 'react'
//import BottomBar from './BottomBar'
import './PostContainer.css'
//import CommentBox from './CommentBox'
import WallDataService from '../../api/todo/WallDataService.js'
import AuthenticationService from './AuthenticationService.js'
import {withRouter} from 'react-router-dom'
import moment from 'moment'


class PostContainer extends Component {
    
    constructor(props){
        console.log(" post constructor")
        super(props)
        this.state ={
            posts:[]
        }
        this.refreshPosts=this.refreshPosts.bind(this)
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
        let username = AuthenticationService.getLoggedInUserName()
        WallDataService.retrieveAllVisiblePosts(username)
        .then(response=>this.setState({
            posts:response.data
        }))
          console.log(this.state)
    }

    editPostButton(postID){
        console.log('update post' + postID)
        this.props.history.push(`wall/${postID}`)
    }


    deletePostButton(postID){
        console.log('delete post' + postID)
        let username = AuthenticationService.getLoggedInUserName()
        WallDataService.deletePost(username, postID)
    }

    addPostClicked(){
        console.log("new post button clicked")
        this.props.history.push(`/wall/-1`)
    }

    render(){
       let username = AuthenticationService.getLoggedInUserName()
        const userImage = "http://placekitten.com/300/200"
        return (
            
            
                   <div>
                       <div><button className="newPostButton" onClick={this.addPostClicked}> Create New Post :)</button></div>
                   {
                       this.state.posts.map((post)=>(
                        <div  className="postContainer">
                        <div className="userImage">
                        <img className ="profilePic" src={userImage} alt="Profile Pic"></img>

                            <div className ="timeStamp">{moment(post.creationTime).format('DD-MM-YYYY HH:MM')}</div>
                        </div>
                        <div className="id"> {post.postId} </div>
                        <div>
                            <button className ="deleteButton" onClick ={()=>this.deletePostButton(username,post.postID)}>Delete</button>
                        </div>
                        <div>
                            <button className ="editButton" onClick ={()=>this.editPostButton(post.postID)}>Edit</button>
                        </div>
                        <div className="userInput">{post.message}</div>
                        <hr></hr>
                       <div>{/*<BottomBar />*/}</div>
                        
                        <div>{
                            (typeof(post.comments)=='object')? 
                            <div>
                                {
                                    post.comments.map((commentBox)=>
                                    <div>
                                        <hr></hr>
                                <div>{/*<CommentBox commentbox={commentBox}/>*/}</div>
                                    </div>)
                                }
                            </div>: null
                        }</div>
                    </div>
                    ))
                   }

                    </div>
               
        );
     }

}


export default withRouter(PostContainer)