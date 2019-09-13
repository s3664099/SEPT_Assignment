import axios from 'axios'
import { API_URL, JPA_API_URL } from '../../Constants'

class WallDataService {


    retrieveAllVisiblePosts(name) {
        //console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${studentId}/PostVisible`);
    }

    //If the request is successful, a message advising the success is sent
    //otherwise a bad requet is recieved and sent
    deletePost(name, id) {

    	//console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${studentId}/Posts/${id}`, result);
    }

    retrievePost(name, id) {
        //console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${studentId}/Posts/${id}`);
    }

    //the new post is sent to the server. If the student Ids don't match
    //a bad request is returned
    createPost(name, post) {
        //console.log('executed service')
        return axios.post(`${JPA_API_URL}/users/${studentId}/Posts`, post);
    }

    createComment(name, post, parentPostId) {
    //console.log('executed service')
        return axios.post(`${JPA_API_URL}/users/${studentId}/Posts/${parentPostId}`, post);
    }

    editPost(name, post) {
    	return axios.post(`${JPA_API_URL}/users/${studentId}/Posts`, post);
    }



}