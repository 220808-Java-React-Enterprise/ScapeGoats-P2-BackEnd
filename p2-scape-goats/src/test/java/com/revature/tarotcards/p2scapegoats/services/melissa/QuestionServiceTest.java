package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewQuestionRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Questions;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.QuestionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class QuestionServiceTest {

    private QuestionService testService;
    private QuestionRepository questionRepositoryMock;
    private Questions mockQuestions;
    private NewQuestionRequest mockRequest;

    @BeforeEach
    public void setUp() {

        questionRepositoryMock = mock(QuestionRepository.class);
        testService = new QuestionService(questionRepositoryMock);
        mockQuestions = mock(Questions.class);
        mockRequest = mock(NewQuestionRequest.class);
        when(mockRequest.getQuestion()).thenReturn("Question");
        when(mockRequest.getCategory_id()).thenReturn("CatId");
        when(mockRequest.getId()).thenReturn("Id");
    }

    @AfterEach
    public void setdown(){
        questionRepositoryMock = null;
        mockQuestions = null;
        testService = null;
        mockRequest = null;
    }

    @Test
    public void getAll() {
        when(questionRepositoryMock.findAll()).thenReturn(Arrays.asList(mockQuestions));
        List<Questions> questions = testService.getAll();
        verify(questionRepositoryMock, times(1)).findAll();
        assertNotNull(questions);
    }

    @Test
    void addQuestion() {
        String question = testService.addQuestion(mockRequest);
        assertNotNull(question);
    }

    @Test
    void delete() {
        testService.delete(mockQuestions);
        verify(questionRepositoryMock, times(1)).delete(any());
    }
}