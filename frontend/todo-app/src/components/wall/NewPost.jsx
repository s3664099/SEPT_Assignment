import React, { Component } from 'react'
import Popup from "reactjs-popup";
import { Formik, Form, Field, ErrorMessage } from 'formik';
import WallDataService from '../../api/todo/WallDataService';
import AuthenticationService from './AuthenticationService.js'
import moment from 'moment'

class NewPost extends Component{

    
    constructor(props){
        super(props)
        this.state ={
            postId: this.props.match.params.postId,
            postContent:'',
            ownerId: 1,
            username:'',
            postTime: moment(new Date()).format('DD-MM-YYYY HH:MM')
        };
        
        this.handleSubmit = this.handleSubmit.bind(this)
    }
        

    componentDidMount(){
        
        console.log(this.state.postId)
        
        if(this.state.postId ===-1){
            return
        }

        let username = AuthenticationService.getLoggedInUserName()

        WallDataService.retrievePost(username, this.state.postId)
        .then(response=>this.setState({
            postContent:response.data.message,
            ownerId:response.data.ownerId,
            postTime: moment(response.data.creationTime).format('DD-MM-YYYY HH:MM')
            
        }))

       this.setState={username: AuthenticationService.getLoggedInUserName}

    }

    handleSubmit(event){
        let username = AuthenticationService.getLoggedInUserName()
        let post={
            postId:this.state.postId,
            ownerId: 1,
            message:event.postContent,
            creationTime: this.state.postTime
        }
        console.log(this.state)
        if(this.state.postId == -1){
            console.log("create new post")
            WallDataService.createPost(username, post)
            .then(()=>this.props.history.push('/wall'))
        }else{
            console.log("update new post")
            WallDataService.updatePost(username, this.state.ownerId, post)
            .then(()=>this.props.history.push('/wall'))
        }
        console.log(event)
    }


    render() {
      const {postContent, postTime} = this.state
        let username = AuthenticationService.getLoggedInUserName()
        return (
            <div>
                <h1>New Post</h1>
                <h3>{username}</h3>
                <div className="newPost">
                    <Formik
                        initialValues={{ postContent, postTime }}
                        onSubmit={this.handleSubmit}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>
                                    <fieldset className="form-group">
                                        <label>Post content</label>
                                        <Field  type="text" name="postContent" />
                                    </fieldset>

                                    <button className="btn btn-success" type="submit">Submit</button>
                                </Form>
                            )
                        }
                    </Formik>

                </div>
            </div>

        );
    }
}

export default NewPost