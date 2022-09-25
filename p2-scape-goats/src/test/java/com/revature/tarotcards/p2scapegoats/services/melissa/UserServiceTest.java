package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.RoleRepository;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.UserRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private UserService userService;
    private UserRepository mockUserRepo = null;
    private RoleRepository mockRoleRepo;

    @Before
    public void setup() {
        mockUserRepo = mock(UserRepository.class);
        mockRoleRepo = mock(RoleRepository.class);
    }


    @Test
    public void finAllUsersTest() {
        userService = new UserService(mockUserRepo, mockRoleRepo);
        when(mockUserRepo.findAll()).thenReturn(Arrays.asList(new Users("john", "nguyen")));
        when(userService.getAll()).thenReturn(Arrays.asList(new Users("john", "nguyen")));
        List<Users> usersList = userService.getAll();
        String expectedUserFirstName = "john";
        String actualFirstName = usersList.get(0).getFirstName();

        assertEquals(expectedUserFirstName, actualFirstName);
    }


}
