import React, { Component } from 'react';
import Counter from './components/counter/Counter'
import TodoApp from './components/todo/TodoApp'
//import './App.css';
//import './bootstrap.css';
import Wall from './components/wall/Wall.jsx'

class App extends Component {
  render() {
    return (
      <div className="App">
        <Wall />
      </div>
    );
  }
}




export default App;