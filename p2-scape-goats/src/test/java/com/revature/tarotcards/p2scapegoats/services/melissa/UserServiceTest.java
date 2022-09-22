package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.repositories.melissa.RoleRepository;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)

class UserServiceTest {

    UserService testService;

      //creating a mock class of UserService
    private final UserRepository userRepositoryMock = mock(UserRepository.class);

    private final RoleRepository roleRepositoryMock = mock(RoleRepository.class);

    @Before //run before each test
    public void setUp() {
        testService = new UserService(userRepositoryMock, roleRepositoryMock);
    }

    // @Test tells the JUnit that the public void method in which it is used can run as a test case
    @Test
    public void test_getAll_succeed() {
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