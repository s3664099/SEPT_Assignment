import React, {Component} from 'react'
import './HeaderWall.css'
<<<<<<< HEAD
import Search from './Search.jsx'
=======
>>>>>>> aea955ae5f36cae241733a70740109f0af4d1406

class HeaderWall extends Component {

    render(){
        const userName = "testUser";
        return (
            <header>
                <nav className="wallnav">
                    <div className="wallLogo">
                        <a className ="RMITWall">RMITWall</a>
                    </div>
<<<<<<< HEAD

                    <div className="search">
                      <Search/>
                    </div>

                    <div className="Greetings">
                        Welcome, {userName}
=======
                    <div className="Greetings"> 
                        Welcome,  
                    </div>
                    <div className="Greetings">{userName}</div>
                    <div > 
>>>>>>> aea955ae5f36cae241733a70740109f0af4d1406
                        <img className ="profilePic" src="http://placekitten.com/300/200"></img>
                    </div>
                </nav>
            </header>
        )
    }
}


<<<<<<< HEAD
export default HeaderWall
=======
export default HeaderWall
>>>>>>> aea955ae5f36cae241733a70740109f0af4d1406
