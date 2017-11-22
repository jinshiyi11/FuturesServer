import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { Route, Switch } from 'react-router-dom';
import Login from './Login';
import Main from './Main';
import NotFound from './NotFound'

class App extends Component {
  render() {
    return (
        <Switch>
          <Route path="/login" component={Login}/>
          <Route path="/" component={Main}/>
          <Route component={NotFound} />
        </Switch>
    );
  }
}

export default App;
