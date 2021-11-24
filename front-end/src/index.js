import React from 'react';
import ReactDOM from 'react-dom';
import { ChakraProvider } from '@chakra-ui/react';
import { theme } from "./components/theme/custom.js"

import App from './app.jsx';

ReactDOM.render(
  <ChakraProvider theme = {theme} >
    <App />
  </ChakraProvider>, 
  document.getElementById('root')
);

