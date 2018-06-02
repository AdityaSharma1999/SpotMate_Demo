package edu.purdue.aditya.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private Button CreateNewAppointment;
    private String username;
    private ListView currentAppointments;
    //private ListView currentAppointment = new ListView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        username = getIntent().getStringExtra("Username");
        currentAppointments = (ListView)findViewById(R.id.lists);

        if(getIntent().getStringExtra("UsernameBOSS")!=null)
        {
            username = getIntent().getStringExtra(("UsernameBOSS"));
            System.out.println(username+"YAAAAY");
        }

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);

        CreateNewAppointment = (Button)findViewById(R.id.appointment);

        //CreateNewAppointment.setOnClickListener(onNewIntent(););
        CreateNewAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(view);
            }
        });
    }

    private void validate(View v)
    {
        if(v.getId() == R.id.appointment)
        {
           // EditText a = (EditText)findViewById(R.id.UserName);
           // String str = a.getText().toString();
            Intent iSignUp = new Intent(SecondActivity.this, CreateAppointment.class);
            iSignUp.putExtra("UsernametoCreate",username);
            //iSignUp.putExtra("TheEntireList",currentAppointments);
            startActivity(iSignUp);
        }


//        if(v.getId() == R.id.Sign_Up)
//        {
//            Intent iSignUp = new Intent(MainActivity.this, signup.class);
//            startActivity(iSignUp);
//        }

    }
}
