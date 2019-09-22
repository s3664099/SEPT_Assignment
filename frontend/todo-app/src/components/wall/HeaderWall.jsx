import React, {Component} from 'react'
import './HeaderWall.css'
import Search from './Search.jsx'
/*
var myInit ={
    method:'GET',
    headers:{
        'Content-Type':'application/json'
    },
    mode:'cors',
    cache:'default'
};
let myRequest = new Request('http://localhost:3000/profile', myInit);*/

class HeaderWall extends Component {

    constructor(props){
        super(props);
       this.state ={
            //error:null,
            //isLoaded:false,
            //items:[]
            user: ''
        };
    }
/*
    componentDidMount(){
        fetch(myRequest)
        .then(res =>res.json())
        .then(
            (result) =>{
                this.setState({
                    isLoaded:true,
                    items: result
                });
            },
        
        (error)=>{
            this.setState({
                isLoaded:true,
                error
            });
        }
        )
    }*/

    render(){
       // const {error, isLoaded, items}=this.state;
       // const userName = items.name;
       /* if(error){
            return <div>Error:{error.message}</div>
        }else if(!isLoaded){
            return <div>Loading...</div>
        }else{*/
            this.state.user = this.props.name;
             return (
                 
            <header>
                <nav className="wallnav">
                    <div className="wallLogo">
                        <a className ="RMITWall">RMITWall</a>
                    </div>

                    <div className="search">
                      {<Search/>}
                    </div>

                    <div className="Greetings">
                        Welcome, <p>{this.state.user}</p>
                        <img className ="profilePic" src="http://placekitten.com/300/200"></img>
                    </div>
                </nav>
            </header>
        )
        }
       
    }
//}



export default HeaderWall
