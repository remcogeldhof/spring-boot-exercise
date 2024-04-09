import React, {useState, useEffect} from 'react';
import axios from 'axios';

const TodoApp = () => {
    const [todos, setTodos] = useState([]);

    useEffect(() => {
        fetchTodos();
    }, []);

    const fetchTodos = async (context) => {
        try {
            let response;
            if (context) {
                response = await axios.get(`http://localhost:8080/todos/context?context=${context}`, {withCredentials: true});
            } else {
                response = await axios.get('http://localhost:8080/todos', {withCredentials: true});
            }
            setTodos(response.data.items);
        } catch (error) {
            console.error('Error fetching todos:', error);
        }
    };

    const handleFilterChange = (event) => {
        fetchTodos(event.target.value);
    };

    return (
        <div>
            <h1>Todo List</h1>
            <div>
                <label>Context filter</label>
                <select onChange={handleFilterChange}>
                    <option value="">All</option>
                    <option value="optis">Optis</option>
                    <option value="colruyt">Colruyt</option>
                    <option value="phone">Phone</option>
                </select>
            </div>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Completed</th>
                    <th>Context</th>
                    <th>Project tag</th>
                    <th>Description</th>
                    <th>Priority</th>
                    <th>Completion date</th>
                    <th>Creation date</th>
                </tr>
                </thead>
                <tbody>
                {todos.map(todo => (
                    <tr key={todo.id}>
                        <td>{todo.id}</td>
                        <td>{todo.completed ? 'V' : 'X'}</td>
                        <td>{todo.contextTag}</td>
                        <td>{todo.projectTag}</td>
                        <td>{todo.description}</td>
                        <td>{todo.priority}</td>
                        <td>{todo.completionDate}</td>
                        <td>{todo.creationDate}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default TodoApp;