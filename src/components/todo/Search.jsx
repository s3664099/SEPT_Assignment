import React, { Component } from 'react'
import axios from 'axios'
import Suggestions from './Suggestions.jsx'

const { API_KEY } = process.env
const API_URL = 'http://jsonplaceholder.typicode.com/posts'

class Search extends Component {
  state = {
    query: '',
    results: []
  }

  getInfo = () => {
    const user = {
      name: this.state.query
    }

    axios.get(`https://jsonplaceholder.typicode.com/users`, {user})
    .then(res => {
      //const persons = res.data;
      this.setState({results : res.data})
    })
  }

  handleInputChange = () => {
    this.setState({
      query: this.search.value
    }, () => {
      if (this.state.query && this.state.query.length > 1) {
        if (this.state.query.length % 2 === 0) {
          this.getInfo()
        }
      }
    })
  }

  buttonClicked() {
    this.props.history.push(`/search/${this.state.query}`)
  }

  render() {
    return (
      <form>
        <input
          type="text"
          placeholder="Search for..."
          ref={input => this.search = input}
          onChange={this.handleInputChange}
          value={this.state.query}
        />
        <button type="submit" onClick={this.buttonClicked}>Search</button>
        <Suggestions results={this.state.results} />
      </form>
    )
  }
}

export default Search
