package hackzurich.learnwithus;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AnswerItemAdapter {

    private Answer answer;
    private Boolean choosen;

    public AnswerItemAdapter(Answer answer) {
        this.answer = answer;
        choosen = false;
    }

    public void setAnswerView(LinearLayout answerLayout) {

        answerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isChoosen()) {
                    answerLayout.setBackgroundColor(0xff324e94);
                    setChoosen(true);
                } else {
                    answerLayout.setBackgroundColor(0xff666666);
                    setChoosen(false);
                }
            }
        });
        if (isChoosen()) {
            answerLayout.setBackgroundColor(0xff324e94);
        } else {
            answerLayout.setBackgroundColor(0xff666666);
        }
        final TextView markTextView = (TextView) answerLayout.findViewById(R.id.markTextView);
        markTextView.setText(answer.getMark());

        final TextView answerTextView = (TextView) answerLayout.findViewById(R.id.answerTextView);
        answerTextView.setText(answer.getText());
    }

    public final Boolean isChoosen() {
        return choosen;
    }

    public final void setChoosen(Boolean choosen) {
        this.choosen = choosen;
    }

    public Boolean isCorrect() {
        return answer.isCorrect();
    }
}
