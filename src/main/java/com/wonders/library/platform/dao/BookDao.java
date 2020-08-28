package com.wonders.library.platform.dao;

import com.wonders.library.common.utils.ResultVo;
import com.wonders.library.platform.entity.AdminEntity;
import com.wonders.library.platform.entity.BookEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 书籍DAO
 */
@Mapper
public interface BookDao {


    /**
     * 获取书籍列表信息
     *
     * @param page 页数
     * @param rows     条数
     * @return
     */
    List<BookEntity> getBookList(@Param("page") int page, @Param("rows") int rows);

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
     * @param createTime 新增时间
     * @return
     */
    int addBook(@Param("name") String name, @Param("isbn") String isbn, @Param("bkCaseId") String bkCaseId,
                @Param("price") String price, @Param("author") String author, @Param("type") String type,
                @Param("synopsis") String synopsis, @Param("press") String press, @Param("image") String image,
                @Param("createTime") Date createTime);

    /**
     * 查询书籍详情
     *
     * @param id 编号
     * @return
     */
    BookEntity getById(@Param("id") int id);

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
     * @param updateTime 修改时间
     * @return
     */
    int putBook(@Param("id") int id, @Param("name") String name, @Param("isbn") String isbn, @Param("bkCaseId") String bkCaseId,
                @Param("price") String price, @Param("author") String author, @Param("type") String type,
                @Param("synopsis") String synopsis, @Param("press") String press, @Param("image") String image,
                @Param("updateTime") Date updateTime);

    /**
     * 删除书籍信息
     *
     * @param id 编号
     * @return
     */
    int delBook(@Param("id") int id);

    /**
     * 获取总条数
     * @return
     */
    int count();

}
