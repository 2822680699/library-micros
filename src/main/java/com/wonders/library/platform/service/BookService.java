package com.wonders.library.platform.service;

import com.wonders.library.common.utils.ResultVo;

/**
 * 书籍service
 */
public interface BookService {

    /**
     * 获取书籍列表信息
     *
     * @param page 页数
     * @param rows     条数
     * @param name 书籍名称
     * @return
     */
    ResultVo getBookList(int page, int rows,String name);

    /**
     * 新增书籍信息
     *
     * @param name     书籍名称
     * @param isbn     书籍编码
     * @param bkCaseId 书架编号
     * @param price    定价
     * @param author   作者
     * @param type     书籍类型
     * @param synopsis 书籍简介
     * @param press    出版社
     * @param image    封面图片
     * @return
     */
    ResultVo addBook(String name, String isbn, String bkCaseId, String price, String author,
                     String type, String synopsis, String press, String image);

    /**
     * 查询书籍详情
     *
     * @param id 编号
     * @return
     */
    ResultVo getById(int id);

    /**
     * 修改书籍信息
     *
     * @param id       编号
     * @param name     书籍名称
     * @param isbn     书籍编码
     * @param bkCaseId 书架编号
     * @param price    定价
     * @param author   作者
     * @param type     书籍类型
     * @param synopsis 书籍简介
     * @param press    出版社
     * @param image    封面图片
     * @return
     */
    ResultVo putBook(int id, String name, String isbn, String bkCaseId, String price, String author,
                     String type, String synopsis, String press, String image);

    /**
     * 删除书籍信息
     *
     * @param id 编号
     * @return
     */
    ResultVo delBook(int id);
}
