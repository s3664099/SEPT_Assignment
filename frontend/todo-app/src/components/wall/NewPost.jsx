import React, { Component } from 'react'
import { Formik, Form, Field} from 'formik';
import WallDataService from '../../api/todo/WallDataService';
import AuthenticationService from './AuthenticationService.js'
import moment from 'moment'
import {withRouter} from 'react-router-dom'

class NewPost extends Component{

    
    constructor(props){
        super(props)
        this.state ={
            postId: this.props.match.params.postId,
            postContent:'',
            ownerId: '',
            postTime: moment(new Date()).format('DD-MM-YYYY HH:MM')
        };
        
        this.handleSubmit = this.handleSubmit.bind(this)
    }
        

    componentDidMount(){
        
        if(this.state.postId === -1){
            return
        }

        let username = AuthenticationService.getLoggedInUserName()

        WallDataService.retrievePost(username, this.state.postId)
        .then(response=>this.setState({
            postContent:response.data.message,
            ownerId:response.data.ownerId,
            postTime: moment(response.data.creationTime).format('DD-MM-YYYY HH:MM')
            
        }))


    }

    handleSubmit(event){
        let username = AuthenticationService.getLoggedInUserName()
        let id = this.state.postId;
        let post={
            postId:this.state.postId,
            ownerId: this.state.ownerId,
            message:event.postContent,
            creationTime: this.state.postTime
        }
        console.log(this.state.postId)
        if(id === -1){
            console.log("create new post")
            WallDataService.createPost(username, post)
            .then(()=>this.props.history.push('/wall'))
        }else{
            console.log("update new post")
            WallDataService.toUpdatePost(username, this.state.postId, post)
            .then(
                console.log(this.props.history),
                () => this.props.history.push('/wall')
                )
            
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

export default withRouter(NewPost)