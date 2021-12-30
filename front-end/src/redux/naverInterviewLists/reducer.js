import { 
    FETCH_NAVER_INTERVIEWTAGS_SUCCESS,
    FETCH_NAVER_INTERVIEWTAGS_FAILURE,
    FETCH_NAVER_INTERVIEWTAGS_REQUEST,
} from './types.js';

const initialState = {
    items : [],
    loading : false,
    err : null,
}

const loadNaverInterviewTagReducer = (state = initialState, action) => {
    switch(action.type){
        case FETCH_NAVER_INTERVIEWTAGS_REQUEST:
            return {
                ...state,
                loading: true,
            }
        
        case FETCH_NAVER_INTERVIEWTAGS_SUCCESS:
            return {
                ...state,
                items: action.payload,
                loading : false,
            }
        
        case FETCH_NAVER_INTERVIEWTAGS_FAILURE:
            return {
                ...state,
                err: action.payload,
                loading : false,
            }

        default:
            return state;
    }
}

export default loadNaverInterviewTagReducer;