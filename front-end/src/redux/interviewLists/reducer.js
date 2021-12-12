import { 
    FETCH_INTERVIEWTAGS_SUCCESS,
    FETCH_INTERVIEWTAGS_FAILURE,
    FETCH_INTERVIEWTAGS_REQUEST,
} from './types.js';

const initialState = {
    items : [],
    loading : false,
    err : null,
}

const loadInterviewTagReducer = (state = initialState, action) => {
    switch(action.type){
        case FETCH_INTERVIEWTAGS_REQUEST:
            return {
                ...state,
                loading: true,
            }
        
        case FETCH_INTERVIEWTAGS_SUCCESS:
            return {
                ...state,
                items: action.payload,
                loading : false,
            }
        
        case FETCH_INTERVIEWTAGS_FAILURE:
            return {
                ...state,
                err: action.payload,
                loading : false,
            }

        default:
            return state;
    }
}

export default loadInterviewTagReducer;