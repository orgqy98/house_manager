package com.aaa.house.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * fileName:HouseService
 * description:
 * author:zz
 * createTime:2019/7/22 15:36
 * versoin:1.0.0
 */
public interface HouseService {

    /**
     * 查询列表
     * @return
     */
     List<Map> getList();


    /**
     * 根据id获取对象
     * @param id
     * @return
     */
    Map getById(int id);
}
