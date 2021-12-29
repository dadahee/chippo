import {
    LOG_IN,
    LOG_OUT,
} from "./types.js";

const initialState = {
    login : false,
}

const loginReducer = (state = initialState, action) => {
    switch(action.type){
        case LOG_IN:
            return {
                ...state,
                login : true,
            }
        case LOG_OUT:
            return {
                ...state,
                login : false
            }
        default:
            return state;
    }
}

export default loginReducer