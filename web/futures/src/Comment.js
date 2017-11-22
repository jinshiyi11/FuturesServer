import React, { Component } from 'react';
import { connect } from 'react-redux'
import * as Actions from './actions'
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import axios from 'axios';
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

class Comment extends Component {
  constructor(props) {
    super(props)
    this.getCommentList = this.getCommentList.bind(this)
    this.state = {
      startCommentId: 0xffffffff,
      commentList: []
    }
  }

  componentDidMount() {
    this.getCommentList()
  }

  getCommentList() {
    let access_token=this.props.token
    axios.get("/api/getAllCommentList", {
      params: {
        startCommentId: this.state.startCommentId,
        access_token
      }
    })
      .then(response => {
        Log.log(response)
        if (response.status == 200 && response.data && response.data.code == 0) {
          this.setState({
            commentList: response.data.data
          })
        }
      }).catch(err => {
        Log.log(err)
      })
  }

  render() {
    const listItems = this.state.commentList.map((comment) =>
      <TableRow>
        <TableRowColumn>{comment.id}</TableRowColumn>
        <TableRowColumn>{comment.pid}</TableRowColumn>
        <TableRowColumn>{comment.ppid}</TableRowColumn>
        <TableRowColumn>{comment.date}</TableRowColumn>
        <TableRowColumn>{comment.content}</TableRowColumn>
        <TableRowColumn>
          <RaisedButton label="删除" secondary={true} className="deleteButton" />
        </TableRowColumn>
      </TableRow>
    );


    return ( 
    <Table selectable={false}>
      <TableHeader displaySelectAll={false} adjustForCheckbox={false}>
        <TableRow>
          <TableHeaderColumn>id</TableHeaderColumn>
          <TableHeaderColumn>pid</TableHeaderColumn>
          <TableHeaderColumn>ppid</TableHeaderColumn>
          <TableHeaderColumn>时间</TableHeaderColumn>
          <TableHeaderColumn>内容</TableHeaderColumn>
          <TableHeaderColumn>操作</TableHeaderColumn>
        </TableRow>
      </TableHeader>
      <TableBody stripedRows={true} showRowHover={true} displayRowCheckbox={false}>
        {listItems}
      </TableBody>
    </Table>
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
)(Comment)