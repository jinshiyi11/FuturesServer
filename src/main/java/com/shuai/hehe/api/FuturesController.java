package com.shuai.hehe.api;

import com.shuai.hehe.api.entity.Futures;
import com.shuai.hehe.api.repository.FuturesRepository;
import com.shuai.hehe.api.response.ErrorCode;
import com.shuai.hehe.api.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 期货信息的增删改查
 */
@RestController
public class FuturesController {
    @Autowired
    private FuturesRepository mRepository;

    @GetMapping("/api/futuresList")
    @ResponseBody
    public ResponseInfo<List<Futures>> getFuturesList() {
        List<Futures> data = mRepository.findAll();
        ResponseInfo<List<Futures>> result = new ResponseInfo<>(ErrorCode.ERROR_SUCCESS);
        result.setData(data);
        return result;
    }

    @PostMapping("/api/addFutures")
    @ResponseBody
    public ResponseInfo addFutures(@Valid @RequestParam("name") String name,
                                   @RequestParam("title") String title) {
        Futures futures = new Futures();
        futures.setName(name);
        futures.setTitle(title);
        mRepository.save(futures);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }
}
