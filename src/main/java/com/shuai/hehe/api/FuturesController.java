package com.shuai.hehe.api;

import com.shuai.hehe.api.entity.Futures;
import com.shuai.hehe.api.repository.FuturesRepository;
import com.shuai.hehe.api.response.ErrorCode;
import com.shuai.hehe.api.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 期货信息的增删改查
 */
@RestController
@Validated
public class FuturesController {
    @Autowired
    private FuturesRepository mRepository;

    @GetMapping("/api/futuresList")
    @ResponseBody
    public ResponseInfo<List<Futures>> getFuturesList() {
        List<Futures> data = mRepository.findAll();
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
    @PostMapping("/api/searchFutures")
    @ResponseBody
    public ResponseInfo<List<Futures>> searchFutures(@NotNull @Size(min = 1,message = "关键字不能为空") String key) {
        List<Futures> data = mRepository.searchFutures(key);
        ResponseInfo<List<Futures>> result = new ResponseInfo<>();
        result.setData(data);
        return result;
    }

    @GetMapping("/api/getFutures")
    @ResponseBody
    public ResponseInfo<Futures> getFutures(long id) {
        Futures futures = mRepository.findOne(id);
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
        mRepository.save(futures);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }

    @PostMapping("/api/updateFutures")
    @ResponseBody
    public ResponseInfo updateFutures(Futures futures) {
        mRepository.save(futures);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }

    @PostMapping("/api/deleteFutures")
    @ResponseBody
    public ResponseInfo deleteFutures(long id) {
        mRepository.delete(id);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }
}
