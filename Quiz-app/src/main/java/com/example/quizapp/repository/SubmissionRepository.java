package com.example.quizapp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.model.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, UUID> {
    List<Submission> findByQuizSessionId(UUID quizSessionId);
}
