package ru.rezepov.firsthometask;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ru.rezepov.firsthometask.fragments.DatePickerFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            ((EditText) findViewById(R.id.editText3)).setText(
                    intent.getStringExtra(getResources().getString(R.string.first_name)));
            ((EditText) findViewById(R.id.editText4)).setText(
                    intent.getStringExtra(getResources().getString(R.string.last_name)));
            ((TextView) findViewById(R.id.textView2)).setText(
                    intent.getStringExtra(getResources().getString(R.string.date)));
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void openMain2Activity(View v) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(getResources().getString(R.string.first_name),
                ((EditText) findViewById(R.id.editText3)).getText().toString());
        intent.putExtra(getResources().getString(R.string.last_name),
                ((EditText) findViewById(R.id.editText4)).getText().toString());
        intent.putExtra(getResources().getString(R.string.date),
                ((TextView) findViewById(R.id.textView2)).getText().toString());
        startActivity(intent);
        finish();
    }
}
