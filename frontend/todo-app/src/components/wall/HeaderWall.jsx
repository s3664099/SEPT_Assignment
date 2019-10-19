import React, {Component} from 'react'
import './Wall.css'

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
