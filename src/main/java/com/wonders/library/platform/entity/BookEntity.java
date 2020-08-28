package com.wonders.library.platform.entity;

import lombok.Data;

import java.util.Date;

/**
 * 书籍信息
 */
@Data
public class BookEntity {

      private int id;//编号
    private String name;//书籍名称
    private String isbn;//书籍编码
    private String bkCaseId;//书架编号
    private Double price;//定价
    private String author;//作者
    private String type;//书籍类型
    private String synopsis;//书籍简介
    private String press;//出版社
    private int status;//0--借出，1--没有借出
    private String image;//封面图片
    private int isDelete;//0：未删除  1、已删除
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
}
