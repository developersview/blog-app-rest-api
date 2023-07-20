package com.developersview.springbootblogapprestapi.controller;

import com.developersview.springbootblogapprestapi.entity.Category;
import com.developersview.springbootblogapprestapi.payload.CategoryDto;
import com.developersview.springbootblogapprestapi.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 16/07/2023
 */
@RestController
@RequestMapping("api/v1/categories")
@Tag(
        name = "CRUD REST API for Category Resource"
)
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //create a category
    @Operation(
            summary = "Create Category Rest Endpoint",
            description = "This endpoint is used to save a category into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status - 201 CREATED"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto savedCategory = categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    //get a category by id
    @Operation(
            summary = "Get a Category Rest Endpoint",
            description = "This endpoint is used to get a category from database by category ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long categoryId) {
        CategoryDto categoryDto = categoryService.getCategory(categoryId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    //get all categories
    @Operation(
            summary = "Get All Categories Rest Endpoint",
            description = "This endpoint is used to get all categories from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories() {
        return ResponseEntity.ok(categoryService.getALlCategories());
    }

    //update a category
    @Operation(
            summary = "Update Category Rest Endpoint",
            description = "This endpoint is used to update a category into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,
                                                      @PathVariable("id") Long categotyId) {
        CategoryDto updatedCategory = categoryService.updateCategory(categoryDto, categotyId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    //delete a category
    @Operation(
            summary = "Delete Category Rest Endpoint",
            description = "This endpoint is used to delete a category from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>("Category deleted successfully", HttpStatus.OK);
    }
}
