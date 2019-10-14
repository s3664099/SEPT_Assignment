import axios from 'axios'
import { JPA_API_URL } from '../../Constants'

class CommentDataService {

    retrieveComments(username, postID){
       // console.log("comment axios")
        return axios.get(`${JPA_API_URL}/users/${username}/post/${postID}/comment`);
    }

    postComments(username, postId, comment){
        //console.log("comment post axios")
        return axios.post(`${JPA_API_URL}/users/${username}/post/${postId}/comment`, comment)
    }

    deleteComments(username, commentId){
        console.log("axios delete")
        return axios.delete(`${JPA_API_URL}/users/${username}/comment/${commentId}`)
    }

}

export default new CommentDataService()