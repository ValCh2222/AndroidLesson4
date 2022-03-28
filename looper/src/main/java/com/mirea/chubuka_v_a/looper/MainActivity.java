package com.mirea.chubuka_v_a.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Mylooper myLooper;
    private EditText ageInput;
    private EditText workInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ageInput = (EditText) findViewById(R.id.age_input);
        workInput = (EditText) findViewById(R.id.work_input);
        myLooper = new Mylooper();
        myLooper.start();
    }

    public void onButtonClick(View view){


        Message msg = new Message();
        Bundle bundle2 = new Bundle();
        int age = Integer.parseInt(ageInput.getText().toString());
        String work = workInput.getText().toString();
        bundle2.putInt("AGE", age);
        bundle2.putString("WORK", work);
        msg.setData(bundle2);
        if (myLooper != null) {
            myLooper.handler.sendMessage(msg);
        }
    }
}