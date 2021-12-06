import { combineReducers } from 'redux';

import loadHomeTagReducer from './homeTags/reducer.js';
import commentsReducer from './comments/reducer.js';

const rootReducer = combineReducers({
    homeTags : loadHomeTagReducer,
    comments : commentsReducer,
})

export default rootReducer;