package com.wonders.library.platform.controller;

import com.alibaba.fastjson.JSONObject;
import com.wonders.library.common.utils.ResultVo;
import com.wonders.library.platform.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
@Slf4j
@Api(tags = "管理员API")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/list")
    @ApiOperation("获取管理员列表信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "页数", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "rows", value = "条数", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "authorization", value = "唯一授权码", paramType = "header", dataType = "String")})
    public ResultVo userList(@RequestParam String page, @RequestParam String rows,@RequestHeader String authorization) {
        if (StringUtils.isEmpty(page)) {
            return ResultVo.failed("页数不可为空！");
        }
        if (StringUtils.isEmpty(rows)) {
            return ResultVo.failed("条数不可为空！");
        }
        ResultVo resultVo = adminService.getAdminList(Integer.parseInt(page), Integer.parseInt(rows));
        return resultVo;
    }

    @PostMapping("/save")
    @ApiOperation("新增管理员信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "jobNo", value = "工号", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "userName", value = "用户名", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "password", value = "用户名", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "name", value = "管理员姓名", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "mobile", value = "管理员联系方式", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "authorization", value = "唯一授权码", paramType = "header", dataType = "String")})
    public ResultVo addUser(@RequestParam String jobNo
            , @RequestParam String userName, @RequestParam String password
            , @RequestParam String name, @RequestParam String mobile,@RequestHeader String authorization) {
        if (StringUtils.isEmpty(jobNo)) {
            return ResultVo.failed("工号不可为空！");
        }
        if (StringUtils.isEmpty(userName)) {
            return ResultVo.failed("用户信息不可为空！");
        }
        if (StringUtils.isEmpty(password)) {
            return ResultVo.failed("密码不可为空！");
        }
        if (StringUtils.isEmpty(name)) {
            return ResultVo.failed("姓名不可为空！");
        }
        if (StringUtils.isEmpty(mobile)) {
            return ResultVo.failed("联系方式不可为空！");
        }
        ResultVo resultVo = adminService.addAdmin(jobNo, userName, password, name, mobile);
        return resultVo;
    }
}
