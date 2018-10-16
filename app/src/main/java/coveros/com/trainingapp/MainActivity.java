package coveros.com.trainingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText email;
    private EditText password;
    private Button submit;
    private Button register;

    private final String USERNAME = "Admin";
    private final String PW = "Admin";

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

                if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Username or Password are empty", Toast.LENGTH_LONG)
                            .show();
                }
                else if(!emailInput.equals(USERNAME) || !passwordInput.equals(PW)){
                    Toast.makeText(getApplicationContext(),
                            "Username or Password are incorrect", Toast.LENGTH_LONG)
                            .show();
                }
                else {
                    if(emailInput.equals(USERNAME) && passwordInput.equals(PW)){
                        //GO TO HOMEPAGE
                        Toast.makeText(getApplicationContext(),
                                "Welcome Admin!", Toast.LENGTH_LONG)
                                .show();
                        //TODO add homepage

                    }
                }
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
}
