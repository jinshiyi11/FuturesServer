import React, { Component } from 'react';
import { connect } from 'react-redux'
import { withRouter } from 'react-router'
import logo from './logo.svg';
import './App.css';
import { Route, Switch, Redirect } from 'react-router-dom';
import Login from './Login';
import Main from './Main';
import NotFound from './NotFound'
import {requireAuthentication} from './AuthenticatedComponent'

const PrivateRoute = ({ component: Component,token, ...rest }) => {
  return (
  <Route {...rest} render={props => {
    console.log(props)
    return token ? (
      <Component {...props}/>
    ) : (
      <Redirect to={{
        pathname: '/login',
        state: { from: props.location }
      }}/>
    )
  }}/>)
}

class App extends Component {
   constructor(props) {
    super(props)
   }
  
  render() {
    return (
      <Switch>
        <Route path="/login" component={Login} />
        {/*<Route path="/" render={() => {
          console.log("yyyyy")
          if (!this.props.token) {
            console.log("yyyyy222")
            return (
              <Redirect to={{
                pathname: '/login',
                state: { from: this.props.location }
              }} />
            )
          } else {
            console.log("yyyyy33")
            return <Main />
          }
        }} />*/}
        <PrivateRoute path="/" token={this.props.token} component={Main}/>
        {/*<Route path="/" component={requireAuthentication(Main)}/>*/}
        <Route component={NotFound} />
      </Switch>
    );

  }
}


const mapStateToProps = state => {
  return {
    token: state.token
  }
}

export default withRouter(connect(
  mapStateToProps
)(App));
