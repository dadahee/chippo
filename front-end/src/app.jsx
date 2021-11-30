import React from 'react';
import { 
    BrowserRouter as Router, 
    Routes,
    Route, 
} from 'react-router-dom';

import Home from './pages/home.jsx';
import Login from './pages/login.jsx';
import InterviewList from './pages/interviewList.jsx';

import ChippoHeader from './components/header.jsx';

// 1. 이미지 넣고 라우터 구성하기
// 2. 이미지 클릭 시 이동하게 만들기
// 3. 닉네임 칸 만들기
// 4. 새 글 작성 만들기

function App(){
    return (
        <Router>
            <ChippoHeader />
            <Routes>
                <Route path = "/login" element = {<Login />} />
                <Route path = "/" element = {<Home />} />
                <Route path = "/username" element = {<Home />} />
                <Route path = "/:name" element = {<InterviewList />}/>
            </Routes>
            
        </Router>   
    );
};

export default App;