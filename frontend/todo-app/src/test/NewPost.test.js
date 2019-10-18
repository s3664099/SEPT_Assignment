import React from 'react';
import Enzyme from 'enzyme'
import Adapter from 'enzyme-adapter-react-16';
Enzyme.configure({ adapter: new Adapter() })
import NewPost from '../components/wall/NewPost'
import ReactDOM from 'react-dom';

const createNewPost = (props) =>{
    const div = document.createElement('div');
    const defaultProps = {
        match:{params:{postId:-1}}
    }
    return ReactDOM.render(<NewPost {...defaultProps}/>, div)
}

test('new post component did mount test', ()=>{
    const div = document.createElement('div');
    const wrapper = createNewPost({});
    const spy = jest.spyOn(wrapper, 'componentDidMount');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})

test('handle submit test', ()=>{
    const div = document.createElement('div');
    const wrapper = createNewPost({});
    const spy = jest.spyOn(wrapper, 'handleSubmit');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})