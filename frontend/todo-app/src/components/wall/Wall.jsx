import React, { Component } from 'react';
import HeaderWall from './HeaderWall'
import FooterWall from './FooterWall'
import SideNavBar from './SideNavBar'
import ActivityNavBar from './ActivityNavBar'
import PostContainer from './PostContainer'
import newPostButton from './newPostButton'
import './Wall.css'


class Wall extends Component {
    render() {
      return (
        <div className="Wall">
          <HeaderWall />
          <SideNavBar />
          <ActivityNavBar />
          <newPostButton />
          <div className="Posts">
            <PostContainer />
          </div>
          <FooterWall />
        </div>
      );
    }
  }
export default Wall;
