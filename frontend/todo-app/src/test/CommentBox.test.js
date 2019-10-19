import React from 'react';
import Enzyme from 'enzyme'
import Adapter from 'enzyme-adapter-react-16';
import {shallow} from 'enzyme'
Enzyme.configure({ adapter: new Adapter() })
import ReactDOM from 'react-dom';
import CommentBox from '../components/wall/CommentBox';


test('CommentBox componentDidMount', ()=>{
    const wrapper = shallow(<CommentBox username={'sept'} postID={1} />);
    const spy = jest.spyOn(wrapper.instance(), 'componentDidMount');
    expect(spy).toHaveBeenCalledTimes(0);
})

test('CommentBox empty comments', ()=>{
    const wrapper = shallow(<CommentBox username={'sept'} postID={1} />);
    expect(wrapper.state.comments).toBe(undefined);
})

test('CommentBox false boolean', ()=>{
    const wrapper = shallow(<CommentBox username={'sept'} postID={1} />);
    expect(wrapper.state.showTheThing).toBe(undefined);
})

test('CommentBox calling getcomments', ()=>{
    const wrapper = shallow(<CommentBox username={'sept'} postID={1} />);
    const spy = jest.spyOn(wrapper.instance(), 'componentDidMount');
    const spy2 = jest.spyOn(wrapper.instance(), 'getComments')
    wrapper.instance().componentDidMount()
    expect(spy).toHaveBeenCalledTimes(1);
    expect(spy2).toHaveBeenCalledTimes(1);
})

test('CommentBox calling toggleHideButton', ()=>{
    const wrapper = shallow(<CommentBox username={'sept'} postID={1} showTheThing={false} />);
    const spy = jest.spyOn(wrapper.instance(), 'toggleHideButton');
    wrapper.instance().toggleHideButton()
    expect(spy).toHaveBeenCalled();
})

const comment =
{
    "message": 'abcde'
}

test('CommentBox comments', ()=>{
    const div = document.createElement('div');
    const wrapper = ReactDOM.render(<CommentBox username={'sept'} postID={1} showTheThing={false} />, div);
    wrapper.setState({comments:comment})
    expect(wrapper.state.comments.message).toBe('abcde')
    ReactDOM.unmountComponentAtNode(div);
})

