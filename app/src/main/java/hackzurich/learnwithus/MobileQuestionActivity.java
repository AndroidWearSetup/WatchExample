package hackzurich.learnwithus;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MobileQuestionActivity extends ListActivity {

    private static final String TAG = "MobileQuestionActivity";

    AnswerListAdapter answerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_mobile_question);

        answerListAdapter = new AnswerListAdapter(getApplicationContext());

        //TODO: Remove this example code and create method:
        answerListAdapter.add(new Answer("A.", "Thanks, I'm fine", false));
        answerListAdapter.add(new Answer("B.", "Quite good", false));
        answerListAdapter.add(new Answer("C.", "Shitty", false));
        answerListAdapter.add(new Answer("D.", "I ain't happy, I'm feeling glad", true));
        answerListAdapter.add(new Answer("E.", "A little bit uncomfortable", false));
        answerListAdapter.add(new Answer("F.", "I have a hangover", false));
        answerListAdapter.add(new Answer("G.", "Well this is number seven and I'm feeling like in heaven", true));
       /* answerListAdapter.add(new Answer("H.", "This is not the answer! Do not choose me!", false));
        answerListAdapter.add(new Answer("I.", "This is not the answer! Do not choose me!", false));
        answerListAdapter.add(new Answer("J.", "This is not the answer! Do not choose me!", false));*/

        LinearLayout headerView = (LinearLayout) getLayoutInflater().inflate(R.layout.header_view, null);
        //TODO: Remove this example code and create method:
        TextView questionCountTextView = (TextView) headerView.findViewById(R.id.questionCountTextView);
        questionCountTextView.setText("1/infinitive");
        TextView questionMarkTextView = (TextView) headerView.findViewById(R.id.questionMarkTextView);
        questionMarkTextView.setText("1.");
        TextView questionTextView = (TextView) headerView.findViewById(R.id.questionTextView);
        questionTextView.setText("Hello my little friend! How are you?");

        getListView().addHeaderView(headerView);

        // Put divider between answerFields and FooterView
        getListView().setFooterDividersEnabled(true);

        LinearLayout footerView = (LinearLayout) getLayoutInflater().inflate(R.layout.footer_view, null);
        getListView().addFooterView(footerView);

        Button doNotKnowButton = (Button) findViewById(R.id.doNotKnowButton);
        doNotKnowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "doNotKnowButtonClicked");

                Context context = getApplicationContext();
                CharSequence text = "Shame on you!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        Button confirmAnswerQuestionButton = (Button) findViewById(R.id.confirmAnswerQuestionButton);
        confirmAnswerQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"confirmAnswerButtonClicked");

                Context context = getApplicationContext();
                CharSequence text;
                int duration = Toast.LENGTH_SHORT;

                if(answerListAdapter.checkAnswersCorrectness()) {
                    text = "Good job!";
                }
                else {
                    text = "Answers are not correct!";
                }

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                answerListAdapter.colourAnswersField();
            }
        });


        getListView().setAdapter(answerListAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mobile_question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
