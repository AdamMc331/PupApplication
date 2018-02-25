package nyc.c4q.pupapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.pupapplication.Network.Service;
import nyc.c4q.pupapplication.model.Dogs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class BreedsActivity extends AppCompatActivity {

    SharedPreferences login;
    String USER_KEY;
    private static final String TAG = "JSON?";
    private ImageView imageView;
    private TextView newPup;
    private TextView textView;
    private Service service;
    private String puppyUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeds);

        TextView textView = (TextView) findViewById(R.id.welcome);
        Intent intent = getIntent();
        String user = intent.getStringExtra("currentUser");
        textView.setText(getString(R.string.BreedText) + user + "?");



        imageView = (ImageView) findViewById(R.id.terrier);
       // newPup = (TextView)findViewById(R.id.)

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(Service.class);

        newPup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Dogs> puppy = service.getPuppy();
                puppy.enqueue(new Callback<Dogs>() {
                    @Override
                    public void onResponse(Call<Dogs> call, Response<Dogs> response) {
                        Log.d(TAG, "onResponse: " + response.body().getMessage());
                        puppyUrl = response.body().getMessage();
                        Picasso.with(getApplicationContext())
                                .load(response.body().getMessage())
                                .into(imageView);
                    }

                    @Override
                    public void onFailure(Call<Dogs> call, Throwable t) {
                        Log.d(TAG, "onResponse: " + t.toString());
                    }
                });
            }
        });

        if(savedInstanceState != null) {
            String savedPuppy = savedInstanceState.getString("puppyUrl");
            puppyUrl = savedPuppy;
            Picasso.with(getApplicationContext())
                    .load(savedPuppy)
                    .into(imageView);
        } else {
            newPup.callOnClick();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("puppyUrl", puppyUrl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SharedPreferences.Editor editor = login.edit();
        editor.putString(USER_KEY, null);
        Intent loginIntent = new Intent(BreedsActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        return true;
    }
}