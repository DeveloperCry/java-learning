package com.learning.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learning.demo.constants.Constant;
import com.learning.demo.convertor.role.RoleDtoConverter;
import com.learning.demo.dto.role.RoleDto;
import com.learning.demo.entity.Account;
import com.learning.demo.response.ResponseSummary;
import com.learning.demo.service.RoleService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.learning.demo.entity.Role;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Controller
@RequestMapping(path = "role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("")
    public String list() {
        return "role/list";
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseSummary list(ModelMap map,
                                @RequestParam(value = "pageNumber", required = false, defaultValue = "1") @Min(1) Integer pageNumber,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "10") @Max(100) @Min(1) Integer pageSize) {
        IPage<Role> rolePage = new Page<>();
        rolePage.setCurrent(pageNumber);
        rolePage.setSize(pageSize);

        IPage<Role> roleIPage = this.roleService.page(rolePage);
        System.out.println("page cot:" + rolePage.getPages());
//        map.addAttribute("rolePage", rolePage);
        return ResponseSummary.SUCCESS(rolePage);
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
//        RoleExample example = new RoleExample();
//
//        //排序
//        if (sort != null && order != null)
//            switch (order.toLowerCase()) {
//                case "asc":
//                    example.setOrderByClause(Role.Column.valueOf(sort).asc());
//                    break;
//                case "desc":
//                    example.setOrderByClause(Role.Column.valueOf(sort).desc());
//                    break;
//                default:
//                    throw new RuntimeException("unsupported sorting method(only support asc or desc)");
//            }
//
//        //设置基于Limit/Offset分页插件的分页信息,如数据库不支持或使用了PageHelper，请自行更改实现方式
//        example.setLimit(limit);
//        example.setOffset(offset);
//
//        return new CommonResponse<>(mapper.selectByExample(example)).total(mapper.countByExample(example));
//    }


    /**
     * 插入单条数据
     * @param roleDto the record you want to create
     * @return created records(with primary key if your mapper supports it)
     */
    @PostMapping(path = "/add")
    @ResponseBody
    public ResponseSummary addRole(@RequestBody RoleDto roleDto, HttpServletRequest request) {
        if (roleDto == null) {
            return ResponseSummary.FAIL();
        }

        Account account = (Account) request.getSession().getAttribute(Constant.ACCOUNT_SESSION);
        if (roleService.save(roleDto, account.getId())) {
            return ResponseSummary.SUCCESS();
        }
        return ResponseSummary.FAIL();
    }

    /**
     * 插入单条数据
     * @param roleDto the record you want to create
     * @return created records(with primary key if your mapper supports it)
     */
    @PostMapping(path = "/update/{id}")
    @ResponseBody
    public ResponseSummary updateRole(@PathVariable("id") Long id, @RequestBody RoleDto roleDto, HttpServletRequest request) {
        if (roleDto == null) {
            return ResponseSummary.FAIL();
        }

        Account account = (Account) request.getSession().getAttribute(Constant.ACCOUNT_SESSION);
        if (roleService.update(roleDto, id, account.getId())) {
            return ResponseSummary.SUCCESS();
        }
        return ResponseSummary.FAIL();
    }


    /**
     * 批量插入
     * @param records the records you want to create
     * @return created records(with primary key if your mapper supports it)
     */
    @RequestMapping(path = "batch", method = RequestMethod.POST)
    @ResponseBody
    public boolean insertBatch(@RequestBody List<Role> records) {
        return roleService.saveBatch(records);
    }

    /**
     * 更新单条数据
     * @param record the records you want to update
     * @return affected row count
     */
    @RequestMapping(path = "", method = RequestMethod.PUT)
    @ResponseBody
    public boolean updateOne(@RequestBody Role record) {
        return roleService.updateById(record);

    }

    /**
     * 批量更新数据
     * @param records the records you want to update
     * @return affected row count
     */
    // TODO: 2018/3/25 update batch
    @RequestMapping(path = "batch", method = RequestMethod.PUT)
    @ResponseBody
    public boolean updateBatch(@RequestBody List<Role> records) {
        return roleService.updateBatchById(records);
    }

    /**
     * delete a record by id
     *
     * @param id the id of the record you want to delete
     * @return affected row count
     */
    // TODO: 2018/3/25 delete one
    @PostMapping(path = "/delete/{id}")
    @ResponseBody
    public ResponseSummary deleteRole(@PathVariable("id") Long id) {
        if (roleService.removeById(id)) {
            return ResponseSummary.SUCCESS();
        }
        return ResponseSummary.FAIL();
    }

    /**
     * batch delete
     *
     * @param ids the ids of the records you want to delete
     * @return affected row count
     */
    @RequestMapping(path = "", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteBatch(@RequestParam("id") List<Integer> ids) {
        return roleService.removeByIds(ids);
    }

}