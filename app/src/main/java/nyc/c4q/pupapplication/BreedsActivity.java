package nyc.c4q.pupapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BreedsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeds);

        TextView textView = (TextView) findViewById(R.id.welcome);
        Intent intent = getIntent();
        String user = intent.getStringExtra("currentUser");
        textView.setText(getString(R.string.BreedText) + user + " ?");
    }
}
