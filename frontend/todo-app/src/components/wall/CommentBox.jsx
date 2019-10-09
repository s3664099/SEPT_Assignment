import React, { Component } from 'react'
import CommentDataServcie from '../../api/todo/CommentDataServcie';
import './CommentBox.css'
import { Formik, Form, Field} from 'formik';



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
        this.handleSubmit = this.handleSubmit.bind(this)
        this.deleteComments = this.deleteComments.bind(this)
    }

    componentDidMount(){
        this.getComments();
    }

  componentWillUnmount() {
    //console.log('componentWillUnmount on wall')
  }
  

/*
  shouldComponentUpdate(nextProps, nextState) {
    console.log('shouldComponentUpdate on wall')
    //console.log(nextProps)
    //console.log(nextState)
    return true
}*/
/*
  hideButton(){
      var comment = document.getElementById("commentSection")
      if(comment.style.display ==="none"){
          comment.style.display ="block"
      }else{
          comment.style.display = "none"
      }
  }*/

  deleteComments(commentID){
      CommentDataServcie.deleteComments(this.state.username, commentID)
      .then(()=>{
          this.getComments()
      })
  }

    getComments(){
        CommentDataServcie.retrieveComments(this.state.username, this.state.postID)
        .then(res => this.setState({
            comments:res.data
        }))
    }

/*
authorID: 3691487
commentID: 4
creation_Time: "2019-09-20T10:04:45.000+0000"
deleted: false
edited: false
message: "fake comment"
modified_Time: "2019-09-20T10:04:45.000+0000"
parentId: 131 
*/
    handleSubmit(event){
        let comment ={
            message:event.postComment,
            parentId:this.state.postID
            }
            
        CommentDataServcie.postComments(this.state.username, this.state.postID, comment)
        .then(()=>{
            this.getComments()
        })
        console.log(comment)
    }

    render() {
        
            console.log(this.state);
        
        return (
            <div className="commentSection">
            <button className="commentButton" /*onClick = {this.hideButton()}*/>Comment</button>
            <Formik
                        
                        validateOnChange={false}
                        validateOnBlur={false}
                        onSubmit={this.handleSubmit}
                        enableReinitialize={true}
                    >
            <Form>
                     <Field type="text" name="postComment"/>
                     <input type="submit" value = "Submit"/>
             </Form>
             </Formik>
             
            {
                this.state.comments.map((comment)=>(
                    <div>
                    <div className ="authorID">author:{comment.authorID}</div>
                    <hr></hr>
                    <div className ="message">message:{comment.message}</div>
                    <div className ="timeStamp">{comment.modified_Time}</div>
                    <button className="deleteButton" onClick = {()=>this.deleteComments(comment.commentID)}>Delete</button>
                    </div>
                )) 
            }
            </div>
        )
    }
}

export default CommentBox