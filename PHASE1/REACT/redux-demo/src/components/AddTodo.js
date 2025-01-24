import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { addTodo, toggleTodo } from '../actions/todoActions';

const AddTodo = () => {

    const [text, setText] = useState('');
    const dispatch = useDispatch();

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!text.trim()) return;

        dispatch(addTodo(text));
        setText('');
      };
    

    return (
        <div style={{border:'solid 2px black'}}>
            <h1>Add New todo</h1>
        <form onSubmit={handleSubmit} >
            <input
                type="text"
                value={text}
                onChange={(e) => setText(e.target.value)}               
                placeholder="Add todo..."
            />
            <button type='submit'> Add  </button>
        </form>
        </div>
    );
}


export default AddTodo;