import './App.css';
import Router from './router/Router';
import { QueryClient, QueryClientProvider } from 'react-query';

function App() {
  const queryClient = new QueryClient();

  return (
    <QueryClientProvider client={queryClient}>
      <Router></Router>
    </QueryClientProvider>
  );
}

export default App;
