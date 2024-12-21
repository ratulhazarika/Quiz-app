package com.example.quizapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.model.QuizSession;

public interface QuizSessionRepository extends JpaRepository<QuizSession, UUID> {
}
