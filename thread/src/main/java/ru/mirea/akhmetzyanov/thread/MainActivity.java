package ru.mirea.akhmetzyanov.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText lessons;
    private EditText quantity;
    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lessons = (EditText)findViewById(R.id.editTextTextPersonName);
        quantity = (EditText)findViewById(R.id.editTextTextPersonName2);
        answer = (TextView)findViewById(R.id.answer);

        Button showResult = (Button)findViewById(R.id.button);
        showResult.setOnClickListener((view) ->{
            Thread thread = new Thread(()->{
                double lessonsPerMonth = Double.parseDouble(lessons.getText().toString());
                double quantityPerMonth = Double.parseDouble(quantity.getText().toString());
                double lessonsPerDay = lessonsPerMonth / quantityPerMonth;
                runOnUiThread(() -> answer.setText(String.valueOf(lessonsPerDay)));
            });
            thread.start();
        } );
    }

}