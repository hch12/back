package com.example.back.controller;

import com.example.back.common.Result;
import com.example.back.entity.Record;
import com.example.back.entity.Relative;
import com.example.back.service.RelativeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rela")
public class relaController {

    @Resource
    private RelativeService relativeService;


    @GetMapping("/list")
    public Result list(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam Integer userId,@RequestParam Integer nameId) {
        List<Relative> relatives = relativeService.getRelativesByUser(userId);
        int begin = (pageNum-1)*pageSize;
        int end = begin + pageSize;
        if(end > relatives.size())
            end = relatives.size();
        List<Relative> showList = new ArrayList<>(relatives.subList(begin, end));
        com.example.back.entity.Record records = new Record(showList, relatives.size());
        return Result.success(records);
    }

    @PostMapping("/addExisting")
    public Result addExisting(@RequestBody Relative relative) {
        relativeService.addRelative(relative.getRegulator(),relative.getRegulated(),relative.getRelationship());
        return Result.success();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Relative relative) {
        relativeService.updateRelative(relative);
        return Result.success();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Relative relative) {
        System.out.println("Regulator: " + relative.getRegulator());
        System.out.println("Regulated: " + relative.getRegulated());
        relativeService.deleteRelative(relative);
        return Result.success();
    }

    @PostMapping("/create")
    public Result create(@RequestBody Relative relative){
        relativeService.create(relative);
        return Result.success();
    }

    @GetMapping("/search")
    public Result search(@RequestParam String username) {
        try {
            List<Relative> userRelations = relativeService.search(username);
            if (userRelations == null) {
                return Result.error("USER_NOT_FOUND", "未找到相关用户"); // 假设 Result 类支持自定义错误码和消息
            }
            return Result.success(userRelations); // 直接返回列表
        } catch (Exception e) {
            return Result.error("INTERNAL_SERVER_ERROR", "服务器内部错误"); // 返回更具体的错误信息
        }
    }

//    @PostMapping("/toggle-auth")
//    public Result toggleAuth(@RequestParam Integer regulator,
//                             @RequestParam Integer regulated,
//                             @RequestParam Boolean status) {
//        relativeService.toggleAuthorization(regulator, regulated, status);
//        return Result.success();
//    }
}
