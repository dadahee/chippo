import { 
    FETCH_COMMENTS,
    FETCH_COMMENTS_REQEUST,
    FETCH_COMMENTS_SUCCESS,
    FETCH_COMMENTS_FAILURE 
} from "./types.js";

const initialState = {
    items : [],
    loading : false,
    err : null,
}

const commentsReducer = (state = initialState, action) => {
    switch(action.type){
        case FETCH_COMMENTS_REQEUST:
            return {
                ...state,
                loading: true,
            }
        
        case FETCH_COMMENTS_SUCCESS:
            return {
                ...state,
                items: action.payload,
                loading : false,
            }
        
        case FETCH_COMMENTS_FAILURE:
            return {
                ...state,
                err: action.payload,
                loading : false,
            }
            
        default:
            return state;
    }
}

export default commentsReducer;