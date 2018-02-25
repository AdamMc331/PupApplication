package nyc.c4q.pupapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "sharedPrefsKey";
    private EditText username;
    private EditText password;
    private CheckBox save;
    private Button submit;
    private SharedPreferences login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        save = findViewById(R.id.save);
        submit = findViewById(R.id.Submit);

        submit = findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = login.edit();
                String checkUser = "Charlie";
                String checkPassword = "abc123";

                if (save.isChecked()) {
                    editor.putString("username", username.getText().toString());
                    editor.putString("password", password.getText().toString());
                    editor.putBoolean("isChecked", save.isChecked());
                    editor.commit();
                } else {
                    editor.putBoolean("isChecked", save.isChecked());
                    editor.commit();
                }
                if (username.getText().toString().contains(checkUser) && password.getText().toString().contains(checkPassword)) {
                    Intent intent = new Intent(LoginActivity.this, BreedsActivity.class);
                    intent.putExtra("currentUser", username.getText().toString());
                    startActivity(intent);
                } else {
                    username.setError("Please Enter Username");
                    password.setError("Please Enter Password");
                    username.requestFocus();
                    password.requestFocus();
                }
            }
        });

        if (login.getBoolean("isChecked", false)) {
            username.setText(login.getString("username", null));
            password.setText(login.getString("password", null));
            save.setChecked(login.getBoolean("isChecked", false));
        }
    }
}
