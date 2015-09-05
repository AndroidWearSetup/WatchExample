package hackzurich.learnwithus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MyDisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        findViewById(R.id.display).setOnClickListener(v -> {
            Toast.makeText(this,"aaaaa",Toast.LENGTH_LONG).show();
        });
    }
}
