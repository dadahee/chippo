import {
    FETCH_INTERVIEWTAGS_SUCCESS,
    FETCH_INTERVIEWTAGS_FAILURE,
    FETCH_INTERVIEWTAGS_REQUEST,
} from "./types.js";

import { kakaoInterviewLists } from "../../data.js";

const fetchInterviewListSuccess = (comment) => {
    return {
        type: FETCH_INTERVIEWTAGS_SUCCESS,
        payload : comment
    }
}

const fetchInterviewListFailure = (error) => {
    return {
        type : FETCH_INTERVIEWTAGS_FAILURE,
        payload : error
    }
}

const fetchInterviewListRequest = () => {
    return {
        type : FETCH_INTERVIEWTAGS_REQUEST,
    }
} 

const fetchInterviewTagApi = (InterviewList) => {
    return new Promise((res, rej) => {
        if(InterviewList) res(InterviewList);
        else rej("에러 발생");
    })
}

export const fetchInterviewTags = () => {
    return (dispatch) => {
        dispatch(fetchInterviewListRequest());
        fetchInterviewTagApi(kakaoInterviewLists)
            .then(res => dispatch(fetchInterviewListSuccess(res)))
            .catch(err => dispatch(fetchInterviewListFailure(err)))
    }
}