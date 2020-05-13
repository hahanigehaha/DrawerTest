# DrawerTest Demo

Project Name: DrawerTest

Package Name: com.example.drawertest

Min SDK: API21 Android5.0

Target : 29

Implementation:

- Fresco:2.2.0
- RecyclerView:1.1.0

---

任务拆解：

- [x] 搭建仓库，配置基础环境。0.5day
- [ ]   主页面左滑或者点击更多直播出现抽屉，点击左边空余地区或右滑隐藏。 第一步 1day

1. a. 滑出抽屉，相应数据未到时展示“房间Loading”图标。              

1. b. 数据到达时展示主播房间信息，图片未加载时显示placeholder。     

1. c. 关闭抽屉，抽屉滑出隐藏。                                    

1. d. 关闭抽屉，再次打开不会重新加载。

- [ ] 下拉刷新，获取新的Banner以及主播列表。第二步 0.5day

1. a. 下拉获取新数据，数据未到达时展示“下拉Loading”图标。

1. b. 数据到达时展示主播房间信息，图片未加载时显示placeholder。

- [ ] 上滑拉取新的数据。 第三步 0.5day

1. a. 数据未到达时展示“房间Loading”图标。

1. b. 数据到达时展示主播房间信息，图片未加载时显示placeholder。