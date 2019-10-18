import React, { Component } from 'react'
import HeaderWall from './HeaderWall';
import AuthenticationService from '../AuthenticationService'
import OtherPost from './OtherPost'

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
