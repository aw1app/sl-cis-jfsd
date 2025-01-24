import './App.css';
import TodoList from './components/TodoList';

import { Provider } from 'react-redux';
import { store } from './store';
import AddTodo from './components/AddTodo';

function App() {
  return (
    <Provider store={store}>
    <div className="App">      
      <h1>REDUX DEMO </h1>
      <AddTodo/>
      <br/><br/>
      <TodoList />
    </div>
    </Provider>
  );
}

export default App;
