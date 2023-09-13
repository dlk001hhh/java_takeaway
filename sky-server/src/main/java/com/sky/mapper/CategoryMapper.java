package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from category where type = #{type}")
    List<Category> getBytype(Integer type);

    Page<Category> getByPage(CategoryPageQueryDTO categoryPageQueryDTO);

    void addCategory(Category category);

    void update(Category build);

    void deleteCategory(Long id);
}
