package hcmute.edu.vn.activity_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    private EditText edtEmail;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        getSupportActionBar().setTitle("Activity 2");

        edtEmail = (EditText) findViewById(R.id.edit_email);
        btnUpdate = (Button) findViewById(R.id.btn_send);
        edtEmail.setText(getIntent().getStringExtra("key_email"));
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });
    }

    private void backActivity() {
        String strEmailUpdate = edtEmail.getText().toString().trim();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("key_email",strEmailUpdate);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}