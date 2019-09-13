import React, {Component} from 'react'
//import BottomBar from './BottomBar'
import './PostContainer.css'
//import CommentBox from './CommentBox'
import '../../api/todo/WallDataService.js'
import axios from 'axios'

var studentId = 1;


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
       fetch('http://localhost:8080/users/1/PostVisible')
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
                        <img className ="profilePic" src={userImage}></img>
                            <div className ="timeStamp">{post.date}</div>
                        </div>
                        <div className="userName"> {/*post.UserName*/} </div>
                        <div>
                            <button className ="editButton">Edit/Del</button>
                        </div>
                        <div className="userInput">{post.post}</div>
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