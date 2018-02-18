package tvz.pitalicatvz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import tvz.pitalicatvz.remote.APIService;
import tvz.pitalicatvz.remote.ApiUtils;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button taken = (Button) findViewById(R.id.btn_taken);
        Button notTaken = (Button) findViewById(R.id.btn_notTaken);
        Button created = (Button) findViewById(R.id.btn_created);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Bundle bundle = getIntent().getExtras();

//Extract the data…
        final String fullName = bundle.getString("fullName");
        final int id = bundle.getInt("id");
        final Intent intentTaken = new Intent(this, TakenActivity.class);
        final Intent intentNotTaken = new Intent(this, MainActivity.class);
        final Intent intentCreated = new Intent(this, MainActivity.class);

        taken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                //Add your data from getFactualResults method to bundle
                bundle.putString("fullName", fullName);
                bundle.putInt("id", id);
                //Add the bundle to the intent
                intentTaken.putExtras(bundle);

                //Fire the second activity
                startActivity(intentTaken);
            }
        });

        notTaken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Add your data from getFactualResults method to bundle
                bundle.putString("fullName", fullName);
                bundle.putInt("id", id);
                //Add the bundle to the intent
                intentNotTaken.putExtras(bundle);

                //Fire the second activity
                startActivity(intentNotTaken);
            }
        });

        created.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Add your data from getFactualResults method to bundle
                bundle.putString("fullName", fullName);
                bundle.putInt("id", id);
                //Add the bundle to the intent
                intentCreated.putExtras(bundle);

                //Fire the second activity
                startActivity(intentCreated);
            }
        });
    }
}
