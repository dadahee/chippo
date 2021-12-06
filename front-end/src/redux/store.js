import logger from 'redux-logger';
import { createStore, applyMiddleware } from 'redux';

import rootReducer from './rootReducer.js';

const middleware = [logger];

const store = createStore(loadHomeTagReducer, applyMiddleware(...middleware));

export default store;