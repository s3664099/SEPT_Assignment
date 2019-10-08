import React, { Component } from 'react'
import CommentDataServcie from '../../api/todo/CommentDataServcie';




class CommentBox extends Component {

    constructor(props){
        console.log("comment box constructor")
        super(props)
        this.state ={
            comments:[],
            username: this.props.username,
            postID:this.props.postID
        }
        this.getComments = this.getComments.bind(this)
    }

    componentDidMount(){
        this.getComments();
    }

    
  componentWillUnmount() {
    console.log('componentWillUnmount on wall')
  }
/*
  shouldComponentUpdate(nextProps, nextState) {
    console.log('shouldComponentUpdate on wall')
    //console.log(nextProps)
    //console.log(nextState)
    return true
  }*/


    getComments(){
        //console.log(this.state.username)
        //console.log(this.state.postID)
        CommentDataServcie.retrieveComments(this.state.username, this.state.postID)
        .then(res => this.setState({
            comments:res.data
        }))
    }

    render() {
        
            console.log(this.state);
        
        
        return (

            <div className="bottomBar">
            
            {
                this.state.comments.map((comment)=>(
                    <div>
                    <div className ="authorID">author:{comment.authorID}</div>
                    <hr></hr>
                    <div className ="message">message:{comment.message}</div>
                    <div className ="timeStamp">{comment.modified_Time}</div>
                    </div>
                )) 
            }
            </div>
        )
    }
}

export default CommentBox