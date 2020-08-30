图书馆项目：library-micros

框架技术：springBoot+Mybatis+H2

功能模块：
   1、管理员信息查询、新增
   2、登录授权（JWT）
   3、书籍的增、删、查、改

调试方式：postman、swagger

接口:
/library/login         跳转登录页面
/library/book          跳转书籍管理页面
/library/update        跳转修改页面
/library/create        跳转新增页面
/library/auth/login    登录授权
/library/admin/list    管理员信息列表
/library/admin/save    新增管理员信息
/library/book/list     书籍列表信息
/library/book/save     新增书籍信息
/library/book/byId     书籍详情信息
/library/book/del      删除书籍信息
/library/book/updated  修改书籍信息

项目框架:
library-micros
  -main
     -java
        -com.wonders.library
           -common
              -config   
                 -SwaggerConfig.java       swagger配置
              -filter          
                 -JwtConfig.java           拦截地址配置
                 -JwtFilter.java           JWT校验
                 -JwtHelper.java           获取JWT返回值参数
              -utils                       工具类
           -platform                                   
              -controller                  控制层
                 -AdminController.java     管理员控制层
                 -bookController.java      书籍控制层
                 -ControllerException.java 异常处理控制层
                 -loginController          授权登录控制层
              -dao                         DAO层
                 -AdminDao.java            管理员DAO层
                 -BookDao.java             书籍DAO层
              -entity                      实体封装
                 -AdminEntity.java         管理员实体封装
                 -BookEntity.java          书籍实体封装
              -service                     接口封装
                 -impl                     接口实现
                    -AdminSericeImpl.java  管理员逻辑实现
                    -BookSericeImpl.java   书籍逻辑实现
                 -AdminService.java        管理员接口封装
                 -BookService.java         书籍接口封装
     -resources
        -mapper                            
           -AdminMapper.xml                管理员mapper
           -BookMapper.xml                 书籍mapper
        -sql
           -data.sql                       数据新增sql
           -library.sql                    创建表sql
        -static                            静态文件（image、js、css）
        -templates                         html文件（login已完成、index.html在优化中）