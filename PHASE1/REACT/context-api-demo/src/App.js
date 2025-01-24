import './App.css';
import ThemeProvider from './context/ThemeProvider';
import ThemedButton from './components/ThemedButton';
import { useContext } from 'react';
import ThemeContext from './context/ThemeContext';


function App() {
  const { theme, toggleTheme } = useContext(ThemeContext); 

  return (
   
    <ThemeProvider> 
            <button onClick={toggleTheme} 
            
            style={{
              backgroundColor: theme === 'light' ? '#fff' : '#333',
              color: theme === 'light' ? '#000' : '#fff',
              padding: '10px 20px',
            }}
            
            > Toggle Theme </button>     

      {/* <ThemedButton title="Buy" />    
      <ThemedButton title="Sell" /> */}

    </ThemeProvider>
   
  );
}

export default App;
