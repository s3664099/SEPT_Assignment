import React, { Component } from 'react';
import WelcomeApp from './components/WelcomeApp'
import './App.css';
import './bootstrap.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <WelcomeApp />
      </div>
    );
  }
}

export default App;