import React, { Component } from 'react';
import HeaderWall from './HeaderWall'
import FooterWall from './FooterWall'
import SideNavBar from './SideNavBar'
import ActivityNavBar from './ActivityNavBar'
import PostContainer from './PostContainer';
<<<<<<< HEAD
import './Wall.css'
=======
>>>>>>> aea955ae5f36cae241733a70740109f0af4d1406

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
>>>>>>> aea955ae5f36cae241733a70740109f0af4d1406
          <FooterWall />
        </div>
      );
    }
  }
<<<<<<< HEAD




  export default Wall;
=======
  
  
  
  
  export default Wall;
>>>>>>> aea955ae5f36cae241733a70740109f0af4d1406
