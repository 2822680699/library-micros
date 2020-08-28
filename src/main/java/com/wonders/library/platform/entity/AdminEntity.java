package com.wonders.library.platform.entity;

import lombok.Data;

import java.util.*;

/**
 * 管理员信息
 */
@Data
public class AdminEntity {

    private int id;//编号
    private String jobNo;//工号
    private String userName;//用户名
    private String password;//密码·
    private String name;//管理员姓名
    private String mobile;//管理员联系方式
    private int isDelete;//0：未删除  1、已删除
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
}
