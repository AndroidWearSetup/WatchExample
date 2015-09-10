package hackzurich.learnwithus;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AnswerItemAdapter {

    private Answer answer;
    private LinearLayout answerLayout;

    public AnswerItemAdapter(Answer answer, LinearLayout answerLayout) {
        this.answer = answer;
        this.answerLayout = answerLayout;
    }

    public void setAnswerView() {

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

        final TextView markTextView = (TextView) answerLayout.findViewById(R.id.markTextView);
        markTextView.setText(answer.getMark());

        final TextView answerTextView = (TextView) answerLayout.findViewById(R.id.answerTextView);
        answerTextView.setText(answer.getText());
    }
}
