import React, { Component } from 'react'
import './SideNavBar.css'
import Popup from "reactjs-popup";

class ActivityNavBar extends Component {

    render() {
        return (
          <div className="activityNavBar">
          <Popup trigger={<button className="newPostButton"> Create New Post </button>}
    modal
    closeOnDocumentClick>
          <div>
          <p>Create New Post</p>
          <form action="/action_page.php">
            <textarea name="message" rows="10" cols="100" placeholder="Write your status..."></textarea>
            <br/>
            <input type="submit"/>
            </form>
          </div>
            </Popup>
              <a href="https://www.google.com">nav2</a>
              <a href="https://www.google.com">nav3</a>
              <a href="https://www.google.com">nav4</a>
          </div>
        )
    }
}

export default ActivityNavBar
