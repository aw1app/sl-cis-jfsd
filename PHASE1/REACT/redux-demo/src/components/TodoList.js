import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { addTodo, toggleTodo } from '../actions/todoActions';

const TodoList = () => {

    const todos = useSelector(state => state.todos);// state is nothing but the redux store
    const dispatch = useDispatch();

    return (
        <div style={{border:'solid 2px blue'}}>
             <h1>List of Todos</h1>
            {todos && todos.map(todo => (
                 <li
                 key={todo.id}
                 onClick={() => dispatch(toggleTodo(todo.id))}
                 style={{ color: todo.completed ? 'red':'black'}}                
                 
               >
                    {todo.text}
                </li>
            ))}
            {todos.length===0 && <p>No Todos to Display</p>}

        </div>
    );
}


export default TodoList;