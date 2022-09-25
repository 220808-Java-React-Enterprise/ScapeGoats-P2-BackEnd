package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewUserRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.RoleRepository;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.UserRepository;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
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

    @BeforeEach //run before each test
    public void setUp() {
        userRepositoryMock = mock(UserRepository.class);
        roleRepositoryMock = mock(RoleRepository.class);
        testService = new UserService(userRepositoryMock, roleRepositoryMock);
        mockUser = mock(Users.class);
        mockRequest = mock(NewUserRequest.class);
        when(mockRequest.getUsername()).thenReturn("username");
        when(mockRequest.getPassword()).thenReturn("Passw0rd$");
        when(mockRequest.getFirstname()).thenReturn("firstname");
        when(mockRequest.getLastname()).thenReturn("lastname");
        when(mockRequest.getEmail()).thenReturn("email@test.com");
        when(mockRequest.getRole_id()).thenReturn("456");

    }
    @AfterEach
    public void setdown(){
        userRepositoryMock = null;
        roleRepositoryMock = null;
        testService = null;
        mockUser = null;
        mockRequest = null;
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
        when(userRepositoryMock.findAll()).thenReturn(new ArrayList<>());
        InvalidRequestException thrown = Assertions.assertThrows(InvalidRequestException.class, () -> {
            testService.getAll();
        });
        verify(userRepositoryMock, times(1)).findAll();
        Assertions.assertEquals("No users found", thrown.getMessage());
    }

    @Test
    void test_addUser_succeed() {
        when(mockRequest.getEmail()).thenReturn(null);
        when(mockRequest.getFirstname()).thenReturn(null);
        when(mockRequest.getLastname()).thenReturn(null);
        when(userRepositoryMock.findAll()).thenReturn(new ArrayList<>()); //there needs to be 0 users?
        when(userRepositoryMock.findUsernameByUsername(any())).thenReturn(null); //verify there aren't any other usernames by this one
        Users user = testService.addUser(mockRequest);
        assertNotNull(user);
        assertEquals(user.getUsername(), "username");
        assertEquals(user.getPassword(), "Passw0rd$");
        assertNull(user.getEmail());
        assertNull(user.getFirstName());
        assertNull(user.getLastName());
    }

    @Test
    void test_addUser_badpassword_fail() {
        when(mockRequest.getPassword()).thenReturn("password");
        InvalidRequestException thrown = Assertions.assertThrows(InvalidRequestException.class, () -> {
            testService.addUser(mockRequest);
        });
        verify(userRepositoryMock, times(0)).save(any());
    }

    @Test
    void test_addUser_badPasswordNoSymbol_fail() {
        when(mockRequest.getPassword()).thenReturn("Password1");
        InvalidRequestException thrown = Assertions.assertThrows(InvalidRequestException.class, () -> {
            testService.addUser(mockRequest);
        });
        verify(userRepositoryMock, times(0)).save(any());
    }

    @Test
    void isValidPassword() {
        when(mockRequest.getPassword()).thenReturn("Passw0rd1@");
        assertTrue(testService.isValidPassword(mockRequest.getPassword()));
    }

    @Test
    void isDuplicateUsername() {
        when(userRepositoryMock.findUsernameByUsername("username")).thenReturn(null);
        assertFalse(testService.isDuplicateUsername("username"));
    }

    @Test
    void isValidUsername() {
        when(mockRequest.getUsername()).thenReturn("username");
        assertTrue(testService.isValidUsername(mockRequest.getUsername()));
    }

    @Test
    void delete() {
        testService.delete(mockUser);
        verify(userRepositoryMock, times(1)).delete(any());
    }
}