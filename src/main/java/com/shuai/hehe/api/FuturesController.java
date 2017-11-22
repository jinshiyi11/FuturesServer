package com.shuai.hehe.api;

import com.shuai.hehe.api.entity.Futures;
import com.shuai.hehe.api.mapper.FuturesMapper;
import com.shuai.hehe.api.response.ErrorCode;
import com.shuai.hehe.api.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 期货信息的增删改查
 */
@RestController
@Validated
//@CrossOrigin(origins = "*")
public class FuturesController {
    @Autowired
    private FuturesMapper mMapper;

    @GetMapping("/api/getFuturesList")
    @ResponseBody
    public ResponseInfo<List<Futures>> getFuturesList() {
        List<Futures> data = mMapper.getFuturesList();
        ResponseInfo<List<Futures>> result = new ResponseInfo<>();
        result.setData(data);
        return result;
    }

    /**
     * 模糊查找
     *
     * @param key 关键字
     * @return 找到的期货信息列表
     */
    @RequestMapping("/api/searchFutures")
    @ResponseBody
    public ResponseInfo<List<Futures>> searchFutures(@NotNull @Size(min = 1,message = "关键字不能为空") String key) {
        List<Futures> data = mMapper.searchFutures(key);
        ResponseInfo<List<Futures>> result = new ResponseInfo<>();
        result.setData(data);
        return result;
    }

    @GetMapping("/api/getFutures")
    @ResponseBody
    public ResponseInfo<Futures> getFutures(int id) {
        Futures futures = mMapper.getFutures(id);
        ResponseInfo<Futures> result = new ResponseInfo<>();
        result.setData(futures);
        return result;
    }

    @PostMapping("/api/addFutures")
    @ResponseBody
    public ResponseInfo addFutures(@RequestParam("name") String name,
                                   @RequestParam("title") String title) {
        Futures futures = new Futures();
        futures.setName(name);
        futures.setTitle(title);
        mMapper.addFutures(futures);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }

    @PostMapping("/api/updateFutures")
    @ResponseBody
    public ResponseInfo updateFutures(Futures futures) {
        mMapper.updateFutures(futures);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }

    @PostMapping("/api/deleteFutures")
    @ResponseBody
    public ResponseInfo deleteFutures(int id) {
        mMapper.deleteFutures(id);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }
}
