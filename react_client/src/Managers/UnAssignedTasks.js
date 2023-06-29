import axios from 'axios';
import { useState } from 'react';

const [UnAssignedTasks, setUnAssignedtasks] = useState("");
const [UnAssignedTask, setUnAssignedtask] = useState("")


export const getUnAssignedTasks = async () => {
    const res = await axios.get("http://localhost:8080/api/UnAssignedTask");
    setUnAssignedtasks(res.data);
}

export const createUnAssignedTaks = async (name, description) => {
    await axios.post("http://localhost:8080/api/UnAssignedTask", { name: name, description: description });
    getUnAssignedTasks();
}

export const deleteUnAssignedTask = async (id) => {
    await axios.delete("http://localhost:8080/api/UnAssignedTask",{ data: { id: id } })
    getUnAssignedTasks();
}