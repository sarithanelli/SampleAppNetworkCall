package activitylifecycle.example.com.sampleappnetworkcall;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText etUserName, etPassword, etEmail;
    TextView login;
    Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //initialization
        etUserName = (EditText) findViewById(R.id.dbs_username);
        etPassword = (EditText) findViewById(R.id.dbs_password);
        login = (TextView) findViewById(R.id.txt_login);
        etEmail = (EditText) findViewById(R.id.dbs_email);
        signup = (Button) findViewById(R.id.btn_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();
                //validate form
                if (validSignup(username, password, email)) {
                    //do Signup
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Registration success", Toast.LENGTH_LONG).show();
                }

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    public boolean validSignup(String userName, String Password, String email) {
        if (userName == null || userName.trim().length() == 0) {
            etUserName.setError("Please enter Name");
            return false;
        }
        if (email == null || email.trim().length() == 0) {
            etEmail.setError("Please enter Email");
            return false;
        }
        if (Password == null || Password.trim().length() == 0) {
            etPassword.setError("Please enter password");
            return false;
        }

        return true;
    }

}
