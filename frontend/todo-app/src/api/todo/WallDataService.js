import axios from 'axios'
import { /*API_URL, */JPA_API_URL } from '../../Constants'

class WallDataService {
   
    retrieveAllVisiblePosts(name) {
        //console.log('executed wall service')
        return axios.get(`${JPA_API_URL}/users/${name}/wall`);
    }

    //If the request is successful, a message advising the success is sent
    //otherwise a bad requet is recieved and sent
    /*
    deletePost(name, id) {

    	//console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${studentId}/Posts/${id}`, result);
    }*/

    retrievePost(name, studentId, id) {
        //console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${name}/wall/${studentId}/${id}`);
    }

    //the new post is sent to the server. If the student Ids don't match
    //a bad request is returned
    createPost(name, studentId, post) {
        //console.log('executed service')
        return axios.post(`${JPA_API_URL}/users/${name}/wall/${studentId}`, post);
    }

    createComment(name, studentId, post, parentPostId) {
    //console.log('executed service')
        return axios.post(`${JPA_API_URL}/users/${name}/wall/${studentId}/${parentPostId}`, post);
    }

    editPost(name, studentId, post) {
    	return axios.post(`${JPA_API_URL}/users/${name}/wall/${studentId}`, post);
    }

}

export default new WallDataService()