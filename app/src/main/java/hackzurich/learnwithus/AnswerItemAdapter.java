package hackzurich.learnwithus;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import hackzurich.learnwithus.model.Answer;

public final class AnswerItemAdapter {

    private Answer answer;
    private Boolean choosen;
    private Boolean submitted;

    public AnswerItemAdapter(Answer answer) {
        this.answer = answer;
        choosen = false;
        submitted = false;
    }

    public void setAnswerView(LinearLayout answerLayout) {

        if (!submitted) {
            answerLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choosen = !choosen;
                    setProperBackgroungColor(answerLayout);
                }
            });
        }
        setProperBackgroungColor(answerLayout);

        TextView markTextView = (TextView) answerLayout.findViewById(R.id.markTextView);
        markTextView.setText(answer.getMark());

        TextView answerTextView = (TextView) answerLayout.findViewById(R.id.answerTextView);
        answerTextView.setText(answer.getText());
    }

    private void setProperBackgroungColor(LinearLayout answerLayout) {
        if (choosen) {
            if (submitted) {
                if (isCorrect()) {
                    answerLayout.setBackgroundResource(R.color.green);
                } else {
                    answerLayout.setBackgroundResource(R.color.red);
                }
            } else {
                answerLayout.setBackgroundResource(R.color.blue);
            }
        } else {
            if (submitted && isCorrect()) {
                answerLayout.setBackgroundResource(R.color.green);
            } else {
                answerLayout.setBackgroundResource(R.color.gray);
            }
        }
    }

    public Boolean isChoosen() {
        return choosen;
    }

    public Boolean isCorrect() {
        return answer.isCorrect();
    }

    public void setSubmitted(Boolean submitted) {
        this.submitted = submitted;
    }

}
