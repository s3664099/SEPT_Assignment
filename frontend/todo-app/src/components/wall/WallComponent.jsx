import React, { Component } from 'react'
import HeaderWall from './HeaderWall';
import AuthenticationService from '../todo/AuthenticationService'
// import SideNavBar from './SideNavBar';
import PostContainer from './PostContainer';
// import ActivityNavBar from './ActivityNavBar'
// <!--<SideNavBar />
// <ActivityNavBar/>-->

class wallComponent extends Component {


    render() {
        const userName = AuthenticationService.getLoggedInUserName();
      return (
        <div className="Wall">
        <HeaderWall name = {userName}/>
        <PostContainer/>
        </div>
      );
    }
  }
export default wallComponent;
