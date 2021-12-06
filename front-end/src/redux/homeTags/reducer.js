import { LOAD_TAGS } from './types.js';

const initialState = {
    tabList : ["company", "stack", "job"],
    companyImages : [ "kakao", "naver", "deliver", "line", "coupang" ],
    stackImages : [ "spring", "reactjs", "nodejs", "vuejs", "django" ],
    jobImages : [ "front-end", "back-end", "android", "data-engineer", "ios"]  
}

const loadHomeTagReducer = (state = initialState, action) => {
    switch(action.type){
        case LOAD_TAGS:
            return {
                ...state,
                tabList : state.tabList,
                company : state.company,
                stack : state.stack,
                job : state.job,
            }
        
        default:
            return state;
    }
}

export default loadHomeTagReducer;