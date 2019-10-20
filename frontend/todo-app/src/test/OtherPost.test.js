import React from 'react';
import Enzyme from 'enzyme'
import Adapter from 'enzyme-adapter-react-16';
Enzyme.configure({ adapter: new Adapter() })
import ReactDOM from 'react-dom';
import OtherPost from '../components/wall/OtherPost';
import HeaderWall from '../components/wall/HeaderWall';

const createOtherPost = (props) =>{
    const div = document.createElement('div');
    const defaultProps = {
        match:{params:{name:'sept'}}
    }
  return ReactDOM.render(<OtherPost.WrappedComponent location={`/otherWall/:name`} {...defaultProps} />, div);
}

test('HeaderWall renders successfully', () => {
    const div = document.createElement('div');
    ReactDOM.render(<HeaderWall />, div);
    ReactDOM.unmountComponentAtNode(div);
  });
    

test('other post componentDidMount', ()=>{
    const div = document.createElement('div');
    const wrapper = createOtherPost({});
    const spy = jest.spyOn(wrapper, 'componentDidMount');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})

test('other post shouldComponentUpdate', ()=>{
    const div = document.createElement('div');
    const wrapper = createOtherPost({});
    const spy = jest.spyOn(wrapper, 'shouldComponentUpdate');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})

test('other post componentWillUnmount', ()=>{
    const div = document.createElement('div');
    const wrapper = createOtherPost({});
    const spy = jest.spyOn(wrapper, 'componentWillUnmount');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})

test('other post empty post', ()=>{
    const div = document.createElement('div');
    const wrapper = createOtherPost({});
    expect(wrapper.state.posts).toHaveLength(0);
    ReactDOM.unmountComponentAtNode(div);
})

test('other post empty post name', ()=>{
    const div = document.createElement('div');
    const wrapper = createOtherPost({});
    expect(wrapper.state.name).toBe('sept')
    ReactDOM.unmountComponentAtNode(div);
})

test('other post likePostButton', ()=>{
    const div = document.createElement('div');
    const wrapper = createOtherPost({});
    const spy = jest.spyOn(wrapper, 'likePostButton');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})

test('other post refreshPosts', ()=>{
    const div = document.createElement('div');
    const wrapper = createOtherPost({});
    const spy = jest.spyOn(wrapper, 'refreshPosts');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})