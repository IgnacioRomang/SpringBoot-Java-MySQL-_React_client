import Avatar from '@mui/material/Avatar';
import Card from '@mui/material/Card';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemText from '@mui/material/ListItemText';
import * as React from 'react';


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

const TaskCard = (Tasks) => {
    return (
        <Card id="card">
            <ListItem button key={index }>
                <ListItemAvatar>
                    <Avatar {...stringAvatar(name)} />
                </ListItemAvatar>s
                <ListItemText primary={date} secondary={descriptionString} />
            </ListItem>
        </Card>
    );
}

export default TaskCard