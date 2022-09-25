package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.controllers.john.JohnCategoryController;
import com.revature.tarotcards.p2scapegoats.controllers.melissa.UsersController;
import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewCategoryRequest;
import com.revature.tarotcards.p2scapegoats.dtos.john.response.JohnPrincipal;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewUserRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnCategoryRepository;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.RoleRepository;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.UserRepository;
import com.revature.tarotcards.p2scapegoats.services.john.JohnCategoryService;
import com.revature.tarotcards.p2scapegoats.services.melissa.RoleService;
import com.revature.tarotcards.p2scapegoats.services.melissa.TokenService;
import com.revature.tarotcards.p2scapegoats.services.melissa.UserService;
import org.apache.catalina.User;
import org.checkerframework.checker.units.qual.C;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JohnCategoryControllerTest {
    @Autowired
    private JohnCategoryService mockCategoryService;

    @Autowired
    private TokenService mockTokenService;

    @Autowired
    private RoleService mockRoleService;

    @Autowired
    private JohnCategoryRepository mockCategoryRepository;

    @Autowired
    private JohnCategoryController categoryController;

    @Before
    public void setup() {
        mockCategoryService = mock(JohnCategoryService.class, Mockito.RETURNS_DEEP_STUBS);
        mockCategoryRepository = mock(JohnCategoryRepository.class, Mockito.RETURNS_DEEP_STUBS);
        mockCategoryService = new JohnCategoryService(mockCategoryRepository);
        mockTokenService = mock(TokenService.class, Mockito.RETURNS_DEEP_STUBS);
        mockRoleService = mock(RoleService.class, Mockito.RETURNS_DEEP_STUBS);
        categoryController = new JohnCategoryController(mockCategoryService, mockTokenService, mockRoleService);
    }

    @Test
    public void createCategoryTest() {
        mockCategoryService = new JohnCategoryService(mockCategoryRepository);
        String token = "123";
        JohnPrincipal principal = new JohnPrincipal();
        principal.setRole("USERS");
        principal.setUsername("jnguyen85");
        principal.setId("123");

        Roles role = new Roles("123", "USERS");

        when(mockCategoryRepository.save(new Categories())).thenReturn(new Categories("123", "USERS"));
        when(mockTokenService.extractRequesterDetails(token)).thenReturn(principal);
        when(mockRoleService.findByRole_id(principal.getRole())).thenReturn(role);
        when(mockCategoryService.save(new JohnNewCategoryRequest())).thenReturn(new Categories("123", "USERS"));
        when(categoryController.createCategory(token, new JohnNewCategoryRequest())).thenReturn(new Categories("123", "USERS"));

        Categories returnCategory = categoryController.createCategory(token, new JohnNewCategoryRequest());

        String expectedCategoryId = "123";
        //String actualCategoryId = returnCategory.getCategory_id();

       // assertEquals(expectedCategoryId, actualCategoryId);


    }
}
