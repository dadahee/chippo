import React from 'react';
import ReactDOM from 'react-dom';

import { Provider } from 'react-redux';
import { createStore } from 'redux';

import { ChakraProvider } from '@chakra-ui/react';
import { theme } from "./components/theme/custom.js"

import { customTheme } from './components/styles/theme.js';

import App from './app.jsx';
import store from "./redux/store.js"


ReactDOM.render(
    <ChakraProvider theme = {customTheme}>
      <Provider store = {store}>
        <App />
      </Provider>
    </ChakraProvider>,
  document.getElementById('root')
);

