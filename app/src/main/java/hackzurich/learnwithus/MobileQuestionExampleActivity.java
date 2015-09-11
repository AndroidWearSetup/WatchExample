package hackzurich.learnwithus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import hackzurich.learnwithus.model.Question;
import hackzurich.learnwithus.stub.QuestionStubFactory;

import static android.widget.Toast.LENGTH_SHORT;


public class MobileQuestionExampleActivity extends AppCompatActivity {

    //TODO: Should be pass to activity from outside - this is just stub example
    Question question = QuestionStubFactory.doubleLengthDummyQuestion();
    AnswerListAdapter answerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_question_example_activity);

        bindHeader(question);
        bindAnswers(question);
        bindFooter();
    }

    private void bindHeader(Question question) {
        TextView questionCountTextView = (TextView) findViewById(R.id.questionCountTextView);
        questionCountTextView.setText("1/infinitive");
        TextView questionMarkTextView = (TextView) findViewById(R.id.questionMarkTextView);
        questionMarkTextView.setText(question.identifier);
        TextView questionTextView = (TextView) findViewById(R.id.questionTextView);
        questionTextView.setText(question.text);
    }

    private void bindAnswers(Question question) {
        ListView listView = (ListView) findViewById(R.id.listView);
        answerListAdapter = new AnswerListAdapter(this, question.answers);
        listView.setAdapter(answerListAdapter);
    }

    private void bindFooter() {
        findViewById(R.id.doNotKnowButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNotKnowClicked();
            }
        });
        findViewById(R.id.confirmAnswerQuestionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onConfirmClicked();
            }
        });
    }

    private void onNotKnowClicked() {
        Log.i("MobileQuestionActivity", "doNotKnowButtonClicked");
        Toast.makeText(this, "Shame on you!", LENGTH_SHORT).show();
    }

    private void onConfirmClicked() {
        Log.i("MobileQuestionActivity", "confirmAnswerButtonClicked");
        answerListAdapter.colourAnswersField();
        if (answerListAdapter.wasCorrectAnswerMarked()) {
            Toast.makeText(this, "Good job!", LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Answers are not correct!", LENGTH_SHORT).show();
        }
    }
}
