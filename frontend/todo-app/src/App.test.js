import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import HeaderWall from './components/wall/HeaderWall';



it('App renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<App />, div);
  ReactDOM.unmountComponentAtNode(div);
});

it('HeaderWall renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<HeaderWall />, div);
  ReactDOM.unmountComponentAtNode(div);
});

