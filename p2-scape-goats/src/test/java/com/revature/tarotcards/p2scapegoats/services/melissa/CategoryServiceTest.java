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
    void getAll() {
        when(categoryRepositoryMock.findAll()).thenReturn(Arrays.asList(mockCategory));
        List<Categories> categories = testService.getAll();
        verify(categoryRepositoryMock, times(1)).findAll();
        assertNotNull(categories);

    }

    @Test
    void addCategory() {
        Categories category = testService.addCategory(mockCategoryRequest);
        assertNull(category);
    }

    @Test
    void findById() {
        when(categoryRepositoryMock.findCategoryByCategory_id("Category_id")).thenReturn(mockCategory);
        mockCategory = testService.findById("Category_id");
        verify(categoryRepositoryMock, times(1)).findCategoryByCategory_id(mockCategory.getCategory_id());
        //assertNull(mockCategory);
    }

    @Test
    void findCategoryByCategory() {
    }

    @Test
    void delete() {
        categoryRepositoryMock.delete(mockCategory);
        verify(categoryRepositoryMock, times(1)).delete(any());
    }
}