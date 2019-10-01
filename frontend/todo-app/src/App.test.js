import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import renderer from 'react-test-renderer'
import HeaderWall from './components/wall/HeaderWall';
import WallComponent from './components/wall/WallComponent'
import PostContainer from './components/wall/PostContainer';
import NewPost from './components/wall/NewPost';

//jest.mock('./src/__mock__/WallDataService')//./WallDataService../

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

it('WallComponent renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<WallComponent />, div);
  ReactDOM.unmountComponentAtNode(div);
});

it('PostContainer renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<PostContainer />, div);
  ReactDOM.unmountComponentAtNode(div);
});


it('header wall snapshot compare', () => {
  const tree = renderer
    .create(<HeaderWall name={'sept'}/>)
    .toJSON();
  expect(tree).toMatchSnapshot();
});

/*
it('trial mock object', ()=>{
  expect.assertions(0);
  let username ='one';
  return expect(WallDataService.retrievePost(username, 2)).then(post=>expect(post.userID).toEqual('2'))
})
*/

it('post container test ', () => {
  const tree = renderer
    .create(<PostContainer />)
    .toJSON();
  expect(tree).toMatchSnapshot();
});

