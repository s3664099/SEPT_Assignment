import React, { Component } from 'react'



class CommentBox extends Component {



    render() {
        return (
            <div className="bottomBar">
               <div className = "userName">{/*this.props.commentbox.UserName*/}</div> 
               <div className = "comment">{/*this.props.commentbox.comment*/}</div> 
                <div className = "time">{/*this.props.commentbox.commentTime*/}</div>
            </div>
        )
    }
}

export default CommentBox