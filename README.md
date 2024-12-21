# Quiz App API

This is a simple Quiz App API built with Spring Boot. The API allows users to:
1. Start a new quiz session.
2. Get a random multiple-choice question from a set of questions in the database.
3. Submit an answer.
4. Get the total questions answered by the user with details on correct and incorrect submissions.

## Assumptions
- There is only one user (`testuser`) in the database for simplicity.
- Questions are seeded in the database using `data.sql`.
- The API uses an in-memory H2 database.

## Endpoints

### Start a New Quiz Session
- **URL:** `POST /api/quiz/start/{userId}`
- **Description:** Starts a new quiz session for the given user.

### Get Random Question
- **URL:** `GET /api/quiz/question/random`
- **Description:** Retrieves a random multiple-choice question.

### Submit Answer
- **URL:** `POST /api/quiz/submit`
- **Description:** Submits an answer for a given question in a quiz session.
- **Parameters:**
  - `quizSessionId` (UUID)
  - `questionId` (UUID)
  - `chosenOption` (String)

### Get Quiz Results
- **URL:** `GET /api/quiz/results/{quizSessionId}`
- **Description:** Retrieves the results of a quiz session, including details on correct and incorrect submissions.

## Running the Application
1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using `mvn spring-boot:run`.

The H2 console is available at `http://localhost:8080/h2-console` with the following credentials:
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** `password`# #
