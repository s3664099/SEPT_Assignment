import React, { Component } from 'react'
import './SideNavBar.css'


class SideNavBar extends Component {
    render() {
        return (
            <div className="sidenav">
                <a href="#">nav1</a>
                <a href="#">nav2</a>
                <a href="#">nav3</a>
                <a href="#">nav4</a> 
            </div>
        )
    }
}

export default SideNavBar