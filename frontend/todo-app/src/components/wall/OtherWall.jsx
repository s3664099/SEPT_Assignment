import React, { Component } from 'react'
import HeaderWall from './HeaderWall';
import AuthenticationService from '../todo/AuthenticationService'
// import SideNavBar from './SideNavBar';
// import StudentList from './StudentList';
// import ActivityNavBar from './ActivityNavBar'
// <!--<SideNavBar />
import OtherPost from './OtherPost'
// <ActivityNavBar/>-->

class OtherWall extends Component {

    render() {
        const userName = AuthenticationService.getLoggedInUserName();

      return (
        <div className="Wall">
        <HeaderWall name = {userName}/>
        {/*<StudentList/>*/}
        <OtherPost />
        </div>
      );
    }
  }
export default OtherWall;
