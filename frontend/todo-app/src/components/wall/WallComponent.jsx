import React, { Component } from 'react'
import HeaderWall from './HeaderWall';
import AuthenticationService from '../AuthenticationService'
import PostContainer from './PostContainer';
import StudentList from '../students/StudentList';

class wallComponent extends Component {
  
    render() {
        const userName = AuthenticationService.getLoggedInUserName();
      return (
        <div className="Wall">
        <HeaderWall name = {userName}/>
        <StudentList/>
        <PostContainer />
        </div>
      );
    }
  }
export default wallComponent;
