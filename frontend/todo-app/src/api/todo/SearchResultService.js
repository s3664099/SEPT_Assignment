import axios from 'axios'
import { JPA_API_URL } from '../../Constants'

class SearchResultService {

  retrieveSearchResults(query){
     // console.log("comment axios")
      return axios.get(`${JPA_API_URL}/search/${query}`);
  }

}

export default new SearchResultService()
