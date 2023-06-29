import CssBaseline from '@mui/material/CssBaseline';
import { ThemeProvider, createTheme } from '@mui/material/styles';

import List from '@mui/material/List';
import TaskItem from './componets/TaskItem';

const darkTheme = createTheme({
  palette: {
    mode: 'dark',
  },
});

function App() {
  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      <div className="App">
        <div className="container">
          <List sx={{ width: '100%', maxWidth: '100%', bgcolor: 'background.paper' }}>
            <TaskItem {...{
              id: '125', priority: '7', descriptioString: 'Hola', reporterEmail: 'hola@gmail.com', reportDate: new Date().toLocaleDateString(), due_date: new Date().toLocaleDateString()
            }} />
            <TaskItem {...{
              id: '125', priority: '7', assignedDate: new Date().toLocaleDateString(), assignedUser: { id: '21', name: 'Ignacio Romang', email: "Ignacio@gmail.com" }, descriptioString: 'Hola', reporterEmail: 'hola@gmail.com', reportDate: new Date().toLocaleDateString(), due_date: new Date().toLocaleDateString()
            }} />
            <TaskItem {...{
              id: '125', priority: '7', assignedDate: new Date().toLocaleDateString(), assignedUser: { id: '21', name: 'Ignacio Romang', email: "Ignacio@gmail.com" }, descriptioString: 'Hola', reporterEmail: 'hola@gmail.com', reportDate: new Date().toLocaleDateString(), due_date: new Date().toLocaleDateString()
              , finishedDate: new Date().toLocaleDateString()
            }} />
          </List>
        </div>
      </div>
    </ThemeProvider>
  );
}
export default App;
