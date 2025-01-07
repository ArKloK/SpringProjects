import { useEffect, useState } from "react";
import { deleteTodoApi, retrieveAllTodosForUserApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

export default function ListTodosComponent() {
    const [todos, setTodos] = useState([]);
    const [message, setMessage] = useState(null);

    const authContext = useAuth();
    const username = authContext.username;

    const navigate = useNavigate();

    function refreshTodos() {
        retrieveAllTodosForUserApi(username).then(
            (response) => setTodos(response.data)
        ).catch(
            (error) => console.log(error)
        ).finally(
            () => console.log('finally')
        );
    }useEffect(() => refreshTodos(), []);

    function deleteTodo(id) {
        deleteTodoApi(username, id).then(
            () => {
                setMessage(`Delete of todo ${id} successful`);
                refreshTodos();
            }
        ).catch(
            (error) => console.log(error)
        ).finally(
            () => console.log('finally')
        );
    }
    function addNewTodo() {
        navigate('/todo/-1');
    }

    function updateTodo(id) {
        console.log('update ' + id);
        navigate(`/todo/${id}`);
    }

    return (
        <div className="container">
            <h1>Things you want to do</h1>
            {message && <div className="alert alert-warning">{message}</div>}
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Description</th>
                            <th>Done</th>
                            <th>Target Date</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(
                                todo => (
                                    <tr key={todo.id}>
                                        <td>{todo.description}</td>
                                        <td>{todo.done.toString()}</td>
                                        <td>{todo.targetDate.toString()}</td>
                                        <td><button className="btn btn-warning" onClick={() => deleteTodo(todo.id)}>Delete</button></td>
                                        <td><button className="btn btn-success" onClick={() => updateTodo(todo.id)}>Update</button></td>
                                    </tr>
                                )
                            )
                        }
                    </tbody>
                </table>
            </div>
            <div className="btn btn-success m-5" onClick={addNewTodo}>Add New Todo</div>
        </div>
    );
}