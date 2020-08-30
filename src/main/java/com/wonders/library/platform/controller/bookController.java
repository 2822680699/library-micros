package com.wonders.library.platform.controller;

import com.wonders.library.common.utils.ResultVo;
import com.wonders.library.platform.service.AdminService;
import com.wonders.library.platform.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
@Slf4j
@Api(tags = "书籍API")
public class bookController {

    @Autowired
    BookService bookService;

    @PostMapping("/list")
    @ApiOperation("获取书籍列表信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "页数", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "rows", value = "条数", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "name", value = "书籍名称", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "authorization", value = "唯一授权码", paramType = "header", dataType = "String")})
    public ResultVo userList(@RequestParam String page, @RequestParam String rows,@RequestParam String name,@RequestHeader String authorization) {
        System.out.println("authorization==="+authorization);
        if (StringUtils.isEmpty(page)) {
            return ResultVo.failed("页数不可为空！");
        }
        if (StringUtils.isEmpty(rows)) {
            return ResultVo.failed("条数不可为空！");
        }

        ResultVo resultVo = bookService.getBookList(Integer.parseInt(page), Integer.parseInt(rows),name);
        return resultVo;
    }


    @PostMapping("/save")
    @ApiOperation("新增书籍信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "书籍名称", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "isbn", value = "书籍编码", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "bkCaseId", value = "书架编号", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "price", value = "定价", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "author", value = "作者", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "type", value = "书籍类型", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "synopsis", value = "书籍简介", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "press", value = "出版社", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "image", value = "封面图片", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "Authorization", value = "唯一授权码", paramType = "header", dataType = "String")})
    public ResultVo addUser(@RequestParam String name, @RequestParam String isbn, @RequestParam String bkCaseId,
                            @RequestParam String price, @RequestParam String author, @RequestParam String type,
                            @RequestParam String synopsis, @RequestParam String press, @RequestParam String image,@RequestHeader String Authorization) {
        if (StringUtils.isEmpty(name)) {
            return ResultVo.failed("书籍名称不可为空！");
        }
        if (StringUtils.isEmpty(isbn)) {
            return ResultVo.failed("书籍编码不可为空！");
        }
        if (StringUtils.isEmpty(bkCaseId)) {
            return ResultVo.failed("书架编号不可为空！");
        }
        if (StringUtils.isEmpty(price)) {
            return ResultVo.failed("定价不可为空！");
        }
        if (StringUtils.isEmpty(author)) {
            return ResultVo.failed("作者不可为空！");
        }
        if (StringUtils.isEmpty(type)) {
            return ResultVo.failed("书籍类型不可为空！");
        }
        if (StringUtils.isEmpty(synopsis)) {
            return ResultVo.failed("书籍简介不可为空！");
        }
        if (StringUtils.isEmpty(press)) {
            return ResultVo.failed("出版社不可为空！");
        }
        if (StringUtils.isEmpty(image)) {
            return ResultVo.failed("封面图片不可为空！");
        }
        ResultVo resultVo = bookService.addBook(name, isbn, bkCaseId, price, author, type, synopsis, press, image);
        return resultVo;
    }


    @PostMapping("/byId")
    @ApiOperation("获取书籍详情信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "编号", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "authorization", value = "唯一授权码", paramType = "header", dataType = "String")})
    public ResultVo getById(@RequestParam String id,@RequestHeader String authorization) {
        if (StringUtils.isEmpty(id)) {
            return ResultVo.failed("编号不可为空！");
        }
        ResultVo resultVo = bookService.getById(Integer.parseInt(id));
        return resultVo;
    }

    @PostMapping("/del")
    @ApiOperation("删除书籍信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "编号", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "authorization", value = "唯一授权码", paramType = "header", dataType = "String")})
    public ResultVo delBook(@RequestParam String id,@RequestHeader String authorization) {
        if (StringUtils.isEmpty(id)) {
            return ResultVo.failed("编号不可为空！");
        }
        ResultVo resultVo = bookService.delBook(Integer.parseInt(id));
        return resultVo;
    }

    @PostMapping("/updated")
    @ApiOperation("修改书籍信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "编号", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "name", value = "书籍名称", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "isbn", value = "书籍编码", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "bkCaseId", value = "书架编号", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "price", value = "定价", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "author", value = "作者", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "type", value = "书籍类型", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "synopsis", value = "书籍简介", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "press", value = "出版社", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "image", value = "封面图片", paramType = "query", dataType = "String")
            , @ApiImplicitParam(name = "authorization", value = "唯一授权码", paramType = "header", dataType = "String")})
    public ResultVo putBook(@RequestParam String id, @RequestParam String name, @RequestParam String isbn, @RequestParam String bkCaseId,
                            @RequestParam String price, @RequestParam String author, @RequestParam String type,
                            @RequestParam String synopsis, @RequestParam String press, @RequestParam String image,@RequestHeader String authorization) {
        if (StringUtils.isEmpty(id)) {
            return ResultVo.failed("编号不可为空！");
        }
        if (StringUtils.isEmpty(name)) {
            return ResultVo.failed("书籍名称不可为空！");
        }
        if (StringUtils.isEmpty(isbn)) {
            return ResultVo.failed("书籍编码不可为空！");
        }
        if (StringUtils.isEmpty(bkCaseId)) {
            return ResultVo.failed("书架编号不可为空！");
        }
        if (StringUtils.isEmpty(price)) {
            return ResultVo.failed("定价不可为空！");
        }
        if (StringUtils.isEmpty(author)) {
            return ResultVo.failed("作者不可为空！");
        }
        if (StringUtils.isEmpty(type)) {
            return ResultVo.failed("书籍类型不可为空！");
        }
        if (StringUtils.isEmpty(synopsis)) {
            return ResultVo.failed("书籍简介不可为空！");
        }
        if (StringUtils.isEmpty(press)) {
            return ResultVo.failed("出版社不可为空！");
        }
        if (StringUtils.isEmpty(image)) {
            return ResultVo.failed("封面图片不可为空！");
        }
        ResultVo resultVo = bookService.putBook(Integer.parseInt(id), name, isbn, bkCaseId, price, author, type, synopsis, press, image);
        return resultVo;
    }
}
