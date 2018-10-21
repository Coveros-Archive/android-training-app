package coveros.com.trainingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "HELLO";
    private EditText email;
    private EditText password;
    private Button submit;
    private Button register;

    private final String USERNAME = "Admin";
    private final String PW = "Admin";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnLinkToRegisterScreen);


        //check to see if user is logged in
        //TODO login session


        //Login button click event

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = email.getText().toString().trim();
                String passwordInput = password.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(emailInput, passwordInput)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }

                            }
                        });
            }
        });

        //Register button click event

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to register page
                //TODO implement register page
            }
        });


    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private  void updateUI(FirebaseUser currentUser) {
        if(currentUser != null){
            //TODO
            Intent homePage = new Intent(this,HomeActivity.class);
            startActivity(homePage);
        }
    }

}
