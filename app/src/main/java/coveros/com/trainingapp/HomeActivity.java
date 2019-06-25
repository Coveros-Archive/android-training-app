package coveros.com.trainingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class HomeActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView welcomeText;
    private Button trainingButton;
    private Button testingButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        trainingButton = findViewById(R.id.trainingButton);
        testingButton = findViewById(R.id.testingButton);

        mAuth = FirebaseAuth.getInstance();
        welcomeText = findViewById(R.id.welcome_text);
        FirebaseUser user = mAuth.getCurrentUser();
        if(user != null){
            String welcome = user.getEmail().toString();
            welcomeText.setText("Welcome "+welcome);

            //TODO updates display name to provided string if you want to add name fields
//            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                    .setDisplayName("Arya").build();
//
//            user.updateProfile(profileUpdates);
//            String welcome = user.getDisplayName();
        }


        trainingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to training page
                Intent test = new Intent(HomeActivity.this, TrainingPage.class);
                startActivity(test);
            }
        });

        testingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to testing page
                Intent train = new Intent(HomeActivity.this, TestingPage.class);
                startActivity(train);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.signOut:
                // User chose the "Settings" item, show the app settings UI...
                mAuth.signOut();
                Intent signIn = new Intent(this, MainActivity.class);
                startActivity(signIn);
                finish();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_items, menu);
        return true;
    }
}
