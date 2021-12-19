import { combineReducers } from 'redux';

import loadHomeTagReducer from './homeTags/reducer.js';
import loadInterviewTagReducer from './interviewLists/reducer.js';
import loadInterviewIdReducer from './interviews/reducer.js';
import loginReducer from './login/reducer.js';

const rootReducer = combineReducers({
    homeTags : loadHomeTagReducer,
    interviewTags : loadInterviewTagReducer,
    interviewId : loadInterviewIdReducer,
    logined : loginReducer,
})

export default rootReducer;