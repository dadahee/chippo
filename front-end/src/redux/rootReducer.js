import { combineReducers } from 'redux';

import loadHomeTagReducer from './homeTags/reducer.js';
import commentsReducer from './comments/reducer.js';
import loadInterviewTagReducer from './interviewLists/reducer.js';

const rootReducer = combineReducers({
    homeTags : loadHomeTagReducer,
    comments : commentsReducer,
    interviewTags : loadInterviewTagReducer,
})

export default rootReducer;