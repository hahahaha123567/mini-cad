# 功能

使用Java语言编写GUI程序，做一个简单的绘图工具，以CAD的方式操作，能放置直线、矩形、圆和文字，能选中图形，修改参数，如颜色等，能拖动图形和调整大小，可以保存和恢复。

# 程序

### Model

interface MyShape

class MyLine;

class MyRectangle

class MyCircle

class MyText

### View

miniCAD.fxml  // 界面布局

miniCAD.css   // 样式表

### Control

程序逻辑使用状态机模式实现。

class Main     // 程序入口

class Controller // 用户操作与状态机之间的接口

interface State

class ToSelect

class ToClickFirstPoint

class ToClickSecondPoint