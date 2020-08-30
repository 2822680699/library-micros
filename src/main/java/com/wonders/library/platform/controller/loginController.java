package com.wonders.library.platform.controller;

import com.alibaba.fastjson.JSONObject;
import com.wonders.library.common.filter.JwtConfig;
import com.wonders.library.common.filter.JwtHelper;
import com.wonders.library.common.utils.MD5Utils;
import com.wonders.library.common.utils.ResultVo;
import com.wonders.library.platform.entity.AdminEntity;
import com.wonders.library.platform.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Api(tags = "授权登录API")
@Slf4j
public class loginController {

    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    @ApiOperation("登录校验")
    @ApiImplicitParams({@ApiImplicitParam(name = "loginName", value = "账号", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "password", value = "密码", paramType = "query", dataType = "String")})
    public Object login(HttpServletResponse response, String loginName, String password) {
        try {
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put("loginName", loginName);
            ResultVo resultVo = adminService.getById(loginName);
            log.info("获取管理员信息:" + JSONObject.toJSON(resultVo));
            AdminEntity data = (AdminEntity) resultVo.getData();
            password = MD5Utils.md5(password);
            if (data != null && password.equals(data.getPassword())) {
                response.setHeader("token", jwtHelper.generateToken(claims).toString());
                return ResultVo.success(jwtHelper.generateToken(claims));
            } else {
                return ResultVo.failed("登录帐号或者登录密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failed("网络开小差！");
        }
    }
}
