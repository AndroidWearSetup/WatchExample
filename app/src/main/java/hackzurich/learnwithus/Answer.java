package hackzurich.learnwithus;

import android.content.Intent;

/**
 * Created by karola on 08.09.15.
 */
public class Answer {

    public final static String MARK = "mark";
    public final static String TEXT = "text";
    public final static String IS_CHOOSEN = "is_choosen";
    public final static String IS_CORRECT = "is_correct";

    private String mark;
    private String text;
    private Boolean correct;
    private Boolean choosen;

    public Answer(String mark, String text, Boolean correct) {
        this.mark = mark;
        this.text = text;
        this.correct = correct;
        this.choosen = false;
    }

    public Answer(Intent intent) {
        mark = intent.getStringExtra(Answer.MARK);
        text = intent.getStringExtra(Answer.TEXT);
        correct = Boolean.parseBoolean(intent.getStringExtra(Answer.IS_CORRECT));
        choosen = Boolean.parseBoolean(intent.getStringExtra(Answer.IS_CHOOSEN));
    }

    public final String getText() { return text; }

    public final void setText(String text) {
        this.text = text;
    }

    public final String getMark() { return mark; }

    public final void setMark(String mark) {
        this.mark = mark;
    }

    public final Boolean isCorrect() { return correct; }

    public final void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public final Boolean isChoosen() {
        return choosen;
    }

    public final void setChoosen(Boolean choosen) {
        this.choosen = choosen;
    }

    public static void packageIntent(Intent intent, String mark, String text, Boolean choosen, Boolean correct) {
        intent.putExtra(Answer.MARK, mark);
        intent.putExtra(Answer.TEXT, text);
        intent.putExtra(Answer.IS_CHOOSEN, choosen.toString());
        intent.putExtra(Answer.IS_CORRECT, correct.toString());
    }


}
