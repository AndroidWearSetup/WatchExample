package hackzurich.learnwithus.stub;

import java.util.ArrayList;
import java.util.List;

import hackzurich.learnwithus.Answer;
import hackzurich.learnwithus.model.Question;

public final class QuestionStubFactory {
    public static Question dummyQuestion() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("A.", "Thanks, I'm fine", false));
        answers.add(new Answer("B.", "Quite good", false));
        answers.add(new Answer("C.", "Shitty", false));
        answers.add(new Answer("D.", "I ain't happy, I'm feeling glad", true));
        answers.add(new Answer("E.", "A little bit uncomfortable", false));
        answers.add(new Answer("F.", "I have a hangover", false));
        answers.add(new Answer("G.", "Well this is number seven and I'm feeling like in heaven", true));
        return new Question("1.","Hello my little friend! How are you?",answers);
    }
    public static Question doubleLengthDummyQuestion() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("A.", "Thanks, I'm fine", false));
        answers.add(new Answer("B.", "Quite good", false));
        answers.add(new Answer("C.", "Shitty", false));
        answers.add(new Answer("D.", "I ain't happy, I'm feeling glad", true));
        answers.add(new Answer("E.", "A little bit uncomfortable", false));
        answers.add(new Answer("F.", "I have a hangover", false));
        answers.add(new Answer("G.", "Well this is number seven and I'm feeling like in heaven", true));
        answers.add(new Answer("A.", "Thanks, I'm fine", false));
        answers.add(new Answer("B.", "Quite good", false));
        answers.add(new Answer("C.", "Shitty", false));
        answers.add(new Answer("D.", "I ain't happy, I'm feeling glad", true));
        answers.add(new Answer("E.", "A little bit uncomfortable", false));
        answers.add(new Answer("F.", "I have a hangover", false));
        answers.add(new Answer("G.", "Well this is number seven and I'm feeling like in heaven", true));
        return new Question("1.","Hello my little friend! How are you?",answers);
    }
}
