import React, { Component } from 'react'
import Popup from "reactjs-popup";
import Axios from 'axios';


const axios = require('axios');
class NewPost extends Component{

    
    constructor(props){
        super(props)
        this.state ={
          //  error:null,
          //  isLoaded:false,
          //  profileFetched:false,
            postContent:'',
            UserName:'',
            postTime:''
        };
        this.changeHandler = this.changeHandler.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
        


    componentDidMount(){
        fetch('http://localhost:3000/profile')
        .then(resp=>resp.json())
        .then(
            (result)=>{
                this.setState({
                    UserName:result.name
                });
            },
            (error)=>{this.setState({
                error, 
                //profileFetched:false
            });
        }
        )

    }

    handleSubmit(event){
        event.preventDefault();
        axios
        .post('http://localhost:3000/post', 
        {
            UserName: this.state.UserName,
            postContent:this.state.postContent,
            postTime:this.state.postTime
        }
        )
        .then(res=>{
            console.log(res)
        })
        .catch(error=>{
            console.log(error)
        })
    }

    changeHandler(event){
        var time = new Date().toLocaleString()
        this.setState({
            postContent:document.getElementById('content').value,
            postTime:time
        }
        );
    }

    render() {
        const {postContent, UserName, postTime} = this.state
        return (
            <div className="newPoster">

               <Popup id = "newPostPop" trigger={<button className="newPostButton"> Create New Post </button>}
      modal
      closeOnDocumentClick>
            <div>
            <p>Create New Post</p>
            <p>{UserName}</p>
            <form onSubmit = {this.handleSubmit}>
              <textarea 
              name= {UserName}
              id = 'content'
              value = {postContent}
              onChange = {this.changeHandler}
              rows="10" cols="100" placeholder="Write your status..."></textarea>
              <br/>
              <input type="submit"/>
              </form>
            </div>
            </Popup>
            </div>
        );
    }
}

export default NewPost