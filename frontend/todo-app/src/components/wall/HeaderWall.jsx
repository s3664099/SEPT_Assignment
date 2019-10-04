import React, {Component} from 'react'
import './HeaderWall.css'
import Search from './Search.jsx'

class HeaderWall extends Component {

    /*constructor(props){
        super(props);
    }*/

    

    render(){
             return (
                 
            <header>
                <nav className="wallnav">
                    <div className="wallLogo">
                        <a className ="RMITWall" href="http://www.rmit.edu.au">RMITWall</a>
                    </div>

                    <div className="search">
                      {<Search/>}
                    </div>

                    <div className="Greetings">
                        Welcome, {this.props.name}
                        <img className ="profilePic" src="http://placekitten.com/300/200" alt="Putty Tat"></img>
                    </div>
                </nav>
            </header>
        )
    }
}


export default HeaderWall
