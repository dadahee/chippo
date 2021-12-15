import React from 'react';
import { 
    BrowserRouter as Router, 
    Routes,
    Route, 
} from 'react-router-dom';

import Home from './pages/home.jsx';
import Login from './pages/login.jsx';
import InterviewList from './pages/interviewList.jsx';
import CardNews from './pages/cardNews.jsx';
import CardNewsAnswer from './pages/cardNewsAnswer.jsx';

import ChippoHeader from './components/header.jsx';

function App(){
    return (
        <Router>
            <ChippoHeader />
            <Routes>
                <Route path = "/" element = {<Home />} />
                <Route path = "/login" element = {<Login />} />
                <Route path = "/username" element = {<Home />} />
                <Route path = "/interviews" element = {<InterviewList />} /> 
                <Route path = "/interviews/:interviewId/pre-answer" element = {<CardNews />} /> 
                <Route path = "/interviews/:interviewId/answer" element = {<CardNewsAnswer />} /> 
                <Route path = "/username/myPage"></Route>
                
            </Routes>
            
        </Router>   
    );
};

export default App;