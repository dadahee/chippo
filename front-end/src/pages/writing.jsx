import React from 'react';
import { useNavigate } from 'react-router-dom';

import { connect } from "react-redux";

function Writing({ logined }){

    const navigator = useNavigate();
    
    if (logined === false) navigator("/login");

    return (
        <div>새글작성 페이지</div>
    )
}

const mapStateToProps = ({ logined }) => {
    return {
        logined : logined.login
    }
}

export default connect(mapStateToProps)(Writing);