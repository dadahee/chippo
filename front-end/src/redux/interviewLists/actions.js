import {
    FETCH_INTERVIEWTAGS_SUCCESS,
    FETCH_INTERVIEWTAGS_FAILURE,
    FETCH_INTERVIEWTAGS_REQUEST,
} from "./types.js";

import { kakaoInterviewList } from "../../data.js";

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
