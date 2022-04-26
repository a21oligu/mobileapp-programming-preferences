package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private EditText editText;
    private final String SHARED_PREFERENCES_NAME = "com.example.project.data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.preferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
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