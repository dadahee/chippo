import { 
    FETCH_INTERVIEWID_SUCCESS,
    FETCH_INTERVIEWID_FAILURE,
    FETCH_INTERVIEWID_REQEUST,
} from './types.js';

const initialState = {
    items : [],
    loading : false,
    err : null,
}

const loadInterviewIdReducer = (state = initialState, action) => {
    switch(action.type){
        case FETCH_INTERVIEWID_REQEUST:
            return {
                ...state,
                loading: true,
            }
        
        case FETCH_INTERVIEWID_SUCCESS:
            return {
                ...state,
                items: action.payload,
                loading : false,
            }
        
        case FETCH_INTERVIEWID_FAILURE:
            return {
                ...state,
                err: action.payload,
                loading : false,
            }

        default:
            return state;
    }
}

export default loadInterviewIdReducer;