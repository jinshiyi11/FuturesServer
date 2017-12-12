import React, { Component } from 'react';
import { connect } from 'react-redux'
import * as Actions from './actions'
import "./Futures.css"
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import axios from 'axios';
import * as qs from 'qs';
import * as Util from './util/util'
import * as Log from './util/log'
import {
  Table,
  TableBody,
  TableHeader,
  TableHeaderColumn,
  TableRow,
  TableRowColumn,
} from 'material-ui/Table';

class Futures extends Component {
  constructor(props) {
    super(props)
    this.state = {
      futuresList: []
    }
    this.addFutures = this.addFutures.bind(this)
    this.getFuturesList = this.getFuturesList.bind(this)
    this.deleteFutures = this.deleteFutures.bind(this)
  }

  componentDidMount() {
    this.getFuturesList()
  }

  getFuturesList(){
    axios.get('/api/getFuturesList')
      .then(response => {
        Log.log(response)
        this.setState({
          futuresList: response.data.data
        })
      }).catch(err => {
        Log.log(err)
      })
  }

  addFutures(event) {
    Log.log("addFutures")
    let name = this.refs.name.getValue()
    let title = this.refs.title.getValue()
    let access_token=this.props.token
    axios.post('/api/addFutures', qs.stringify({ name, title,access_token }))
      .then(response => {
        Log.log(response)
        this.getFuturesList()
      }).catch(err => {
        Log.log(err)

      })
  }

 deleteFutures(id) {
    Log.log("deleteFutures")
    let access_token=this.props.token
    axios.post('/api/deleteFutures', qs.stringify({ id,access_token}))
      .then(response => {
        Log.log(response)
        this.getFuturesList()
      }).catch(err => {
        Log.log(err)

      })
  }

  render() {
    const listItems = this.state.futuresList.map((futures) =>
      <TableRow>
        <TableRowColumn>{futures.id}</TableRowColumn>
        <TableRowColumn>{futures.name}</TableRowColumn>
        <TableRowColumn>{futures.title}</TableRowColumn>
        <TableRowColumn>
          <RaisedButton label="编辑" primary={true}/>
          <RaisedButton label="删除" secondary={true} className="deleteButton" onClick={()=>this.deleteFutures(futures.id)}/>
        </TableRowColumn>
      </TableRow>
    );
    return (
      <div>
        <div>
          <span>期货id</span><TextField ref="name" name="name" /><span>期货名称</span><TextField ref="title" name="title" />
          <RaisedButton label="添加" primary={true} onClick={this.addFutures} />
        </div>
        <Table selectable={false}>
          <TableHeader displaySelectAll={false} adjustForCheckbox={false}>
            <TableRow>
              <TableHeaderColumn>ID</TableHeaderColumn>
              <TableHeaderColumn>Name</TableHeaderColumn>
              <TableHeaderColumn>Title</TableHeaderColumn>
              <TableHeaderColumn>操作</TableHeaderColumn>
            </TableRow>
          </TableHeader>
          <TableBody stripedRows={true} showRowHover={true} displayRowCheckbox={false}>
            {listItems}
          </TableBody>
        </Table>
      </div>
    );
  }
}

const mapStateToProps = state => {
  return {
    uid: state.uid,
    token:state.token
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
  mapStateToProps,
  mapDispatchToProps
)(Futures)