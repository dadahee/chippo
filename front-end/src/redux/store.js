import { createStore } from 'redux';
import loadHomeTagReducer from './homeTags/reducer.js';

const store = createStore(loadHomeTagReducer);

export default store;