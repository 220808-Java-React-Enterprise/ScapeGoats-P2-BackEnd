package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewConsultantRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Consultants;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.ConsultantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConsultantServiceTest {

    ConsultantService mockConsultantService;
    private ConsultantRepository mockConsultantRepository;
    private Consultants mockConsultant;
    private NewConsultantRequest mockRequest;

    @BeforeEach
    void setUp() {
        mockConsultantRepository = mock(ConsultantRepository.class);
        mockConsultantService = new ConsultantService(mockConsultantRepository);
        mockConsultant = mock(Consultants.class);
        mockRequest = mock(NewConsultantRequest.class);
    }

    @Test
    void getAll() {

        when(this.mockConsultantRepository.findAll()).thenReturn(Arrays.asList(new Consultants("123", "firstname", "lastname")));
        this.mockConsultantRepository.findAll();
        List<Consultants> consultants = this.mockConsultantService.getAll();
        int expectedSize = 1;
        int actualListSize = consultants.size();

        assertEquals(expectedSize, actualListSize);
    }
    @Test
    void addConsultant() {

        NewConsultantRequest request = new NewConsultantRequest();
        request.setId("123");
        request.setFirstname("firstname");
        request.setLastname("lastname");

        Consultants cons = new Consultants("123", "firstname", "lastname");

        when(this.mockConsultantRepository.save(cons)).thenReturn(cons);
        when(this.mockConsultantService.addConsultant(request)).thenReturn(" has been added");
        this.mockConsultantRepository.save(cons);
        String actualStringContent = this.mockConsultantService.addConsultant(request);
        String expectedStringContent = cons.getFirstname() + " has been added";

        assertEquals(expectedStringContent, actualStringContent);
    }

    @Test
    void delete() {
        mockConsultantService.delete(mockConsultant);
        verify(mockConsultantRepository, times(1)).delete(any());
    }
}