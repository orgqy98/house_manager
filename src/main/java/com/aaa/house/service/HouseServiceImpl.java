package com.aaa.house.service;

import com.aaa.house.dao.HouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * fileName:HouseServiceImpl
 * description:
 * author:zz
 * createTime:2019/7/22 15:36
 * versoin:1.0.0
 */
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseDao houseDao;
    @Override
    public List<Map> getList() {
        return houseDao.getList();
    }

    @Override
    public Map getById(int id) {
        List<Map> mapList = houseDao.getById(id);
        if(mapList!=null&&mapList.size()>0){
            return mapList.get(0);
        }
        return null;
    }
}
