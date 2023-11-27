import React, { Component } from 'react';
import ReactBootstrapNavbars from './components/ReactBootstrapNavbars';
import { Route, Switch } from "react-router-dom";


// 컴포넌트 아래에 다음의 import 구문을 넣어주시기 바랍니다.
import 'bootstrap/dist/css/bootstrap.css'; 
import Home from './components/Home';
import About from './components/About';
import Footer from './components/Footer';
import Community from './components/Community';
import QnA from './components/QnA';
import Location from './components/Location';
import Notice from './components/Notice';
import FreeBoard from './components/FreeBoard';
import CommunityBoard from './components/CommunityBoard';
import Login from './components/Login';
import ContactUsRead from './components/ContactUsRead';
import ContactUsWrite from './components/ContactUsWrite';

class App extends Component {
  render() {
    return (
      <div>
        <ReactBootstrapNavbars />
        <Switch>
          <Route exact path="/" component={Login} />
          <Route exact path="/Home" component={Home} />
          <Route exact path="/About" component={About} />
          <Route exact path="/Community" component={Community} />
          <Route exact path="/QnA" component={QnA} />
          <Route exact path="/Location" component={Location} />
          <Route exact path="/notice" component={Notice} />
          <Route exact path="/freeboard" component={FreeBoard} />
          <Route exact path="/communityboard" component={CommunityBoard} />
          <Route exact path="/contactUs/insert" component={ContactUsWrite} />          
          <Route exact path="/contactUs/view" component={ContactUsRead} />          
        </Switch>
        <Footer />
      </div>
    );
  }
}

export default App;