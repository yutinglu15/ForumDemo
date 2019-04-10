package com.example.lab5reddit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity {

    private DatabaseReference myRef;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Messages");
    }

    public void postNew(View view)
    {
        EditText postText = findViewById(R.id.postText);
        String OPText = postText.getText().toString();

        if (OPText.length() > 0)
        {
            String key = myRef.push().getKey();
            Message newOP = new Message(OPText, 0);
            myRef.child(key).setValue(newOP);
        }

        postText.setText("");
    }

    public void goHome(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
