package com.sky.service;


import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {
    List<Category> getByType(Integer type);

    PageResult getByPage(CategoryPageQueryDTO categoryPageQueryDTO);

    void addCategory(CategoryDTO categoryDTO);

    void updateStatus(Long id, Integer status);

    void deleteCategory(Long id);

    void updateCategory(CategoryDTO categoryDTO);
}
