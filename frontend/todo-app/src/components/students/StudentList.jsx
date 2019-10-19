import React, { Component } from 'react'
import StudentListDataService from './StudentListDataService'
import {withRouter} from 'react-router-dom'
import './studentList.css'
class StudentList extends Component {

    constructor(props){
        super(props)
        this.state = {
            filteredList:[],
            studentList:[]
        }
        this.getList = this.getList.bind(this)
        this.gotoWallButton = this.gotoWallButton.bind(this)
    }

    componentDidMount(){
        //console.log("Com will mount student list")
        this.getList();
    }

    componentWillUnmount(){
        //console.log("Com will unmount student list")
    }

    shouldComponentUpdate(nextProps, nextState) {
        //console.log('shouldComponentUpdate on wall')
        //console.log(nextProps)
        //console.log(nextState)
        return true
      }

    gotoWallButton(name){
        console.log('Goto Wall' + name)
        this.props.history.push(`/otherWall/${name}`)
    }

    getList(){
        StudentListDataService.retrieveAllStudents()
        .then(response=>this.setState({
            studentList:response.data,
            filteredList: response.data
        }))
    }

    filterList = (event) =>{
        let items = this.state.studentList;
        items = items.filter((item) =>{
            return item.display_Name.toLowerCase().search(event.target.value.toLowerCase())!== -1
        })
        this.setState({
            filteredList:items
        })
    }


    render(){
      const userImage = "http://placekitten.com/32/32"
        //console.log(this.props.history)
        return(

          <div className="studentListArea">
          <h4>Students</h4>
          <form>
        <input
          className="search"
          type="text"
          placeholder="Search for student..."
          ref={input => this.search = input}
          onChange={this.filterList}
          
        />

      </form>
            <ul className="studentList">{
                this.state.filteredList.map(
                    (student) =>
                    <li key={student.studentId}>
                        <img className ="profilePic" src={userImage} alt="Profile Pic"></img>
                        <button className ="wallButton" onClick ={()=>this.gotoWallButton(student.display_Name)}>
                            {student.display_Name}
                        </button>
                    </li>
                )
            }</ul>
          </div>
        )
    }


  }
export default withRouter(StudentList);
