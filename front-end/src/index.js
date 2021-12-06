import React from 'react';
import ReactDOM from 'react-dom';

import { Provider } from 'react-redux';
import { createStore } from 'redux';

import { ChakraProvider } from '@chakra-ui/react';
import { theme } from "./components/theme/custom.js"

import App from './app.jsx';
import { rootReducer } from './stores/config.js'

const store = createStore(rootReducer);

ReactDOM.render(
    <Provider store = {store}>
      <ChakraProvider theme = {theme} >
        <App />
      </ChakraProvider>
    </Provider>,
  document.getElementById('root')
);

