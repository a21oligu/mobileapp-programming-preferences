package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private SharedPreferences preferences;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.preferences = getSharedPreferences("com.example.project.data", Context.MODE_PRIVATE);
        this.resultText = findViewById(R.id.textView);

        this.intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.setAction(Intent.ACTION_SEND);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String text = preferences.getString("text", "Shared Preferences");

        resultText.setText(text);

    }

    public void launchSecondActivity(View view) {
        startActivity(intent);
    }
}
