import React from 'react';
import Enzyme from 'enzyme'
import Adapter from 'enzyme-adapter-react-16';
Enzyme.configure({ adapter: new Adapter() })
<<<<<<< HEAD
import ReactDOM from 'react-dom';
import StudentList from '../components/students/StudentList';
=======
import StudentList from '../components/students/StudentList'
import ReactDOM from 'react-dom';
>>>>>>> b890aa77af4739072796340318f8a09375842ca5

const createStudentList = (props) =>{
    const div = document.createElement('div');
  return ReactDOM.render(<StudentList.WrappedComponent location={`/wall`} />, div);
}


test('student list component did mount', ()=>{
    const div = document.createElement('div');
    const wrapper = createStudentList({});
    const spy = jest.spyOn(wrapper, 'componentDidMount');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})

test('student list gotoWallButton', ()=>{
    const div = document.createElement('div');
    const wrapper = createStudentList({});
    const spy = jest.spyOn(wrapper, 'gotoWallButton');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})

test('student list filter list', ()=>{
    const div = document.createElement('div');
    const wrapper = createStudentList({});
    const spy = jest.spyOn(wrapper, 'filterList');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})
<<<<<<< HEAD

test('studentlist getList', ()=>{
    const div = document.createElement('div');
    const wrapper = createStudentList({});
    const spy = jest.spyOn(wrapper, 'getList');
    expect(spy).toHaveBeenCalledTimes(0);
    ReactDOM.unmountComponentAtNode(div);
})

test('studentlist studentList', ()=>{
    const div = document.createElement('div');
    const wrapper = createStudentList({});
    expect(wrapper.state.studentList).toHaveLength(0);
    ReactDOM.unmountComponentAtNode(div);
})

test('studentlist filteredList', ()=>{
    const div = document.createElement('div');
    const wrapper = createStudentList({});
    expect(wrapper.state.filteredList).toHaveLength(0);
    ReactDOM.unmountComponentAtNode(div);
})

const students = {
    "display_name":"myName"
}

test('studentlist mock student object', ()=>{
    const div = document.createElement('div');
    const wrapper = createStudentList({});
    wrapper.setState({studentList:students})
    expect(wrapper.state.studentList.display_name).toBe("myName")
    ReactDOM.unmountComponentAtNode(div);
})

=======
>>>>>>> b890aa77af4739072796340318f8a09375842ca5
