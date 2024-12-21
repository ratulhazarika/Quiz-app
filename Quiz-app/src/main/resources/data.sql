-- Create user table
CREATE TABLE IF NOT EXISTS "user" (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL
);

-- Create question table
CREATE TABLE IF NOT EXISTS question (
    id UUID PRIMARY KEY,
    question_text VARCHAR(255) NOT NULL,
    option_a VARCHAR(255) NOT NULL,
    option_b VARCHAR(255) NOT NULL,
    option_c VARCHAR(255) NOT NULL,
    option_d VARCHAR(255) NOT NULL,
    correct_option CHAR(1) NOT NULL
);

-- Create quiz_session table
CREATE TABLE IF NOT EXISTS quiz_session (
    id UUID PRIMARY KEY,
    user_id UUID,
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);

-- Create submission table
CREATE TABLE IF NOT EXISTS submission (
    id UUID PRIMARY KEY,
    quiz_session_id UUID,
    question_id UUID,
    chosen_option CHAR(1),
    is_correct BOOLEAN,
    FOREIGN KEY (quiz_session_id) REFERENCES quiz_session (id),
    FOREIGN KEY (question_id) REFERENCES question (id)
);

-- Insert initial data
INSERT INTO "user" (id, username) VALUES (RANDOM_UUID(), 'testuser');

INSERT INTO question (id, question_text, option_a, option_b, option_c, option_d, correct_option) VALUES (RANDOM_UUID(), 'What is the capital of France?', 'Berlin', 'Madrid', 'Paris', 'Rome', 'C');
INSERT INTO question (id, question_text, option_a, option_b, option_c, option_d, correct_option) VALUES (RANDOM_UUID(), 'What is 2 + 2?', '3', '4', '5', '6', 'B');
INSERT INTO question (id, question_text, option_a, option_b, option_c, option_d, correct_option) VALUES (RANDOM_UUID(), 'What is the largest planet in our solar system?', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'C');
