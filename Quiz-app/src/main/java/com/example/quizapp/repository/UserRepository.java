package com.example.quizapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
}