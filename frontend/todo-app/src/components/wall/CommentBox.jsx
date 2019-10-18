import React, { Component } from 'react'
import CommentDataServcie from '../../api/todo/CommentDataServcie';
import './CommentBox.css'
import { Formik, Form, Field} from 'formik';
import moment from 'moment'
import AuthenticationService from '../wall/AuthenticationService'


class CommentBox extends Component {

  constructor(props){
    console.log("comment box constructor")
    super(props)
    this.state ={
      comments:[],
      username: this.props.username,
      postID:this.props.postID,
      showTheThing: false
    }
    this.getComments = this.getComments.bind(this)
    this.handleSubmit = this.handleSubmit.bind(this)
    this.deleteComments = this.deleteComments.bind(this)
    this.toggleHideButton = this.toggleHideButton.bind(this)
    this.likeCommentButton = this.likeCommentButton.bind(this)
  }

  componentDidMount(){
    this.getComments();
  }

  componentWillUnmount() {
    //console.log('componentWillUnmount on wall')
  }



deleteComments(commentID){
  CommentDataServcie.deleteComments(this.state.username, commentID)
  .then(()=>{
    this.getComments()
  })
}


  likeCommentButton(commentID){
    console.log('like comment' + commentID)
    let username = AuthenticationService.getLoggedInUserName()
    CommentDataServcie.likeComment(username, commentID)
    .then(response=>{
      this.getComments()
    })
  }

getComments(){
  CommentDataServcie.retrieveComments(this.state.username, this.state.postID)
  .then(res => this.setState({
    comments:res.data
  }))
}

handleSubmit(event){
  let author = AuthenticationService.getLoggedInUserName();
  let comment ={
    message:event.postComment,
    parentId:this.state.postID,
    authorName:author
  }

  CommentDataServcie.postComments(author, this.state.postID, comment)
  .then(()=>{
    this.getComments()
  })
  console.log(comment)
}

toggleHideButton() {
  this.setState({
    showTheThing: !this.state.showTheThing
  })  // to show it
}

countComments() {
  var number = this.state.comments.length
  return <text>Show comments ( + {number} + )</text>
}

render() {

  console.log(this.state);

  const userImage = "http://placekitten.com/300/200"
  const userImage2 = "https://i.redd.it/i8t6f16vdd421.jpg"

  return (
    <div>
    { this.state.showTheThing &&
      <div className="commentSection">
      <img className ="profilePic" src={userImage} alt="Profile Pic"></img>
      <Formik

      validateOnChange={false}
      validateOnBlur={false}
      onSubmit={this.handleSubmit}
      enableReinitialize={true}
      >
      <Form className = "commentForm">
      <Field type="text" name="postComment" placeholder="Say something..." className="postComment"/>
      <input type="submit" value = "Submit" className="postCommentButton" />
      </Form>
      </Formik>

      {
        this.state.comments.map((comment)=>(
          <div className = "commentArea">
            <img className ="profilePic2" src={userImage2} alt="Profile Pic"></img>
            <div className ="authorID">{comment.authorName}</div>
            <div className ="message">{comment.message}</div>
            <div className = "commentFooter">
              <div className ="timeStamp">{moment(comment.modified_Time).format('DD-MM-YYYY HH:MM')}</div>
              <div className="Likes">{comment.likes}<button onClick ={()=>this.likeCommentButton(comment.commentID)}>Like</button></div>
              <button className="deleteButton2" onClick = {()=>this.deleteComments(comment.commentID)}>Delete</button>
            </div>
          </div>
        ))
      }
      </div>
    }
    <button className="commentButton" onClick={this.toggleHideButton}>{this.state.showTheThing ? <text>Hide</text> : <text>Show comments ({this.state.comments.length})</text>}</button>
    </div>
  )
}
}

export default CommentBox
