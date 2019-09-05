import axios from 'axios'
import { API_URL, JPA_API_URL } from '../../Constants'

class WallDataService {

    retrieveAllVisiblePosts(name) {
        //console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${studentId}/VisiblePosts`);
    }

    retrieveAllVisiblePosts(name) {
        //console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${studentId}/PostAll`);
    }

    //If the request is successful, a message advising the success is sent
    //otherwise a bad requet is recieved and sent
    deletePost(name, id) {

    	//console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${studentId}/DeletePost/${id}`, result);
    }

    retrieveTodo(name, id) {
        //console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${studentId}/GetPost/${id}`);
    }

    //the new post is sent to the server. If the student Ids don't match
    //a bad request is returned
    createPost(name, post) {
        //console.log('executed service')
        return axios.post(`${JPA_API_URL}/users/${studentId}/AddPost/{post}`, post);
    }



}
