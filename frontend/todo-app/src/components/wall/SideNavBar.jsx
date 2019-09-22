import React, { Component } from 'react'
import './SideNavBar.css'


class SideNavBar extends Component {
    render() {
        return (
            <div className="sidenav">
                <a href="http://www.google.com">nav1</a>
                <a href="http://www.google.com">nav2</a>
                <a href="http://www.google.com">nav3</a>
                <a href="http://www.google.com">nav4</a>
            </div>
        )
    }
}

export default SideNavBar
