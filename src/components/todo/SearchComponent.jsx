import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import Search from './Search.jsx'

class SearchComponent extends Component {

  constructor(props) {
    super(props)

    this.state = {
      query: this.props.match.params.query
    }
  }

  render() {
    return (
      <>
        <h1>Search Results</h1>
        <p>Search results for: {this.props.match.params.query}</p>
      </>
    )
  }
}

export default SearchComponent
