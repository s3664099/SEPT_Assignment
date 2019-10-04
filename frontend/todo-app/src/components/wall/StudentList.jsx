import React, { Component } from 'react'
import StudentListDataService from '../../api/todo/StudentListDataService'
import './studentList.css'
class StudentList extends Component {

    constructor(props){
        super(props)
        this.state = {
            studentList:[]
        }
        this.getList = this.getList.bind(this)
    }

    componentDidMount(){
        console.log("Com will mount student list")
        this.getList();
    }
    componentWillUnmount(){
        console.log("Com will unmount student list")
    }

    getList(){
        StudentListDataService.retrieveAllStudents()
        .then(response=>this.setState({
            studentList:response.data
        }))
    }

    render(){
        console.log(this.state.studentList)
        const userImage = "http://placekitten.com/300/200"
        return(            
            <div className="studentList">{
              this.state.studentList.map(
                (student) =>
                <li><img className ="profilePic" src={userImage} alt="Profile Pic"></img>  student name:  {student.display_Name} </li>    
            )
}
                </div>
        )
    }


  }
export default StudentList;


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