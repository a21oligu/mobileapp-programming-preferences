package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.preferences = getSharedPreferences("com.example.project.data", Context.MODE_PRIVATE);
        this.editText = findViewById(R.id.editText);
    }

    public void saveToSharedPreferences(View view) {
        if (editText.getText().toString().equals("")) {
            Log.d("Preferences", "Empty string");
            return;
        }

        this.preferences.edit().putString("text", editText.getText().toString()).apply();

        finish();
    }
}