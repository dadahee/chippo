import {
    LOG_IN,
    LOG_OUT,
} from "./types.js";

const loginAction = () => {
    return {
        type : LOG_IN,
    }
}

const logoutAction = () => {
    return {
        type : LOG_OUT
    }
}

export const doLogin = () => {
    return (dispatch) => {
        dispatch(loginAction());
    }
}

export const doLogout = () => {
    return (dispatch) => {
        dispatch(logoutAction());
    }
}