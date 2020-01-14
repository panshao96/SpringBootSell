# SpringBootSell
一个外卖平台

### 展示
* 订单列表
[![订单列表展示](https://i.postimg.cc/dt8Dpcn6/2020-01-14-094929.png)](https://postimg.cc/SJxyY5BY)

* 商品列表
[![商品列表展示](https://i.postimg.cc/gj3cC3yj/2020-01-14-095005.png)](https://postimg.cc/y3Yz9gbC)


### 环境
* JDK 1.8.0_111
* Maven 3.3.9
* SpringBoot 2.2.1
* MySQL 8.0.18
* Redis

### 下载
```
git clone https://github.com/panshao96/SpringBootSell.git
```

### 数据库
* 新建一个字符集为：utf8mb4，排序规则为：utf8mb4_general_ci的数据库。
* 在此数据库下运行根目录下的spring.sql文件
* 在./src/main/resources/application.yml文件的spring.datasource字段可修改数据库的连接信息

### Websocket
* 在./src/main/resources/order/list.ftl修改websocket = new WebSocket('ws://121.43.120.166:8080/sell/webSocket');
* 将其中的ip地址修改为部署位置的ip


### 打包
```
mvn clean package -Dmaven.test.skip=true
```

### 部署
```
java -jar 'jar包的绝对路径'
```

### 试用链接
```

```
