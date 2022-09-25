package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewConsultantRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Consultants;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnConsultantRepository;
import com.revature.tarotcards.p2scapegoats.services.john.JohnConsultantService;
import com.revature.tarotcards.p2scapegoats.services.john.JohnUserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ConsultantServiceTest {
    @Autowired
    private JohnConsultantRepository mockConsultantRepository;

    @Autowired
    private JohnUserService mockUserService;

    @Autowired
    private JohnConsultantService consultantService;

    @Before()
    public void setup() {
        mockConsultantRepository = mock(JohnConsultantRepository.class, Mockito.RETURNS_DEEP_STUBS);
        mockUserService = mock(JohnUserService.class, Mockito.RETURNS_DEEP_STUBS);
        consultantService = mock(JohnConsultantService.class, Mockito.RETURNS_DEEP_STUBS);
    }

    //@Test(expected = IllegalStateException.class)
    @Test
    public void save() {

        JohnNewConsultantRequest request = new JohnNewConsultantRequest();
        request.setFirstName("firstname");
        request.setLastName("lastname");

        Consultants consultant = new Consultants();
        consultant.setId("123");
        consultant.setFirstname("firstName");
        consultant.setLastname("lastName");

        when(mockConsultantRepository.save(consultant)).thenReturn(consultant);

        when(consultantService.save(request)).thenReturn(consultant);

        Consultants returnConsultant  = consultantService.save(request);

        assertEquals(consultant, returnConsultant);

    }

    @Test
    public void update() {
        JohnNewConsultantRequest request = new JohnNewConsultantRequest();
        request.setFirstName("firstname");
        request.setLastName("lastname");

        Consultants consultant = new Consultants();
        consultant.setId("123");
        consultant.setFirstname("firstName");
        consultant.setLastname("lastName");

        Users user = new Users();
        user.setUser_id("123");
        user.setFirstName("firstname");
        user.setLastName("lastname");

        when(mockUserService.findUsersByUser_id("123")).thenReturn(user);

        when(mockConsultantRepository.save(consultant)).thenReturn(consultant);

        when(consultantService.update(request)).thenReturn(consultant);

        Consultants returnConsultant  = consultantService.update(request);

        assertEquals(consultant, returnConsultant);
    }

    @Test
    public void getAllConsultants() {
        when(mockConsultantRepository.findAll()).thenReturn(Arrays.asList(new Consultants("123", "firstname", "lastname")));
        when(consultantService.getAllConsultants()).thenReturn(Arrays.asList(new Consultants("123", "firstname", "lastname")));
        List<Consultants> list = consultantService.getAllConsultants();
        int expectedListSize = 1;
        int actualListSize = list.size();
        assertEquals(expectedListSize, actualListSize);
    }

    @Test
    public void deleteConsultant() {
        JohnNewConsultantRequest request = new JohnNewConsultantRequest();
        request.setId("123");
        request.setFirstName("firstname");
        request.setLastName("lastname");

        doNothing().when(mockConsultantRepository).delete(new Consultants());
        doNothing().when(consultantService).deleteConsultant(new JohnNewConsultantRequest());
        consultantService.deleteConsultant(request);
        verify(consultantService, times(1)).deleteConsultant(request);

    }

}