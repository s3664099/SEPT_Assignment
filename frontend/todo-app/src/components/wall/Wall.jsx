import React, { Component } from 'react';
import HeaderWall from './HeaderWall'
import FooterWall from './FooterWall'
import SideNavBar from './SideNavBar'
import ActivityNavBar from './ActivityNavBar'
import PostContainer from './PostContainer';
<<<<<<< HEAD
import './Wall.css'
=======
>>>>>>> jasmine

class Wall extends Component {
    render() {
      return (
        <div className="Wall">
          <HeaderWall />
          <SideNavBar />
          <ActivityNavBar />
<<<<<<< HEAD
          <div className="Posts">
            <PostContainer />
            <PostContainer />
            <PostContainer />
          </div>
=======
          <PostContainer />
          <PostContainer />
          <PostContainer />
>>>>>>> jasmine
          <FooterWall />
        </div>
      );
    }
  }
<<<<<<< HEAD




  export default Wall;
=======
  
  
  
  
  export default Wall;
>>>>>>> jasmine
