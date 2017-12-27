package com.shuai.hehe.api;

import com.shuai.hehe.api.klinemapper.KlineMapper;
import com.shuai.hehe.api.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
public class TestController {
    @Autowired
    private KlineMapper mMapper;

    @GetMapping("api/test")
    @ResponseBody
    ResponseInfo<List<String>> getList(){
        ResponseInfo<List<String>> result=new ResponseInfo<>();
        result.setData(mMapper.getList());
        return result;
    }
}
