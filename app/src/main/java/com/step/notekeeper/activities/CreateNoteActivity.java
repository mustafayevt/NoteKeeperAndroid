package com.step.notekeeper.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.step.notekeeper.R;

import java.util.Objects;

public class CreateNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        Objects.requireNonNull(getSupportActionBar()).hide();


        ImageView imageBack = findViewById(R.id.imageBack);
        imageBack.setOnClickListener(view->{
            onBackPressed();
        });
    }
}