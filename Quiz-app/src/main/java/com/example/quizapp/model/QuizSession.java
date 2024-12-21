package com.example.quizapp.model;


import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class QuizSession {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private UUID id;

	    private UUID userId;

}
