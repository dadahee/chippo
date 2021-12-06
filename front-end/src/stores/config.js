import { combineReducers } from 'redux';

import tags from "./tags.js";
import interviews from "./interview.js";

const rootReducer = combineReducers({
    tags,
    interviews,
})

export { rootReducer }