package com.developersview.springbootblogapprestapi.repository;

import com.developersview.springbootblogapprestapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pranoy.chakraborty
 * @Date 15/07/2023
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
