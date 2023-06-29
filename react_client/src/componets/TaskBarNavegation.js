import AddTaskIcon from '@mui/icons-material/AddTask';
import AssignmentIndIcon from '@mui/icons-material/AssignmentInd';
import AssignmentLateIcon from '@mui/icons-material/AssignmentLate';
import TaskIcon from '@mui/icons-material/Task';
import BottomNavigation from '@mui/material/BottomNavigation';
import BottomNavigationAction from '@mui/material/BottomNavigationAction';
import Box from '@mui/material/Box';
import React, { useState } from 'react';

const TaskBarNavegation = () => {
  const [value, setValue] = useState(0);
  const [list, setList] = useState([])

  return (
    <Box sx={{
      width: '100%', flexWrap: 'nowrap', justifyContent: 'center'
    }}>
      <BottomNavigation
        showLabels
        value={value}
        onChange={(event, newValue) => {
          setValue(newValue);
        }}
      >
        <BottomNavigationAction label="Add Task" icon={<AddTaskIcon />} />
        <BottomNavigationAction label="Finished Tasks" icon={<TaskIcon />} />
        <BottomNavigationAction label="Assigned Tasks" icon={<AssignmentIndIcon />} />
        <BottomNavigationAction label="UnAssigned Tasks" icon={<AssignmentLateIcon />} />
      </BottomNavigation>
    </Box >
  );
}
export default TaskBarNavegation