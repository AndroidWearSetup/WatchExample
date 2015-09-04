package hackzurich.learnwithus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class TriggerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trigger_activity);
        findViewById(R.id.trigger_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
