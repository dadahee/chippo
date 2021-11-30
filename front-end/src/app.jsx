import React from 'react';
import { 
    BrowserRouter as Router, 
    Routes,
    Route, 
} from 'react-router-dom';

import Home from './pages/home.jsx';
import Login from './pages/login.jsx';

import ChippoHeader from './components/header.jsx';

// 1. 로그인 페이지 생성

function App(){
    return (
        <Router>

            <ChippoHeader />
            <Routes>
                <Route path = "/login" element = {<Login />} />
                <Route path = "/" element = {<Home />} />
                <Route path = "/username" element = {<Home />} />
            </Routes>
            
        </Router>   
    );
};

export default App;