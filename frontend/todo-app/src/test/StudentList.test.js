import React from 'react';
import Enzyme from 'enzyme'
import Adapter from 'enzyme-adapter-react-16';
Enzyme.configure({ adapter: new Adapter() })
import StudentList from '../components/students/StudentList'
import ReactDOM from 'react-dom';

const createStudentList = (props) =>{
    const div = document.createElement('div');
  return ReactDOM.render(<StudentList.WrappedComponent location={`/wall`}  />, div);
}

test('student list component did mount', ()=>{
    const div = document.createElement('div');
    const wrapper = createStudentList({});
    const spy = jest.spyOn(wrapper, 'componentDidMount');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})

test('student list go to wall button', ()=>{
    const div = document.createElement('div');
    const wrapper = createStudentList({});
    const spy = jest.spyOn(wrapper, 'gotoWallButton');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})

test('new post component filter list', ()=>{
    const div = document.createElement('div');
    const wrapper = createStudentList({});
    const spy = jest.spyOn(wrapper, 'filterList');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})
