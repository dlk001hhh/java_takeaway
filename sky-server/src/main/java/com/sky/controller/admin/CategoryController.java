package com.sky.controller.admin;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类相关接口")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ApiOperation("新增分类")
    public Result addCategory(CategoryDTO categoryDTO){
        log.info("新增分类：{}", categoryDTO);
        categoryService.addCategory(categoryDTO);
        return Result.success();
    }

    @PostMapping("/status/{status}")
    @ApiOperation("启用或禁用分类")
    public Result updateStatus(@PathVariable Integer status, Long id){
        log.info("启用或禁用分类：{}, {}", id, status);
        categoryService.updateStatus(id, status);
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation("根据id删除分类")
    public Result deleteCategory(Long id){
        log.info("删除分类：{}", id);
        categoryService.deleteCategory(id);
        return Result.success();
    }

    @PutMapping
    @ApiOperation("修改分类")
    public Result UpdateCategory(@RequestBody CategoryDTO categoryDTO){
        log.info("修改分类：{}", categoryDTO);
        categoryService.updateCategory(categoryDTO);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("根据类型获取分类")
    public Result<List<Category>> getByType(Integer type){
        log.info("获取类型对应的分类：{}", type);
        List<Category> categoryList = categoryService.getByType(type);
        return Result.success(categoryList);
    }

    @GetMapping("/page")
    @ApiOperation("分页获取分类")
    public Result<PageResult> getByPage(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("获取分页分类：{}", categoryPageQueryDTO);
        PageResult pageResult = categoryService.getByPage(categoryPageQueryDTO);
        return Result.success(pageResult);
    }
}
