package com.example.sendon;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/*
1.OUR LAUNCHER ACTIVITY
2.INITIALIZE SOME UI STUFF
3.WE START SENDER ON BUTTON CLICK
 */
public class MainActivity extends AppCompatActivity {

    String urlAddress="http://internetypatrik.000webhostapp.com/poster.php";
    EditText nameTxt;
    Button saveBtn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALIZE UI FIELDS
        nameTxt= (EditText) findViewById(R.id.nameEditTxt);

        saveBtn= (Button) findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //START ASYNC TASK
                Sender s=new Sender(MainActivity.this,urlAddress,nameTxt);
                s.execute();
            }
        });

    }

}