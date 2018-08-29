package com.sino.data.controller;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author:TWJ
 * @createTime:15:11
 * @desc :
 */
@Controller
@RequestMapping(value = "")
public class DemoController
{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping(value = "/index")
    public String hello(HttpServletRequest request , HttpServletResponse response){




//        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
//        JdbcTemplate jdbcTemplate =(JdbcTemplate) wac.getBean("jdbcTemplate");

       List<Map<String,Object>> list = (List<Map<String,Object>>) jdbcTemplate.queryForList("select user_name  from sys_user ");

        LogFactory.getLog(getClass()).info(list.size());
        return "index";
    }
}
