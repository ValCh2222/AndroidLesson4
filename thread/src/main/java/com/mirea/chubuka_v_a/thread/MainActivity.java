package com.mirea.chubuka_v_a.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText lessonsCountInput = (EditText) findViewById(R.id.editText2);
        EditText daysCountInput = (EditText) findViewById(R.id.editText);
        TextView resultTextView = (TextView) findViewById(R.id.textView3);
        Button showResultsButton = (Button) findViewById(R.id.button);
        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Текущий поток: " + mainThread.getName());
        // Меняем имя и выводим в текстовом поле
        mainThread.setName("MireaThread");
        infoTextView.append("\n Новое имя потока: " + mainThread.getName());
        showResultsButton.setOnClickListener((view) -> {
            Thread thread = new Thread(() -> {
                double lessonsCount = Double.parseDouble(lessonsCountInput.getText().toString());
                double daysCount = Double.parseDouble(daysCountInput.getText().toString());
                double lessonsPerDay = lessonsCount / daysCount;
                runOnUiThread(() -> resultTextView.setText(String.valueOf(lessonsPerDay)));
            });
            thread.start();

        });
    }
}