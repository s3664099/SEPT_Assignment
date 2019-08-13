import React, { Component } from 'react';
import Counter from './components/counter/Counter'
import TodoApp from './components/todo/TodoApp'
//import './App.css';
//import './bootstrap.css';
import HeaderWall from './components/wall/HeaderWall'
import FooterWall from './components/wall/FooterWall'
import SideNavBar from './components/wall/SideNavBar';

class App extends Component {
  render() {
    return (
      <div className="App">
        <HeaderWall />
        <SideNavBar />
        <FooterWall />
      </div>
    );
  }
}




export default App;