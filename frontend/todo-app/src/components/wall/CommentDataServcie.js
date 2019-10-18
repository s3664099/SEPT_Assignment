import axios from 'axios'
import { JPA_API_URL } from '../../Constants'

class CommentDataService {

    retrieveComments(username, postID){
        return axios.get(`${JPA_API_URL}/users/${username}/post/${postID}/comment`);
    }

    postComments(username, postId, comment){
        return axios.post(`${JPA_API_URL}/users/${username}/post/${postId}/comment`, comment)
    }

    deleteComments(username, commentId){
        return axios.delete(`${JPA_API_URL}/users/${username}/comment/${commentId}`)
    }

    likeComment(username, commentId) {
        return axios.get(`${JPA_API_URL}/users/${username}/comment/${commentId}/like`);
    }

}

export default new CommentDataService()