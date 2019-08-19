import React, {Component} from 'react'
import BottomBar from './BottomBar'
import './PostContainer.css'
import CommentBox from './CommentBox'

class PostContainer extends Component {

    render(){
        const userInput = "this is a paragraph"
        const userImage = "http://placekitten.com/300/200"
        const userName = "userName"
        const timeEntered = new Date().getHours()%12
        return (
            <div className="postContainer">
                <div className="userImage">
                <img className ="profilePic" src={userImage}></img>
                    <div className ="timeStamp">{timeEntered}pm</div>
                </div>
                <div className="userName"> {userName} </div>
                <div>
                    <button className ="editButton">Edit/Del</button>
                </div>
                <div className="userInput">{userInput}</div>
                <hr></hr>
                <div><BottomBar /></div>
                <hr></hr>
                <div><CommentBox /></div>
            </div>
        )
    }
}


export default PostContainer 