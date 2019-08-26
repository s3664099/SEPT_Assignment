import React, {Component} from 'react'
import './HeaderWall.css'
import Search from './Search.jsx'

class HeaderWall extends Component {

    render(){
        const userName = "testUser";
        return (
            <header>
                <nav className="wallnav">
                    <div className="wallLogo">
                        <a className ="RMITWall">RMITWall</a>
                    </div>

                    <div className="search">
                      <Search/>
                    </div>

                    <div className="Greetings">
                        Welcome, {userName}
                        <img className ="profilePic" src="http://placekitten.com/300/200"></img>
                    </div>
                </nav>
            </header>
        )
    }
}


export default HeaderWall
