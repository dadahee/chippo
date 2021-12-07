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
                <Route path = "/:name" element = {<InterviewList />} /> 
                <Route path = "/:name/:interviewId" element = {<CardNews />} />
                <Route path = "/:name/:interviewId/answer" element = {<CardNewsAnswer />} />
            </Routes>
            
        </Router>   
    );
};

export default App;