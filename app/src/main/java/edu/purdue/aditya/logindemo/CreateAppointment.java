package edu.purdue.aditya.logindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by sharm on 6/1/2018.
 */

public class CreateAppointment extends AppCompatActivity{

    private Button Proceed;
    private EditText Username;
    private EditText Appointment;
    private String UsernameStr;
    private String appointmentStr;
    //private EditText appointmentTime;
    private TimePicker appointTIME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_create);

        Proceed = (Button)findViewById(R.id.Proceed);
        UsernameStr = getIntent().getStringExtra("UsernametoCreate");
        //System.out.println(UsernameStr+"Sharma Ji Ka Beta");
        Appointment = (EditText)findViewById(R.id.AppointmentWith);
        //appointmentTime = (EditText) findViewById(R.id.AppointmentWith);


//
        appointmentStr = Appointment.getText().toString();
      //  System.out.println(appointmentStr+" HAHAHAH");

        //Appointment = (String)findViewById(R.id.editText3);
        //CreateNewAppointment.setOnClickListener(onNewIntent(););
        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(view);
            }
        });
        
        //String username = getIntent().getStringExtra("Username");

        //TextView tv = (TextView)findViewById(R.id.TVusername);
        //tv.setText(username);
    }

    private void validate(View v)
    {
        if(v.getId() == R.id.Proceed)
        {
            // EditText a = (EditText)findViewById(R.id.UserName);
            // String str = a.getText().toString();
            EditText a = (EditText)findViewById(R.id.AppointmentWith);
            String str = a.getText().toString();
            TimePicker b = (TimePicker)findViewById(R.id.timePicker2);
            String hour = Integer.toString(b.getHour());
            String minute = Integer.toString(b.getMinute());
            //String str2 = b.getHour();
            Intent iSignUp = new Intent(CreateAppointment.this, SecondActivity.class);
            iSignUp.putExtra("UsernameBOSS",UsernameStr);
            iSignUp.putExtra("UserNameAPPOINTMENT",appointmentStr);
            System.out.println(UsernameStr+"  !!!  "+str+" !!!!!! "+hour+":"+minute);
            //System.out.println(appointmentStr);
            startActivity(iSignUp);
        }


//        if(v.getId() == R.id.Sign_Up)
//        {
//            Intent iSignUp = new Intent(MainActivity.this, signup.class);
//            startActivity(iSignUp);
//        }

    }
}
