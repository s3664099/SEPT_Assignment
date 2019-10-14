import React, { Component } from 'react'
import StudentListDataService from '../../api/todo/StudentListDataService'
import {withRouter} from 'react-router-dom'
import './studentList.css'
class StudentList extends Component {

    constructor(props){
        super(props)
        this.state = {
            studentList:[]
        }
        this.getList = this.getList.bind(this)
        this.gotoWallButton = this.gotoWallButton.bind(this)
    }

    componentDidMount(){
        console.log("Com will mount student list")
        this.getList();
    }
/*
    componentWillUnmount(){
        console.log("Com will unmount student list")
    }
*/
    gotoWallButton(name){
        console.log('Goto Wall' + name)
        this.props.history.push(`/wall/${name}`)
    }

    getList(){
        StudentListDataService.retrieveAllStudents()
        .then(response=>this.setState({
            studentList:response.data
        }))
    }

    render(){
      const userImage = "http://placekitten.com/32/32"
        console.log(this.state.studentList)
        return(
          <div className="studentListArea">
          <h4>Student List</h4>
            <ul className="studentList">{
                this.state.studentList.map(
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


            /*
            this.state.studentList.map(
                (student) =>
                <tr key={student.studentId}>
                <td>student id:     name:   </td>
                </td>
            )



                    <div className="Students">
        <h1>Students</h1>
        </div>
            */
