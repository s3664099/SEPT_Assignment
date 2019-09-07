import React, { Component } from 'react'

class NewPost extends Component{
    render() {
        return (
            <div className="newPoster">
                <button type="submit" onClick ={this.buttonClicked}> + add new post  </button>
            </div>
        );
    }
}

export default NewPost