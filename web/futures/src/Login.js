import React, { Component } from 'react';
import { connect } from 'react-redux'
import * as Actions from './actions'
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import axios from 'axios';
import * as qs from 'qs';
import * as Util from './util/util'
import * as Log from './util/log'

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
    return (
      <div>
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
        <RaisedButton label="登录" primary={true} onClick={this.doLogin} />
      </div>
    );
  }

  doLogin(event) {
    var payload = {
      "username": this.state.username,
      "password": this.state.password
    };
    axios.post("/api/login", qs.stringify(payload))
      .then((response) => {
        console.log(response);
        if (response.status == 200 && response.data && response.data.code == 0) {
          let uid=response.data.data.uid
          let token=response.data.data.token
          this.props.loginSuccessDispatch(uid,token)
          this.props.history.goBack();
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

export default connect(
  null,
  mapDispatchToProps
)(Login)