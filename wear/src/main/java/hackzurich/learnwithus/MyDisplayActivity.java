package hackzurich.learnwithus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MyDisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        findViewById(R.id.display).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
