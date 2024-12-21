package com.example.quizapp.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuizSession;
import com.example.quizapp.model.Submission;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizSessionRepository;
import com.example.quizapp.repository.SubmissionRepository;
import com.example.quizapp.repository.UserRepository;

@Service
public class QuizService {
    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private UserRepository userRepository;

    public QuizSession startNewQuizSession(UUID userId) {
        QuizSession quizSession = new QuizSession();
        quizSession.setUserId(userId);
        return quizSessionRepository.save(quizSession);
    }

    public Optional<Question> getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) {
            return Optional.empty();
        }
        Random random = new Random();
        return Optional.of(questions.get(random.nextInt(questions.size())));
    }

    public Submission submitAnswer(UUID quizSessionId, UUID questionId, String chosenOption) {
        Optional<Question> questionOpt = questionRepository.findById(questionId);
        if (!questionOpt.isPresent()) {
            throw new IllegalArgumentException("Invalid question ID");
        }

        Question question = questionOpt.get();
        boolean isCorrect = question.getCorrectOption().equals(chosenOption);

        Submission submission = new Submission();
        submission.setQuizSessionId(quizSessionId);
        submission.setQuestionId(questionId);
        submission.setChosenOption(chosenOption);
        submission.setCorrect(isCorrect);

        return submissionRepository.save(submission);
    }

    public List<Submission> getQuizResults(UUID quizSessionId) {
        return submissionRepository.findByQuizSessionId(quizSessionId);
    }
}