package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewCategoryRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.CategoryRepository;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    CategoryService testService;

    private CategoryRepository categoryRepositoryMock;
    private Categories mockCategory;
    private NewCategoryRequest mockCategoryRequest;



    @BeforeEach
    void setUp() {
        categoryRepositoryMock = mock(CategoryRepository.class);
        testService = new CategoryService(categoryRepositoryMock);
        mockCategory = mock(Categories.class);
        mockCategoryRequest = mock(NewCategoryRequest.class);
        when(mockCategoryRequest.getCategory()).thenReturn("Category");
        when(mockCategoryRequest.getCategory_id()).thenReturn("Category_id");
    }

    @AfterEach
    public void setdown(){
        categoryRepositoryMock = null;
        testService = null;
        mockCategory = null;
        mockCategoryRequest = null;
    }

    @Test
    void getAllCategories() {
        when(categoryRepositoryMock.findAll()).thenReturn(Arrays.asList(mockCategory));
        List<Categories> categories = testService.getAll();
        verify(categoryRepositoryMock, times(1)).findAll();
        assertNotNull(categories);

    }

    @Test
    void getAll() {
    }

    @Test
    void addCategory() {
    }

    @Test
    void findById() {
    }

    @Test
    void findCategoryByCategory() {
    }

    @Test
    void delete() {
    }
}