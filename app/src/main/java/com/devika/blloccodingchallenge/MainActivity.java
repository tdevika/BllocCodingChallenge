package com.devika.blloccodingchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.devika.blloccodingchallenge.task1.GalleryActivity;
import com.devika.blloccodingchallenge.task2.SwitchActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGalleryActivity(View view) {
        startActivity(new Intent(this, GalleryActivity.class));
    }

    public void startSwitchActivity(View view) {
        startActivity(new Intent(this, SwitchActivity.class));
    }
}
