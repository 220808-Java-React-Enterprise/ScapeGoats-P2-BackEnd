package com.revature.tarotcards.p2scapegoats.john;

import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewCategoryRequest;
import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewConsultantRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.models.melissa.Consultants;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnCategoryRepository;
import com.revature.tarotcards.p2scapegoats.services.john.JohnCategoryService;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class JohnCategoryTest
{
    @Autowired
    private JohnCategoryService categoryService;

    @Autowired
    private JohnCategoryRepository mockCategoryRepository;

    @Before
    public void setup() {
        mockCategoryRepository = mock(JohnCategoryRepository.class, RETURNS_DEEP_STUBS);
        categoryService = mock(JohnCategoryService.class, RETURNS_DEEP_STUBS);
    }

    @Test
    public void getAllCategories_Size_Test() {

        when(mockCategoryRepository.findAll()).thenReturn(Arrays.asList(new Categories("123", "users")));
        when(categoryService.getAllCategories()).thenReturn(Arrays.asList(new Categories("123", "users")));

        List<Categories> catList = categoryService.getAllCategories();
        int expectedListSize = 1;
        int actualListSize = catList.size();

        assertEquals(expectedListSize, actualListSize);

    }

    @Test
    public void getAllCategoriesTest() {

        when(mockCategoryRepository.findAll()).thenReturn(Arrays.asList(new Categories("123", "users")));
        when(categoryService.getAllCategories()).thenReturn(Arrays.asList(new Categories("123", "users")));

        List<Categories> catList = categoryService.getAllCategories();
        String expectedCategoryName = "users";
        String actualCategoryName = catList.get(0).getCategory();

        assertEquals(expectedCategoryName, actualCategoryName);

    }

    @Test
    public void findByCategoryByIdTest() {
        String categoryId = "123";
        Categories category = new Categories("123", "users");


        when(mockCategoryRepository.findCategoryByCategory_id(categoryId)).thenReturn(category);
        when(categoryService.findById(categoryId)).thenReturn(category);
        Categories catagory = categoryService.findById(categoryId);
        String expectedCategoryName = "users";
        String actualCategoryName = catagory.getCategory();

        assertEquals(expectedCategoryName, actualCategoryName);
    }

    @Test
    public void saveCategoryTest() {
        Categories category = new Categories("123", "users");
        JohnNewCategoryRequest request = new JohnNewCategoryRequest();
        request.setId("123");
        request.setCategory("users");

        when(mockCategoryRepository.save(category)).thenReturn(category);
        when(categoryService.save(request)).thenReturn(category);

        Categories returnCategory = categoryService.save(request);
        System.out.println(returnCategory);

        String expectedCategoryName = "users";
        String actualCategoryName = returnCategory.getCategory();
        assertEquals(expectedCategoryName, actualCategoryName);

    }

    @Test
    public void findCategoryByCategoryNameTest() {

        String categoryName = "users";
        when(mockCategoryRepository.findCategoryByCategory(categoryName)).thenReturn(new Categories("123", "users"));
        when(categoryService.findCategoryByCategory(categoryName)).thenReturn(new Categories("123", "users"));
        Categories returnCategory = categoryService.findCategoryByCategory(categoryName);

        String expectedCategoryName = "users";
        String actualCategoryName = returnCategory.getCategory();

        assertEquals(expectedCategoryName, actualCategoryName);

    }

    @Test
    public void findCategoryByCategoryName() {

        String categoryName = "users";

        when(mockCategoryRepository.findCategoryByCategory(categoryName)).thenReturn(new Categories("123", "users"));
        when(categoryService.findCategoryByCategory(categoryName)).thenReturn(new Categories("123", "users"));

        Categories returnCategory = categoryService.findCategoryByCategory(categoryName);

        String expectedCategoryId = "123";
        String actualCategoryId = returnCategory.getCategory_id();

        assertEquals(expectedCategoryId, actualCategoryId);

    }

    @Test
    public void updateCategoryTest() {

        JohnNewCategoryRequest request = new JohnNewCategoryRequest();
        request.setId("123");
        request.setCategory("users");

        Categories tempCategory = new Categories("123", "users");

        when(mockCategoryRepository.save(new Categories("123", "users"))).thenReturn(tempCategory);
        when(categoryService.update(request)).thenReturn(tempCategory);

        Categories returnCategory = categoryService.update(request);

        String expectedCategoryId = "123";
        //String actualCategoryId = returnCategory.getCategory_id();

        //assertEquals(expectedCategoryId, actualCategoryId);

    }

    @Test
    public void deleteCategoryTest() {
        JohnNewCategoryRequest request = new JohnNewCategoryRequest();
        request.setId("123");
        request.setCategory("users");


        doNothing().when(mockCategoryRepository).delete(new Categories());
        doNothing().when(categoryService).deleteCategory(new JohnNewCategoryRequest());
        categoryService.deleteCategory(request);
        verify(categoryService, times(1)).deleteCategory(request);


    }

}
