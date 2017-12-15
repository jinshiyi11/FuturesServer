import React, { Component } from 'react';
import { connect } from 'react-redux'
import { withRouter } from 'react-router'
import * as Actions from './actions'
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import axios from 'axios';
import md5 from "blueimp-md5"
import * as qs from 'qs';
import * as Util from './util/util'
import * as Log from './util/log'
import "./Login.css"

class Login extends Component {
  constructor(props) {
    super(props);
    this.doLogin = this.doLogin.bind(this);
    this.state = {
      username: '',
      password: ''
    }
  }

  render() {
    console.log("login")
    return (
      <div className="center">
        {/*<AppBar showMenuIconButton={false} title="老鹰财经"/>*/}
        <TextField
          name="username"
          hintText="请输入用户名"
          onChange={(event, newValue) => this.setState({ username: newValue })}
        />
        <br />
        <TextField
          name="password"
          type="password"
          hintText="请输入密码"
          onChange={(event, newValue) => this.setState({ password: newValue })}
        />
        <br />
        <RaisedButton className="loginButton" fullWidth={true} label="登录" primary={true} onClick={this.doLogin} />
      </div>
    );
  }

  doLogin(event) {
    var payload = {
      "username": this.state.username,
      "password": md5(this.state.password)
    };
    axios.post("/api/login", qs.stringify(payload))
      .then((response) => {
        console.log(response);
        if (response.status == 200 && response.data && response.data.code == 0) {
          let uid=response.data.data.uid
          let token=response.data.data.token
          this.props.loginSuccessDispatch(uid,token)
          // this.props.history.goBack();
          this.props.history.replace("/mymanager")
        }
      })
  }

}

const mapDispatchToProps = dispatch => {
  return {
    loginSuccessDispatch: (uid,token) => {
      dispatch(Actions.loginSuccess(uid,token))
    }
  }
}

export default withRouter(connect(
  null,
  mapDispatchToProps
)(Login))