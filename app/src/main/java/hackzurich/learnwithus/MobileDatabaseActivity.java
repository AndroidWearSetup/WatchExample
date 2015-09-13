package hackzurich.learnwithus;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import hackzurich.learnwithus.model.Database;


public class MobileDatabaseActivity extends Activity {

    DatabaseGroupAdapter databaseGroupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_database);

        databaseGroupAdapter = new DatabaseGroupAdapter(this);
        addExampleData();

        Spinner chooseDatabaseSpinner = (Spinner) findViewById(R.id.chooseDatabaseSpinner);
        chooseDatabaseSpinner.setAdapter(databaseGroupAdapter);

        Button startTestButton = (Button) findViewById(R.id.startTestButton);
        startTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartTestClicked();
            }
        });

        Button loadDatabaseButton = (Button) findViewById(R.id.loadDatabaseButton);
        loadDatabaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoadDatabaseClicked();
            }
        });
    }

    private void addExampleData() {
        databaseGroupAdapter.addItem(new Database("I will wait, I will wait for you!","$HOME/"));
        databaseGroupAdapter.addItem(new Database("Hello darkness my old friend...", "/"));
        databaseGroupAdapter.addItem(new Database("Hello isn't me you are looking for?","/A/B/C/"));
    }

    //TODO: implement this method
    private void onStartTestClicked() {
        Toast.makeText(this,"OK, so I'm starting the test...",Toast.LENGTH_LONG).show();
    }
    //TODO: implement this method
    private void onLoadDatabaseClicked() {
        Toast.makeText(this,"I'm loading database, be patient!\n(U know I'm a background thread)", Toast.LENGTH_LONG).show();
    }
}