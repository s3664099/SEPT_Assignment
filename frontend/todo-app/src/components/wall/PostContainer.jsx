import React, {Component} from 'react'
//import BottomBar from './BottomBar'
import './PostContainer.css'
//import CommentBox from './CommentBox'
import WallDataService from '../../api/todo/WallDataService.js'
import AuthenticationService from './AuthenticationService.js'



class PostContainer extends Component {

    
    constructor(props){
        super(props);
        this.state ={
            error : null,
            isLoaded: false,
            posts:[]
        };
    }
    
    componentDidMount(){
       let username = AuthenticationService.getLoggedInUserName()
       WallDataService.retrieveAllVisiblePosts(username)
        .then(res=>res.json())
        .then(
            (result)=>{
                this.setState({
                   isLoaded:true,
                   posts:result
                });
            },
            (error)=>{
                this.setState({
                    isLoaded:true,
                    error
                });
            }
        )
    }

    render(){
        
        const userImage = "http://placekitten.com/300/200"
        return (
                   <div>
                   {
                       this.state.posts.map((post,index)=>(
                        <div className="postContainer">
                        <div className="userImage">
                        <img className ="profilePic" src={userImage} alt="Profile Pic"></img>
                            <div className ="timeStamp">{post.creation_Time}</div>
                        </div>
                        <div className="userName"> {/*post.UserName*/} </div>
                        <div>
                            <button className ="editButton">Edit/Del</button>
                        </div>
                        <div className="userInput">{post.message}</div>
                        <hr></hr>
                       <div>{/*<BottomBar />*/}</div>
                        
                        <div>{
                            (typeof(post.comments)=='object')? 
                            <div>
                                {
                                    post.comments.map((commentBox,indexb)=>
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


export default PostContainer 