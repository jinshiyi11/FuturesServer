import React, { Component } from 'react';
import "./Manager.css"
import { Link, Route, Switch } from 'react-router-dom';
import AppBar from 'material-ui/AppBar';
import FlatButton from 'material-ui/FlatButton';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import axios from 'axios';
import * as Util from './util/util'
import * as Log from './util/log'
import LeftMenu from './LeftMenu';
import Futures from './Futures';
import Comment from './Comment';
import About from './About';

class Main extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: '',
      password: ''
    }
  }

  render() {
    return (
      <div>
        <AppBar title="老鹰期货" showMenuIconButton={false} 
        //iconElementRight={<FlatButton label="登录" onClick={()=>this.props.history.push("/login")} />} 
          />
        <Route path="/mymanager" render={(props) =><LeftMenu {...props} className="leftMenu"/>}/>
          <Switch>
            <div className="right">
              <Route exact path="/mymanager" component={Futures} />
              <Route path="/mymanager/futures" component={Futures} />
              <Route path="/mymanager/comment" component={Comment} />
              <Route path="/mymanager/about" component={About} />
            </div>
          </Switch>
      </div>
    );
  }
}

export default Main;

