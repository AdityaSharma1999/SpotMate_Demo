package edu.purdue.aditya.logindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sharm on 5/30/2018.
 */

public class signup extends AppCompatActivity
{

    private EditText Name;
    private EditText Email_Address;
    private EditText Username;
    private EditText Password;
    private EditText ConfirmPassword;
    private Button Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Name = (EditText)findViewById(R.id.yourname_SignUp);
        Email_Address = (EditText)findViewById(R.id.Email_Address_SignUp);
        Username = (EditText)findViewById(R.id.UsernameSignUp);
        Password = (EditText)findViewById(R.id.SignUpPassword);
        ConfirmPassword = (EditText) findViewById(R.id.Confirm_Password);
        Signup = (Button)findViewById(R.id.SignUpUp);



        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(view);
            }
        });

    }

    MainActivity newMain = new MainActivity();
//@Override
//protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_second);
//    String username = getIntent().getStringExtra("Username");
//
//    TextView tv = (TextView)findViewById(R.id.TVusername);
//    tv.setText(username);
//}

    private void validate(View v)
    {
        if(v.getId() == R.id.SignUpUp)
        {
            EditText name = (EditText)findViewById(R.id.yourname_SignUp);
            EditText email = (EditText)findViewById(R.id.Email_Address_SignUp);
            EditText username = (EditText)findViewById(R.id.UsernameSignUp);
            EditText password = (EditText)findViewById(R.id.SignUpPassword);
            EditText confirm_password = (EditText)findViewById(R.id.Confirm_Password);

            String nameStr = name.getText().toString();
            String emailStr = email.getText().toString();
            String usernameStr = username.getText().toString();
            String passwordStr = password.getText().toString();
            String confirm_passwordStr = confirm_password.getText().toString();

            if(!passwordStr.equals(confirm_passwordStr))
            {
                Toast sendPopUp = Toast.makeText(signup.this,"The Passwords don't match!",Toast.LENGTH_SHORT);
                sendPopUp.show();
            }
            else
            {
                //MainActivity newMain = new MainActivity();
                ArrayList<Users> usersList = new ArrayList<Users>();
                usersList = newMain.getArray();
                Users newuser = new Users(nameStr,emailStr,usernameStr,passwordStr);
                if(usersList.contains(newuser))
                {
                    Toast sendPopUp = Toast.makeText(signup.this,"User already exists!",Toast.LENGTH_SHORT);
                    sendPopUp.show();
                }
                else
                {
                    //newMain.addToArray(newuser);
                    System.out.println(newuser.getName());
                    Intent intent = new Intent(signup.this,MainActivity.class);
                    intent.putExtra("name",nameStr);
                    intent.putExtra("email",emailStr);
                    intent.putExtra("username",usernameStr);
                    intent.putExtra("password",passwordStr);
                    //intent.putExtra("object",newuser);

                    //intent.putExtra("Username",str);
                    startActivity(intent);
                }
                //Users[] checkNames = newMain.getArray();
//                Users newuser = new Users(nameStr,emailStr,usernameStr,passwordStr);
            }

        }
    }
}
