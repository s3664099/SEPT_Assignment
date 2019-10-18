import axios from 'axios'
import { JPA_API_URL } from '../../Constants'
 
class WallDataService {
    retrieveAllVisiblePosts(name) {
        return axios.get(`${JPA_API_URL}/users/${name}/wall`);
    }

    //If the request is successful, a message advising the success is sent
    //otherwise a bad requet is recieved and sent
    retrievePost(username, postId){
        return axios.get(`${JPA_API_URL}/users/${username}/post/${postId}`)
    }

    deletePost(username, postID) {
        return axios.delete(`${JPA_API_URL}/users/${username}/post/${postID}`);
    }

    likePost(username, postID) {
        return axios.get(`${JPA_API_URL}/users/${username}/post/${postID}/like`);
    }

    toUpdatePost(username, postId, post){
        return axios.put(`${JPA_API_URL}/users/${username}/post/${postId}`, post)
    }

    //the new post is sent to the server. If the student Ids don't match
    //a bad request is returned
    createPost(username, post) {
        return axios.post(`${JPA_API_URL}/users/${username}/wall`,post);
    }

    createComment(username, post, parentPostId) {
        return axios.post(`${JPA_API_URL}/users/${username}/Posts/${parentPostId}`, post);
    }
}

export default new WallDataService()