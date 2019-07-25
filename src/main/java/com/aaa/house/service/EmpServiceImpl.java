package com.aaa.house.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * fileName:EmpService
 * description:
 * author:zz
 * createTime:2019/7/23 14:14
 * versoin:1.0.0
 */
@Service
public class EmpServiceImpl  implements  EmpService{

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getEmpListError")
    @Override
    public List<Map> getEmpList() {
        return (List<Map>)restTemplate.getForObject("http://personmgr/empList",List.class);
    }

    /**
     * 断路器发现远程接口有问题时调用
     * @return
     */
    private  List<Map>  getEmpListError(){
        Map map = new HashMap();
        map.put("error","远程列表调用失败");
        List<Map> mapList = new ArrayList<>();
        mapList.add(map);
        return mapList;
    }
}
