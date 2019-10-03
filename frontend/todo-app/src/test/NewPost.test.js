import React from 'react';
import Enzyme from 'enzyme'
import {shallow} from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
Enzyme.configure({ adapter: new Adapter() })
import PostContainer from '../components/wall/PostContainer'
import ReactDOM from 'react-dom';


it('post container componentDidMount test1', () => {
  const div = document.createElement('div');
  const wrapper = ReactDOM.render(<PostContainer.WrappedComponent location={'/wall'} />, div);
  const spy = jest.spyOn(wrapper, 'componentDidMount');
  expect(spy).toHaveBeenCalledTimes(0);
  ReactDOM.unmountComponentAtNode(div);
});

it('post container componentDidMount test2', () => {
  const div = document.createElement('div');
  const wrapper = ReactDOM.render(<PostContainer.WrappedComponent location={'/wall'} />, div);
  const spy = jest.spyOn(wrapper, 'shouldComponentUpdate');
  expect(spy).toHaveBeenCalledTimes(0);
  ReactDOM.unmountComponentAtNode(div);
});


it('edit post button', () => {
  const div = document.createElement('div');
  const wrapper = ReactDOM.render(<PostContainer.WrappedComponent location={'/wall'} />, div);
  const spy = jest.spyOn(wrapper, 'editPostButton');
  expect(spy).toHaveBeenCalledTimes(0);
  ReactDOM.unmountComponentAtNode(div);
});

it('add post button', () => {
  const div = document.createElement('div');
  const wrapper = ReactDOM.render(<PostContainer.WrappedComponent location={'/wall'} />, div);
  const spy = jest.spyOn(wrapper, 'addPostClicked');
  expect(spy).toHaveBeenCalledTimes(0);
  ReactDOM.unmountComponentAtNode(div);
});

it('delete post button', () => {
  const div = document.createElement('div');
  const wrapper = ReactDOM.render(<PostContainer.WrappedComponent location={'/wall'} />, div);
  const spy = jest.spyOn(wrapper, 'deletePostButton');
  expect(spy).toHaveBeenCalledTimes(0);
  ReactDOM.unmountComponentAtNode(div);
});

it('refresh posts', () => {
  const div = document.createElement('div');
  const wrapper = ReactDOM.render(<PostContainer.WrappedComponent location={'/wall'} />, div);
  const spy = jest.spyOn(wrapper, 'refreshPosts');
  expect(spy).toHaveBeenCalledTimes(0);
  ReactDOM.unmountComponentAtNode(div);
});
