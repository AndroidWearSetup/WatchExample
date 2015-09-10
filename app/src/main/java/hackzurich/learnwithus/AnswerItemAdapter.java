package hackzurich.learnwithus;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AnswerItemAdapter {

    private Answer answer;

    public AnswerItemAdapter(Answer answer) {
        this.answer = answer;
    }

    public void setAnswerView(LinearLayout answerLayout) {

        answerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answer.isChoosen()) {
                    answerLayout.setBackgroundColor(0xff324e94);
                    answer.setChoosen(true);
                } else {
                    answerLayout.setBackgroundColor(0xff666666);
                    answer.setChoosen(false);
                }
            }
        });
        if (answer.isChoosen()) {
            answerLayout.setBackgroundColor(0xff324e94);
        } else {
            answerLayout.setBackgroundColor(0xff666666);
        }
        final TextView markTextView = (TextView) answerLayout.findViewById(R.id.markTextView);
        markTextView.setText(answer.getMark());

        final TextView answerTextView = (TextView) answerLayout.findViewById(R.id.answerTextView);
        answerTextView.setText(answer.getText());
    }
}
