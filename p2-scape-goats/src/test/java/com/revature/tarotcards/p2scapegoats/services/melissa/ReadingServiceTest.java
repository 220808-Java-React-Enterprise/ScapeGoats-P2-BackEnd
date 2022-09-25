package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewReadingRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.ReadingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ReadingServiceTest {

    private ReadingRepository readingRepositoryMock;
    private Readings mockReading;
    private NewReadingRequest mockRequest;
    private ReadingService testService;

    @BeforeEach
    void setUp() {
        readingRepositoryMock = mock(ReadingRepository.class);
        mockReading = mock(Readings.class);
        testService = new ReadingService(readingRepositoryMock);
        mockRequest = mock(NewReadingRequest.class);
        when(mockRequest.getDescription()).thenReturn("Description");
        when(mockRequest.getCard1()).thenReturn("card1");
        when(mockRequest.getCard2()).thenReturn("card2");
        when(mockRequest.getCard3()).thenReturn("card3");
        //when(mockRequest.getDate()).thenReturn();
        when(mockRequest.getUser_id()).thenReturn("user_id");
        when(mockRequest.getCategory_id()).thenReturn("category_id");
        when(mockRequest.getId()).thenReturn("id");
    }

    @AfterEach
    public void setdown(){
        readingRepositoryMock = null;
        mockReading = null;
        testService = null;
        mockRequest = null;

    }

    @Test
    void getAll() {
        when(readingRepositoryMock.findAll()).thenReturn(Arrays.asList(mockReading));
        List<Readings> readings = testService.getAll();
        verify(readingRepositoryMock, times(1)).findAll();
        assertNotNull(readings);
    }

    @Test
    void getAllByUserId() {
        when(readingRepositoryMock.getAllByUserId("userid")).thenReturn(Arrays.asList(mockReading));
        List<Readings> readings = testService.getAllByUserId("userid");
        verify(readingRepositoryMock, times(1)).getAllByUserId("userid");
        assertNotNull(readings);
    }

    @Test
    void addReading() {
        String readings = testService.addReading(mockRequest);
        assertNotNull(readings);
    }

    @Test
    void delete() {
        testService.delete(mockReading);
        verify(readingRepositoryMock, times(1)).delete(any());
    }
}