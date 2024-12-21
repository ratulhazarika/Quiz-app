package com.example.quizapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.model.Question;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
}