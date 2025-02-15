import { useNavigate, useParams } from "react-router-dom";
import { createTodoApi, retrieveTodoApi, updateTodoApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useEffect, useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import moment from "moment";

export default function TodoComponent() {

    const [description, setDescription] = useState('');
    const [targetDate, setTargetDate] = useState('');

    const { id } = useParams();
    const authContext = useAuth();
    const navigate = useNavigate();
    const username = authContext.username;

    useEffect(() => retrieveTodo(), [id]);

    function retrieveTodo() {

        if (id == -1) return;
        retrieveTodoApi(username, id).then(
            (response) => {
                setDescription(response.data.description);
                setTargetDate(response.data.targetDate);
            }
        ).catch(
            (error) => console.log(error)
        ).finally(
            () => console.log('finally')
        );
    }

    function onSubmit(values) {
        const todo = {
            id: id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done: false
        }
        console.log(todo);

        if (id == -1) {
            createTodoApi(username, todo).then(
                (response) => {
                    navigate('/todos');
                }
            ).catch(
                (error) => console.log(error)
            )
        } else {
            updateTodoApi(username, id, todo).then(
                (response) => {
                    navigate('/todos');
                }
            ).catch(
                (error) => console.log(error)
            )
        }

    }

    function validate(values) {
        let errors = {};
        if (!values.description) {
            errors.description = 'Enter a description';
        } else if (values.description.length < 5) {
            errors.description = 'Enter at least 5 characters in the description';
        }

        if (!values.targetDate || values.targetDate == '' || !moment(values.targetDate).isValid()) {
            errors.targetDate = 'Enter a target date';
        }

        return errors;
    }

    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <div>
                <Formik initialValues={{ description: description, targetDate: targetDate }}
                    enableReinitialize={true}
                    onSubmit={onSubmit}
                    validate={validate}
                    validateOnChange={false}
                    validateOnBlur={false}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage
                                    name="description"
                                    component="div"
                                    className="alert alert-warning"
                                />
                                <ErrorMessage
                                    name="targetDate"
                                    component="div"
                                    className="alert alert-warning"
                                />
                                <fieldset className="form-group">
                                    <label htmlFor="description">Description</label>
                                    <Field className="form-control" type="text" id="description" name="description"></Field>
                                </fieldset>
                                <fieldset className="form-group">
                                    <label htmlFor="targetDate">Target Date</label>
                                    <Field className="form-control" type="date" id="targetDate" name="targetDate"></Field>
                                </fieldset>
                                <div>
                                    <button className="btn btn-success m-5" type="submit">Save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}