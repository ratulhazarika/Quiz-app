package com.example.quizapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuizSession;
import com.example.quizapp.model.Submission;
import com.example.quizapp.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/start/{userId}")
    public ResponseEntity<QuizSession> startNewQuizSession(@PathVariable UUID userId) {
        QuizSession quizSession = quizService.startNewQuizSession(userId);
        return ResponseEntity.ok(quizSession);
    }

    @GetMapping("/question/random")
    public ResponseEntity<Question> getRandomQuestion() {
        Optional<Question> question = quizService.getRandomQuestion();
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping("/submit")
    public ResponseEntity<Submission> submitAnswer(@RequestParam UUID quizSessionId, @RequestParam UUID questionId, @RequestParam String chosenOption) {
        Submission submission = quizService.submitAnswer(quizSessionId, questionId, chosenOption);
        return ResponseEntity.ok(submission);
    }

    @GetMapping("/results/{quizSessionId}")
    public ResponseEntity<List<Submission>> getQuizResults(@PathVariable UUID quizSessionId) {
        List<Submission> results = quizService.getQuizResults(quizSessionId);
        return ResponseEntity.ok(results);
    }
}
