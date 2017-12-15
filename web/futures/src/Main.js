import React, { Component } from 'react';
import "./Main.css"
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
import {
  Table,
  TableBody,
  TableHeader,
  TableHeaderColumn,
  TableRow,
  TableRowColumn,
} from 'material-ui/Table';


class Main extends Component {
  constructor(props) {
    super(props);
    this.libs = [
      {
        name: "android-pulltorefresh",
        comment: "一个强大的拉动刷新开源项目，支持各种控件下拉刷新",
        address: "https://github.com/chrisbanes/Android-PullToRefresh"
      }, {
        name: "SwipeListView",
        comment: "支持定义 ListView 左右滑动事件，支持左右滑动位移，支持定义动画时间",
        address: "https://github.com/47deg/android-swipelistview"
      }, {
        name: "EasySlidingTabs",
        comment: "一款简单、易用的滑动标签页",
        address: "https://github.com/CaMnter/EasySlidingTabs"
      }, {
        name: "FButton",
        comment: "扁平化的 Button",
        address: "https://github.com/hoang8f/android-flat-button"
      }, {
        name: "FancyButtons",
        comment: "一个不用图片就可以帮助我们创建出漂亮按钮的库",
        address: "https://github.com/medyo/fancybuttons"
      }, {
        name: "Android-Universal-Image-Loader",
        comment: "图片缓存，目前使用最广泛的图片缓存，支持主流图片缓存的绝大多数特性",
        address: "https://github.com/nostra13/Android-Universal-Image-Loader"
      }, {
        name: "picasso",
        comment: "square 开源的图片缓存",
        address: "https://github.com/square/picasso"
      }, {
        name: "fresco",
        comment: "一款强大的图片缓存工具，由 Facebook 开发",
        address: "https://github.com/facebook/fresco"
      }, {
        name: "Glide",
        comment: "Glide 是一个 android 平台上的快速和高效的开源的多媒体资源管理库",
        address: "https://github.com/bumptech/glide"
      }, {
        name: "",
        comment: "",
        address: ""
      }
    ];
  }

  render() {
    const listItems = this.libs.map((lib) =>
      <TableRow>
        <TableRowColumn>{lib.name}</TableRowColumn>
        <TableRowColumn>{lib.comment}</TableRowColumn>
        <TableRowColumn>{lib.address}</TableRowColumn>
      </TableRow>
    );

    return (
      <div>
        <AppBar title="自由的老鹰--分享android学习笔记" showMenuIconButton={false}
        //iconElementRight={<FlatButton label="登录" onClick={()=>this.props.history.push("/login")} />} 
        />
        <Table selectable={false}>
          <TableHeader displaySelectAll={false} adjustForCheckbox={false}>
            <TableRow>
              <TableHeaderColumn>名称</TableHeaderColumn>
              <TableHeaderColumn>说明</TableHeaderColumn>
              <TableHeaderColumn>项目地址</TableHeaderColumn>
            </TableRow>
          </TableHeader>
          <TableBody stripedRows={true} showRowHover={true} displayRowCheckbox={false}>
            {listItems}
          </TableBody>
        </Table>
        <footer class="page-footer">
          <div class="footer-copyright">
            <div class="container">
            © 2017 Copyright
            {/*<a class="grey-text text-lighten-4 right" href="#!">More Links</a>*/}
            </div>
          </div>
        </footer>
      </div>
    );
  }
}

export default Main;

