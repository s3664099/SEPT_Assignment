import axios from 'axios'
import { JPA_API_URL } from '../../Constants'

class StudentListDataService{

    retrieveAllStudents(){
        console.log("axios get student mapping")
        return axios.get(`${JPA_API_URL}/users/studentlist`)
    }

    retrieveStudent(name){
    	console.log("fetching student")
    	return axios.get(`${JPA_API_URL}/users/${name}/student`)
    }
}
export default new StudentListDataService()