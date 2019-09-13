import React, { Component } from 'react'

import HeaderWall from './HeaderWall';
import AuthenticationService from '../todo/AuthenticationService'
import SideNavBar from './SideNavBar';
import PostContainer from './PostContainer';

class wallComponent extends Component {
    
    render() {
        const userName = AuthenticationService.getLoggedInUserName();
      return (
        <div className="Wall">
        <HeaderWall name = {userName}/>
        <SideNavBar />
        <PostContainer/>
        </div>
      );
    }
  }
export default wallComponent;
