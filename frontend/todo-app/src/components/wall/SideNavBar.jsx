import React, { Component } from 'react'
import './SideNavBar.css'


class SideNavBar extends Component {
    render() {
        return (
            <div className="sidenav">
                <a href="http://localhost:4200/welcome/sept/">nav1</a>
                <a href="http://localhost:4200/welcome/sept/">nav2</a>
                <a href="http://localhost:4200/welcome/sept/">nav3</a>
                <a href="http://localhost:4200/welcome/sept/">nav4</a>
            </div>
        )
    }
}

export default SideNavBar
