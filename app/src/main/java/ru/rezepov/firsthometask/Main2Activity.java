package ru.rezepov.firsthometask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView firstName;
    TextView lastName;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firstName = (TextView) findViewById(R.id.textView);
        lastName = (TextView) findViewById(R.id.textView3);
        date = (TextView) findViewById(R.id.textView4);

        Intent intent = getIntent();
        firstName.setText(intent.getStringExtra(getResources().getString(R.string.first_name)));
        lastName.setText(intent.getStringExtra(getResources().getString(R.string.last_name)));
        date.setText(intent.getStringExtra(getResources().getString(R.string.date)));
    }

    public void openMainActivity(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.first_name), firstName.getText().toString());
        intent.putExtra(getResources().getString(R.string.last_name), lastName.getText().toString());
        intent.putExtra(getResources().getString(R.string.date), date.getText().toString());
        startActivity(intent);
        finish();
    }
}
