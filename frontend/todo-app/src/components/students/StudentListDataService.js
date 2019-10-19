import axios from 'axios'
import { JPA_API_URL } from '../../Constants'

class StudentListDataService{

    retrieveAllStudents(){
        return axios.get(`${JPA_API_URL}/users/studentlist`)
    }

    retrieveStudent(name){
    	return axios.get(`${JPA_API_URL}/users/${name}/student`)
    }
}
export default new StudentListDataService()