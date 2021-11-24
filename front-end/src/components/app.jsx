import React from 'react';
import { 
    BrowserRouter as Router, 
    Routes,
    Route, 
} from 'react-router-dom';

import Home from './home.jsx';

// 1. router 다운로드 및 세팅 (0)
// 2. 차크라 ui 다운로드 
// 3. 헤더 작성 구현
// 4. 다크모드 구현 ?
// 5. nav 구현
// 6. 사진 레이아웃 구성 (table)

function App(){
    return (
        <Router>
            {/* 헤더 작성 */}
            <div>
                <Routes>
                    <Route path = "/" element = {<Home />} />
                </Routes>
            </div>
        </Router>   
    );
};

export default App;