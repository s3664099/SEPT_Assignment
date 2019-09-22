import React from 'react'
import ReactDom from 'react-dom'
import HeaderWall from '../wall/HeaderWall'
import WallComponent from '../wall/WallComponent'
const sum = require('./sum');
import TestRenderer from 'react-test-renderer'
test('adds 1+2 to equal 3', ()=>{
    expect(sum(1,2)).toBe(3);
});

test('object assignment', ()=>{
    const data = {one:1};
    data['two'] = 2;
    expect(data).toEqual({one:1, two:2});
});

/*
const testRenderer = TestRenderer.create(<WallComponent/>);
const testInstance = testRenderer.root;
expect(testInstance.findAllByType(HeaderWall).props.name.toBe('sept'));
*/

it('renders without crashing', () => {
    const div = document.createElement('div');
    ReactDom.render(<WallComponent />, div);
    ReactDom.unmountComponentAtNode(div);
    
  });