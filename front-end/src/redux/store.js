import logger from 'redux-logger';
import thunk from 'redux-thunk';
import { composeWithDevTools } from 'redux-devtools-extension';

import { createStore, applyMiddleware } from 'redux';

import rootReducer from './rootReducer.js';

const middleware = [logger, thunk];

const store = createStore(rootReducer, composeWithDevTools(applyMiddleware(...middleware)));

export default store;