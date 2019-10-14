import axios from 'axios'
import { JPA_API_URL } from '../../Constants'
 var studentId=1;
 
class WallDataService {
   
    retrieveAllVisiblePosts(name) {
        //console.log('executed service view post1')
        return axios.get(`${JPA_API_URL}/users/${name}/wall`);

    }

    //If the request is successful, a message advising the success is sent
    //otherwise a bad requet is recieved and sent
    retrievePost(username, postId){
        //console.log('retrieve one single post');
        return axios.get(`${JPA_API_URL}/users/${username}/post/${postId}`)
    }

    
    deletePost(username, postID) {
    	//console.log('delete delete ...')
        return axios.delete(`${JPA_API_URL}/users/${username}/post/${postID}`);
    }

    toUpdatePost(username, postId, post){
        //console.log('update post axios')
        return axios.put(`${JPA_API_URL}/users/${username}/post/${postId}`, post)
    }

    //the new post is sent to the server. If the student Ids don't match
    //a bad request is returned
    createPost(username, post) {
        //console.log(username)
        return axios.post(`${JPA_API_URL}/users/${username}/wall`,post);
    }

    createComment(name, post, parentPostId) {
        //console.log('executed service')
        return axios.post(`${JPA_API_URL}/users/${studentId}/Posts/${parentPostId}`, post);
    }
/*
    editPost(name, post) {
    	return axios.post(`${JPA_API_URL}/users/${studentId}/Posts`, post);
    }*/
}

export default new WallDataService()