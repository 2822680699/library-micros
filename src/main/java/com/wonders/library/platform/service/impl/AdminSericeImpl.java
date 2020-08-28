package com.wonders.library.platform.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wonders.library.common.utils.MD5Utils;
import com.wonders.library.common.utils.ResultVo;
import com.wonders.library.platform.dao.AdminDao;
import com.wonders.library.platform.entity.AdminEntity;
import com.wonders.library.platform.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class AdminSericeImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Override
    public ResultVo getAdminList(int page, int rows) {
        List<AdminEntity> adminEntityList = new ArrayList<AdminEntity>();
        JSONObject jsonObject = new JSONObject();
        try {
            page = (page - 1) * rows;
            int num=adminDao.count();
            adminEntityList = adminDao.find(page, rows);
            log.info("获取管理员列表信息" + JSONObject.toJSON(adminEntityList));
            jsonObject.put("count",num);
            jsonObject.put("list",adminEntityList);
            return ResultVo.success(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failed("网络开小差哦！");
        }
    }

    @Override
    public ResultVo addAdmin(String jobNo, String userName, String password, String name, String mobile) {
        try {
            AdminEntity adminEntity = adminDao.getById(userName);
            log.info("获取管理员信息" + JSONObject.toJSON(adminEntity));
            if (adminEntity == null) {
                password = MD5Utils.md5(password);
                int num = adminDao.insert(jobNo, userName, password, name, mobile, new Date());
                if (num > 0) {
                    return ResultVo.success("新增管理员信息成功");
                } else {
                    return ResultVo.failed("新增管理员信息失败");
                }
            } else {
                return ResultVo.success(JSONObject.toJSON(adminEntity), "用户已存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failed("网络开小差哦");
        }
    }

    @Override
    public ResultVo getById(String userName) {
        AdminEntity adminEntity = adminDao.getById(userName);
        return ResultVo.success(adminEntity);
    }
}
