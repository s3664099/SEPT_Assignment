import axios from 'axios'
import { JPA_API_URL } from '../../Constants'

class CommentDataService {

    retrieveComments(username, postID){
       // console.log("comment axios")
        return axios.get(`${JPA_API_URL}/users/${username}/post/${postID}/comment`);
    }


}

export default new CommentDataService()