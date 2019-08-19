import React, {Component} from 'react'
import './HeaderWall.css'

class HeaderWall extends Component {

    render(){
        const userName = "testUser";
        return (
            <header>
                <nav className="wallnav">
                    <div className="wallLogo">
                        <a className ="RMITWall">RMITWall</a>
                    </div>
                    <div className="Greetings"> 
                        Welcome,  
                    </div>
                    <div className="Greetings">{userName}</div>
                    <div > 
                        <img className ="profilePic" src="http://placekitten.com/300/200"></img>
                    </div>
                </nav>
            </header>
        )
    }
}


export default HeaderWall