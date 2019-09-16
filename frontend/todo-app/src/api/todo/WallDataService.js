import axios from 'axios'
import { API_URL, JPA_API_URL } from '../../Constants'
 var studentId=1;
class WallDataService {
   


    retrieveAllVisiblePosts(name) {
        //console.log('executed service')
        return axios.get(`/users/${name}/Posts`);
    }

    //If the request is successful, a message advising the success is sent
    //otherwise a bad requet is recieved and sent
    /*
    deletePost(name, id) {

    	//console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${studentId}/Posts/${id}`, result);
    }*/

    //the new post is sent to the server. If the student Ids don't match
    //a bad request is returned
    createPost(name, post) {
        //console.log('executed service')
        return axios.post(`users/${studentId}/Posts`);
    }

    createComment(name, post, parentPostId) {
    //console.log('executed service')
        return axios.post(`${JPA_API_URL}/users/${studentId}/Posts/${parentPostId}`, post);
    }

    editPost(name, post) {
    	return axios.post(`${JPA_API_URL}/users/${studentId}/Posts`, post);
    }



}

export default new WallDataService()