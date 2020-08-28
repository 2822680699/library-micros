package com.wonders.library.platform.service;

import com.wonders.library.common.utils.ResultVo;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 管理员service
 */
public interface AdminService {

    /**
     * 获取管理员列表信息
     *
     * @param page 页数
     * @param rows     条数
     * @return
     */
    ResultVo getAdminList(int page, int rows);

    /**
     * 新增管理员信息
     *
     * @param jobNo    工号
     * @param userName 用户名
     * @param password 密码
     * @param name     姓名
     * @param mobile   联系方式
     * @return
     */
    ResultVo addAdmin(String jobNo, String userName, String password, String name, String mobile);

    /**
     * 获取管理员详情信息
     *
     * @param userName 用户名
     * @return
     */
    ResultVo getById(String userName);
}
