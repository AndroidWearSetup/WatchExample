package hackzurich.learnwithus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DifficultyLevelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_level);

        addButtonsListeners();
    }

    private void addButtonsListeners() {
        addDifficultyLevelButtonsListeners();
        addStartTestButtonListener();
    }

    private void addDifficultyLevelButtonsListeners() {
        Button easyLevelButton = (Button) findViewById(R.id.easyLevelButton);
        Button mediumLevelButton = (Button) findViewById(R.id.mediumLevelButton);
        Button highLevelButton = (Button) findViewById(R.id.highLevelButton);

        addDifficultyLevelButtonListener(easyLevelButton);
        addDifficultyLevelButtonListener(mediumLevelButton);
        addDifficultyLevelButtonListener(highLevelButton);
    }

    private void addDifficultyLevelButtonListener(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDifficultyLevelButtonClicked(button);
            }
        });
    }

    private void onDifficultyLevelButtonClicked(Button button) {
        changeButtonBackgroundColor(button);
    }

    private void changeButtonBackgroundColor(Button button) {
        if(button.isSelected()) {
            button.setSelected(false);
            button.setBackgroundResource(R.color.grey);
        }
        else {
            button.setSelected(true);
            button.setBackgroundResource(R.color.blue);
        }
    }

    private void addStartTestButtonListener() {
        Button startTestButton = (Button) findViewById(R.id.startTestButton);
        startTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartTestClicked();
            }
        });
    }

    //TODO: Implement this method
    private void onStartTestClicked() {
        Toast.makeText(this,"OK, so I'm starting the test...", Toast.LENGTH_LONG).show();
    }
}
