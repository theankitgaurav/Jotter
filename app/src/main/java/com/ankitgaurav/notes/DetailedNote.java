package com.ankitgaurav.notes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DetailedNote extends AppCompatActivity {

    MyDBHandler dbHandler;
    private Long n_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detailed_note_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeButtonEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

        //Setting floating button for editing current note
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_edit_note);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), NoteEditor.class);
//                startActivity(intent);
//            }
//        });

        Intent intent = getIntent();

        //Getting variables here
        String note_created_at = intent.getStringExtra("note_created_at");
        String noteText = intent.getStringExtra("noteText");


        //Setting variables here
        ab.setTitle(note_created_at);
        TextView textView = (TextView) findViewById(R.id.detailedNoteTextView);
        textView.setText(noteText);
//        n_id = (savedInstanceState == null) ? null :
//                (Long) savedInstanceState.getSerializable("note_id");
//        if(n_id == null){
//            n_id  = (Long.parseLong(intent.getStringExtra("note_id")));
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detailed_note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                //deleteThisNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putSerializable("note_id", n_id);
//    }

//    public void deleteThisNote(){
//        try {
//            if(n_id != null){
//                dbHandler.deleteNote(n_id.toString());
//            }
//        }
//        catch (Exception e){
//            Toast.makeText(getApplicationContext(), "Delete operation failed" + e, Toast
//                    .LENGTH_SHORT).show();
//        }
//        returnHome();
//    }
    private void returnHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}