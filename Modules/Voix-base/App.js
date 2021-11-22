import React, { useEffect, useState } from 'react'
import { FiX } from "react-icons/fi";
import { database } from './firebase-config';
import { getDocs, doc, deleteDoc } from 'firebase/firestore';
export default function Todo({ databaseRef, update, setUpdate }) {
    const [todoList, setTodoList] = useState([]);
    const getData = async () => {
        let data = await getDocs(databaseRef);
        setTodoList(data.docs.map((item) => ({ ...item.data(), id: item.id })));
    }
    useEffect(() => {
        getData()
        setUpdate(false)
    }, [update])

    const deleteItems = (id) => {
        const data = doc(database, 'todo-list', id);
        deleteDoc(data)
            .then(() => {
                getData()
            })
    }

      return (
        <div className="todo-main">
            <h2 className="header">Voice-based Todo Application</h2>

            <div className="todo-card">
                {todoList.map((todo) => {
                    return (
                        <div className="todo-list">
                            <h3 className="todo-item">
                                {todo.item}
                            </h3>
                            <FiX className="close-icon" onClick={() => deleteItems(todo.id)} />
                        </div>
                    )
                })}
            </div>
        </div>
    )
}
