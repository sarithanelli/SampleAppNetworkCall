package activitylifecycle.example.com.sampleappnetworkcall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText etUserName, etPassword;
    Button login;
    TextView signup;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialization
        etUserName = (EditText) findViewById(R.id.dbs_username);
        etPassword = (EditText) findViewById(R.id.dbs_password);
        login = (Button) findViewById(R.id.dbs_btn_login);
        signup = (TextView) findViewById(R.id.btn_signup);

        //Retrofit api interface initialization

        apiInterface = APIClent.getClient().create(APIInterface.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                //validate form
                if (validLogin(username, password)) {
                    //do login
                    doLogin(username, password);
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(i);
            }
        });
    }

    public boolean validLogin(String userName, String Password) {
        if (userName == null || userName.trim().length() == 0) {
            etUserName.setError("Please enter Email");
            return false;
        }
        if (Password == null || Password.trim().length() == 0) {
            etPassword.setError("Please enter password");
            return false;
        }
        return true;
    }

    public void doLogin(String username, String password) {
        User user = new User(username, password);
        //Retrofit Create Method in interface class
        Call<User> call = apiInterface.createUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user1 = response.body();
                String name = user1.name;
                String id = user1.job;
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "name" + id, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

}
