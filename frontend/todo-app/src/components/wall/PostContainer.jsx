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
    


    addPostClicked(){
        console.log("new post button clicked")
        this.props.history.push(`/wall/-1`)
    }

    render(){
       
        const userImage = "http://placekitten.com/300/200"
        return (
            
                   <div>
                       <div><button className="newPostButton" onClick={this.addPostClicked}> Create New Post :)</button></div>
                   {
                       this.state.posts.map((post)=>(
                        <div key={post.postId} className="postContainer">
                        <div className="userImage">
                        <img className ="profilePic" src={userImage} alt="Profile Pic"></img>

                            <div className ="timeStamp">{moment(post.creationTime).format('DD-MM-YYYY HH:MM')}</div>
                        </div>
                        <div className="creationTime"> {} </div>
                        <div>
                            <button className ="deleteButton">Delete</button>
                        </div>
                        <div>
                            <button className ="editButton">Edit</button>
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