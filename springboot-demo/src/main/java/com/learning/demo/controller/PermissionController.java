package com.learning.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learning.demo.response.ResponseSummary;
import com.learning.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.learning.demo.entity.Permission;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Controller
@RequestMapping(path = "permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @GetMapping("")
    public String list() {
        return "permission/list";
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseSummary list(ModelMap map,
                                @RequestParam(value = "pageNumber", required = false, defaultValue = "1") @Min(1) Integer pageNumber,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") @Max(100) @Min(1) Integer pageSize) {
        IPage<Permission> permissionPage = new Page<>();
        permissionPage.setCurrent(pageNumber);
        permissionPage.setSize(pageSize);

        this.permissionService.page(permissionPage);
        System.out.println("page cot:" + permissionPage.getPages());
        return ResponseSummary.SUCCESS(permissionPage);
    }

//    @RequestMapping(path = "", method = RequestMethod.GET)
//    @Transactional
//    public CommonResponse getList(
//            @RequestParam(value = "field", required = false) String field//要搜索的字段
//            , @RequestParam(value = "type", defaultValue = "none") String type//搜索类型，支持in,notIn,like,notLike,equals,notEquals....
//
//            , @RequestParam(value = "sort", required = false) String sort//排序字段
//            , @RequestParam(value = "order", required = false) String order//排序方式
//
//            , @RequestParam(value = "limit", required = false, defaultValue = "1") @Min(1) Integer limit//limit
//            , @RequestParam(value = "offset", required = false, defaultValue = "100") @Max(1000) @Min(1) Integer offset//offset
//        ) {
//
//        PermissionExample example = new PermissionExample();
//
//        //排序
//        if (sort != null && order != null)
//            switch (order.toLowerCase()) {
//                case "asc":
//                    example.setOrderByClause(Permission.Column.valueOf(sort).asc());
//                    break;
//                case "desc":
//                    example.setOrderByClause(Permission.Column.valueOf(sort).desc());
//                    break;
//                default:
//                    throw new RuntimeException("unsupported sorting method(only support asc or desc)");
//            }
//
//        //设置基于Limit/Offset分页插件的分页信息,如数据库不支持或使用了PageHelper，请自行更改实现方式
//        example.setLimit(limit);
//        example.setOffset(offset);
//
//        return new CommonResponse<>(permissionService.selectByExample(example)).total(permissionService.countByExample(example));
//    }


    /**
     * 插入单条数据
     * @param record the record you want to create
     * @return created records(with primary key if your mapper supports it)
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    @Transactional
    public boolean insertOne(@RequestBody Permission record) {
        return permissionService.save(record);
    }


    /**
     * 批量插入
     * @param records the records you want to create
     * @return created records(with primary key if your mapper supports it)
     */
    @RequestMapping(path = "batch", method = RequestMethod.POST)
    @Transactional
    public boolean insertBatch(@RequestBody List<Permission> records) {
        return permissionService.saveBatch(records);
    }

    /**
     * 更新单条数据
     * @param record the records you want to update
     * @return affected row count
     */
    @RequestMapping(path = "", method = RequestMethod.PUT)
    @Transactional
    public boolean updateOne(@RequestBody Permission record) {
        return permissionService.updateById(record);

    }

    /**
     * 批量更新数据
     * @param records the records you want to update
     * @return affected row count
     */
    // TODO: 2018/3/25 update batch
    @RequestMapping(path = "batch", method = RequestMethod.PUT)
    @Transactional
    public boolean updateBatch(@RequestBody List<Permission> records) {
        return permissionService.updateBatchById(records);
    }

    /**
     * delete a record by id
     *
     * @param id the id of the record you want to delete
     * @return affected row count
     */
    // TODO: 2018/3/25 delete one
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @Transactional
    public boolean deleteOne(@PathVariable("id") Integer id) {
        return permissionService.removeById(id);
    }

    /**
     * batch delete
     *
     * @param ids the ids of the records you want to delete
     * @return affected row count
     */
    @RequestMapping(path = "", method = RequestMethod.DELETE)
    @Transactional
    public boolean deleteBatch(@RequestParam("id") List<Integer> ids) {
        return permissionService.removeByIds(ids);
    }

}