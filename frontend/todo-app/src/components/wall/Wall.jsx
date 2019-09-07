import React, { Component } from 'react';
import HeaderWall from './HeaderWall'
import FooterWall from './FooterWall'
import SideNavBar from './SideNavBar'
import ActivityNavBar from './ActivityNavBar'
import PostContainer from './PostContainer';
import './Wall.css'
import Popup from "reactjs-popup";

class Wall extends Component {
    render() {
      return (
        <div className="Wall">
          <HeaderWall />
          <SideNavBar />
          <ActivityNavBar />
          <div className="Posts">


            <PostContainer />
          </div>
          <FooterWall />
        </div>
      );
    }
  }
export default Wall;
