import React, {Component} from 'react'
import BottomBar from './BottomBar'
import './PostContainer.css'
import CommentBox from './CommentBox'
/*
var myInit ={
    method:'GET',
    headers:{
        'Content-Type':'application/json'
    },
    mode:'cors',
    cache:'default'
};
let myRequest = new Request('http://localhost:3000/postbox', myInit);
*/

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
        fetch('http://localhost:3000/post')
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
                       this.state.posts.map((post)=>(
                        <div className="postContainer">
                        <div className="userImage">
                        <img className ="profilePic" src={userImage}></img>
                            <div className ="timeStamp">{post.postTime}</div>
                        </div>
                        <div className="userName"> {post.UserName} </div>
                        <div>
                            <button className ="editButton">Edit/Del</button>
                        </div>
                        <div className="userInput">{post.postContent}</div>
                        <hr></hr>
                        <div><BottomBar /></div>
                        <hr></hr>
                        <div><CommentBox /></div>
                    </div>
                    ))
                   }
                    </div>
               
        );
     }

}


export default PostContainer 