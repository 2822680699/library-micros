package com.wonders.library.platform.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wonders.library.common.utils.MD5Utils;
import com.wonders.library.common.utils.ResultVo;
import com.wonders.library.platform.dao.AdminDao;
import com.wonders.library.platform.dao.BookDao;
import com.wonders.library.platform.entity.AdminEntity;
import com.wonders.library.platform.entity.BookEntity;
import com.wonders.library.platform.service.AdminService;
import com.wonders.library.platform.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BookSericeImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public ResultVo getBookList(int page, int rows) {
        List<BookEntity> bookEntityList = new ArrayList<BookEntity>();
        JSONObject jsonObject = new JSONObject();
        try {
            page = (page - 1) * rows;
            int num = bookDao.count();
            bookEntityList = bookDao.getBookList(page, rows);
            log.info("获取书籍列表信息" + JSONObject.toJSON(bookEntityList));
            jsonObject.put("count", num);
            jsonObject.put("list", bookEntityList);
            return ResultVo.success(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failed("网络开小差哦！");
        }
    }

    @Override
    public ResultVo addBook(String name, String isbn, String bkCaseId, String price, String author,
                            String type, String synopsis, String press, String image) {
        try {
            int num = bookDao.addBook(name, isbn, bkCaseId, price, author, type, synopsis, press, image, new Date());
            if (num > 0) {
                return ResultVo.success("新增书籍信息成功");
            } else {
                return ResultVo.failed("新增书籍信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failed("网络开小差哦");
        }
    }

    @Override
    public ResultVo getById(int id) {
        try {
            BookEntity bookEntity = bookDao.getById(id);
            return ResultVo.success(bookEntity, "书籍信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failed("网络开小差哦");
        }
    }

    @Override
    public ResultVo putBook(int id, String name, String isbn, String bkCaseId, String price, String author,
                            String type, String synopsis, String press, String image) {
        try {
            int num = bookDao.putBook(id, name, isbn, bkCaseId, price, author, type, synopsis, press, image, new Date());
            if (num > 0) {
                return ResultVo.success("修改书籍信息成功");
            } else {
                return ResultVo.failed("修改书籍信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failed("网络开小差哦");
        }
    }

    @Override
    public ResultVo delBook(int id) {
        try {
            int num = bookDao.delBook(id);
            if (num > 0) {
                return ResultVo.success("删除书籍信息成功");
            } else {
                return ResultVo.failed("删除书籍信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failed("网络开小差哦");
        }
    }
}
