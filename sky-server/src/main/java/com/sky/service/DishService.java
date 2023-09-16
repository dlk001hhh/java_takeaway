package com.sky.service;

import com.sky.dto.DishDTO;

public interface DishService {
    void addDish(DishDTO dishDTO);

    void updateStatus(Long id, int status);
}
