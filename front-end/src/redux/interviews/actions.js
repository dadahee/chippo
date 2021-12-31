import { 
    FETCH_INTERVIEWID_SUCCESS,
    FETCH_INTERVIEWID_FAILURE,
    FETCH_INTERVIEWID_REQEUST,
} from './types.js';

import { idInterview } from '../../data.js';

const fetchInterviewIdSuccess = (interview) => {
    return {
        type: FETCH_INTERVIEWID_SUCCESS,
        payload : interview
    }
}

const fetchInterviewIdFailure = (error) => {
    return {
        type : FETCH_INTERVIEWID_FAILURE,
        payload : error
    }
}

const fetchInterviewIdRequest = () => {
    return {
        type : FETCH_INTERVIEWID_REQEUST,
    }
} 

const fetchInterviewIdApi = (interview) => {
    return new Promise((res, rej) => {
        if(interview) res(interview);
        else rej("에러 발생");
    })
}

export const fetchInterviewId = (id) => {
    return (dispatch) => {
        dispatch(fetchInterviewIdRequest());
        fetchInterviewIdApi(idInterview[id])
            .then(res => dispatch(fetchInterviewIdSuccess(res)))
            .catch(err => dispatch(fetchInterviewIdFailure(err)))
    }
}