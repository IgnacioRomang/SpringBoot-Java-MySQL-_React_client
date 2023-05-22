import Avatar from '@mui/material/Avatar';
import Divider from '@mui/material/Divider';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemText from '@mui/material/ListItemText';
import Typography from '@mui/material/Typography';
import React, { useEffect, useState } from 'react';

function stringToColor(string) {
    let hash = 0;
    let i;
    for (i = 0; i < string.length; i += 1) {
        hash = string.charCodeAt(i) + ((hash << 5) - hash);
    }

    let color = '#';

    for (i = 0; i < 3; i += 1) {
        const value = (hash >> (i * 8)) & 0xff;
        color += `00${value.toString(16)}`.slice(-2);
    }
    return color;
}

function stringAvatar(name) {
    return {
        id: "avatar",
        sx: {
            bgcolor: stringToColor(name),
        },
        children: `${name.split(' ')[0][0]}${name.split(' ')[1][0]}`,
    };
}

const TaskType = {
    Assigned: Symbol("Assigned"),
    UnAssigned: Symbol("UnAssigned"),
    Finished: Symbol("Finished")
}

function getTaskAssignName(type, props) {
    let dates = ""
    switch (type) {
        case TaskType.Assigned:
            dates = "Assigned to "
            dates += props.assignedUser.name
            break
        case TaskType.Finished:
            dates = "Completed by "
            dates += props.assignedUser.name
            break
        case TaskType.UnAssigned:
            dates = "Unassigned "
    }
    return dates
}
function getDates(type, props) {
    switch (type) {
        case TaskType.Assigned:
            return (<text>was assigned on {props.assignedDate}.</text>)
        case TaskType.Finished:
            return (<text>was completed on {props.finishedDate}.</text>)
        case TaskType.UnAssigned:
            return (<text>is currently awaiting assignment.</text>)
    }
}

const TaskItem = (props) => {
    const [type, setType] = useState();
    const [avatar, setAvatar] = useState(<Avatar></Avatar>);
    useEffect(() => {
        let typeT, nameT;
        if (!props.hasOwnProperty("assignedDate")) {
            typeT = TaskType.UnAssigned
            setAvatar(<Avatar {...stringAvatar("Non Assigned")}/>)
        }
        else {
            setAvatar(<Avatar {...stringAvatar(props.assignedUser.name)}/>)
            typeT = TaskType.Assigned
            if (props.hasOwnProperty("finishedDate")) {
                typeT = TaskType.Finished
            }
        }
        
        setType(typeT)

    }, [props]);

    return (
        <React.Fragment>
            <ListItem alignItems="flex-start">
                <ListItemAvatar>
                    {avatar}
                </ListItemAvatar>
                <ListItemText
                    primary={
                        <React.Fragment>
                            <Typography id="typography" display='inline' component="span" variant="body1">
                                The reported date was {props.reportDate} and it
                            </Typography>
                            {" " + props.reportDate + " , "}
                            <Typography id="typography" display='inline' component="span" variant="body1">
                                {getDates(type, props)}
                            </Typography>
                        </React.Fragment>}
                    secondary={
                        <React.Fragment>
                            <Typography id="typography" display='inline' variant="body2" color="text.primary">
                                {getTaskAssignName(type, props)}
                            </Typography>
                            {'  - ' + props.descriptioString + ' reported by: ' + props.reporterEmail}
                        </React.Fragment>}
                />
            </ListItem>
            <Divider variant="inset" component="li" />
        </React.Fragment>
    );
}

export default TaskItem