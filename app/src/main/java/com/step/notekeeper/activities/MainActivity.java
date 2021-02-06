package com.step.notekeeper.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.step.notekeeper.R;
import com.step.notekeeper.database.NotesDatabase;
import com.step.notekeeper.entities.Note;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD_NOTE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        ImageView imageAddNoteMain = findViewById(R.id.imageAddNoteMain);
        imageAddNoteMain.setOnClickListener(view -> {
            startActivityForResult(new Intent(this, CreateNoteActivity.class),
                    REQUEST_CODE_ADD_NOTE);
        });

        getNotes();
    }

    private void getNotes() {

        class GetNotesTask extends AsyncTask<Void, Void, List<Note>> {
            @Override
            protected void onPostExecute(List<Note> notes) {
                super.onPostExecute(notes);
                //TODO: display the notes.
            }

            @Override
            protected List<Note> doInBackground(Void... voids) {
                return NotesDatabase
                        .getDatabase(getApplicationContext())
                        .noteDao()
                        .getAllNotes();
            }
        }

        new GetNotesTask().execute();
    }
}