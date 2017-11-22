import React, { Component } from 'react';
import Drawer from 'material-ui/Drawer';
import Paper from 'material-ui/Paper';
import Menu from 'material-ui/Menu';
import MenuItem from 'material-ui/MenuItem';
import { Link } from 'react-router-dom'
import { List, ListItem } from 'material-ui/List';

const style = {
  display: 'inline-block',
  // margin: '16px 32px 16px 0',
};

class LeftMenu extends Component {
  constructor(props) {
    super(props)
    this.state = {
      drawOpened: true
    }
  }

  render() {
    return (
      <List className={this.props.className}>
        <ListItem primaryText="期货信息" onClick={() => this.props.history.push("/futures")} />
        <ListItem primaryText="评论" onClick={() => this.props.history.push("/comment")} />
        <ListItem primaryText="关于" onClick={() => this.props.history.push("/about")} />
      </List>
    )
  }

}

export default LeftMenu;