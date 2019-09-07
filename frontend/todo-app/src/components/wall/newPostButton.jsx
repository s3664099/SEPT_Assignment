import React, { Component } from 'react'



class newPostButton extends Component {
    render() {
        return (
            <div className="newPost">
                <button type="submit" onClick ={this.buttonClicked}> + add new post  </button>
            </div>
        );
    }
}

export default newPostButton