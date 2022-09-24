package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewUserRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.RoleRepository;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.UserRepository;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)

class UserServiceTest {

    UserService testService;

      //creating a mock class of UserService
    private UserRepository userRepositoryMock;

    private RoleRepository roleRepositoryMock;
    private Users mockUser;
    private NewUserRequest mockRequest;

    @Before //run before each test
    public void setUp() {
        userRepositoryMock = mock(UserRepository.class);
        roleRepositoryMock = mock(RoleRepository.class);
        testService = new UserService(userRepositoryMock, roleRepositoryMock);
        mockUser = mock(Users.class);
        mockRequest = mock(NewUserRequest.class);
    }

    // @Test tells the JUnit that the public void method in which it is used can run as a test case
    @Test
    public void test_getAll_succeed() {
        when(userRepositoryMock.findAll()).thenReturn(Arrays.asList(mockUser));  //what's the difference between Arrays.asList and List<>
        List<Users> users = testService.getAll();
        verify(userRepositoryMock, times(1)).findAll();  //make sure this method is being called at least 1
        assertNotNull(users);
    }

    @Test
    public void test_getAll_fail(){
        when(userRepositoryMock.findAll()).thenReturn(Arrays.asList(mockUser));
        InvalidRequestException thrown = Assertions.assertThrows(InvalidRequestException.class, () -> {
            testService.getAll();
        });
        verify(userRepositoryMock, times(1)).findAll();
        Assertions.assertEquals("no users found", thrown.getMessage());
    }

    @Test
    void addUser() {
    }

    @Test
    void isValidPassword() {
    }

    @Test
    void isDuplicateUsername() {
    }

    @Test
    void isValidUsername() {
    }

    @Test
    void delete() {
    }
}