package com.wonders.library.platform.dao;

import com.wonders.library.platform.entity.AdminEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

/**
 * 管理员DAO
 */
@Mapper
public interface AdminDao {

    /**
     * 获取管理员信息列表
     *
     * @param page 页数
     * @param rows     条数
     * @return
     */
    List<AdminEntity> find(@Param("page") int page, @Param("rows") int rows);


    /**
     * 新增管理员信息
     *
     * @param jobNo      工号
     * @param userName   用户名
     * @param password   密码
     * @param name       姓名
     * @param mobile     手机号码
     * @param createTime 更新时间
     * @return
     */
    int insert(@Param("jobNo") String jobNo, @Param("userName") String userName,
               @Param("password") String password, @Param("name") String name,
               @Param("mobile") String mobile, @Param("createTime") Date createTime);

    /**
     * 获取管理员详情
     * @param userName 用户名
     * @return
     */
    AdminEntity getById(@Param("userName") String userName);

    /**
     * 获取总条数
     * @return
     */
    int count();


}
