import CssBaseline from '@mui/material/CssBaseline';
import { ThemeProvider, createTheme } from '@mui/material/styles';
import axios from 'axios';
import './App.css';
import TaskCard from "./componets/TaskCard";


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
          <TaskCard />
        </div>
      </div>
    </ThemeProvider>
  );
}
export default App;
