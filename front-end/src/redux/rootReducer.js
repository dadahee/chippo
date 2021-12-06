import { combineReducers } from 'redux';
import loadHomeTagReducer from './homeTags/reducer.js';

const rootReducer = combineReducers({
    loadHomeTag : loadHomeTagReducer,
})

export default rootReducer;