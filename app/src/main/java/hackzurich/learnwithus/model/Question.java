package hackzurich.learnwithus.model;

import java.util.List;

import hackzurich.learnwithus.Answer;

public final class Question {
    public String identifier;
    public String text;
    public List<Answer> answers;

    public Question(String identifier, String text, List<Answer> answers) {
        this.identifier = identifier;
        this.text = text;
        this.answers = answers;
    }
}
