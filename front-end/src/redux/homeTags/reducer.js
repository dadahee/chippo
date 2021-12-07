import { 
    FETCH_TAGS_SUCCESS,
    FETCH_TAGS_FAILURE,
    FETCH_TAGS_REQEUST,
} from './types.js';

const initialState = {
    items : [],
    loading : false,
    err : null,
}

const loadHomeTagReducer = (state = initialState, action) => {
    switch(action.type){
        case FETCH_TAGS_REQEUST:
            return {
                ...state,
                loading: true,
            }
        
        case FETCH_TAGS_SUCCESS:
            return {
                ...state,
                items: action.payload,
                loading : false,
            }
        
        case FETCH_TAGS_FAILURE:
            return {
                ...state,
                err: action.payload,
                loading : false,
            }

        default:
            return state;
    }
}

export default loadHomeTagReducer;