package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewRoleRequest;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewUserRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.RoleRepository;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.UserRepository;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class RoleServiceTest {

    private RoleRepository roleRepositoryMock;
    private NewRoleRequest mockRequest;
    private RoleService testService;
    private Roles mockRole;

    @BeforeEach //run before each test
    public void setUp() {
        roleRepositoryMock = mock(RoleRepository.class);
        testService = new RoleService(roleRepositoryMock);
        mockRole = mock(Roles.class);
        mockRequest = mock(NewRoleRequest.class);

        when(mockRequest.getRole_id()).thenReturn("role_id");
        when(mockRequest.getTitle()).thenReturn("Title");

    }

    @AfterEach
    public void setdown(){
        roleRepositoryMock = null;
        testService = null;
        mockRole = null;
        mockRequest = null;
    }

    @Test
    void getAll() {
        when(roleRepositoryMock.findAll()).thenReturn(Arrays.asList(mockRole));  //what's the difference between Arrays.asList and List<>
        List<Roles> roles = testService.getAll();
        verify(roleRepositoryMock, times(1)).findAll();  //make sure this method is being called at least 1
        assertNotNull(roles);
    }

    @Test
    void findByRole_id() {
        when(roleRepositoryMock.findByRole_id("role_id")).thenReturn(mockRole);
        mockRole = testService.findByRole_id("role_id");
        verify(roleRepositoryMock, times(1)).findByRole_id(mockRequest.getRole_id());
        assertNotNull(mockRole);
    }

    @Test
    void addRole() {
        Roles roles = testService.addRole(mockRequest);
        assertNotNull(roles);
        assertEquals(roles.getRole_id(), "role_id");
        assertEquals(roles.getTitle(), "Title");
    }
}