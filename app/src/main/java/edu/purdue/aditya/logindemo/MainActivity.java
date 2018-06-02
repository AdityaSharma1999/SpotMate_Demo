package edu.purdue.aditya.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private Button Signup;
    private ArrayList<Users> users = new ArrayList<Users>();

    public ArrayList<Users> getArray()
    {
        return users;
    }
    public void addToArray(Users newUser)
    {
        users.add(newUser);
    }
//    public Add(String name)
//    {
//        users[]
//    }

    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.UserName);
        Password = (EditText)findViewById(R.id.Password);
        Login = (Button)findViewById(R.id.Login);
        Signup = (Button)findViewById(R.id.Sign_Up);

        if(getIntent().getStringExtra("name")!=null)
        {
            //users;
            //
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(view);
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(view);
            }
        });

    }

    private void validate(View v)
    {
        if(v.getId() == R.id.Sign_Up)
        {
            EditText a = (EditText)findViewById(R.id.UserName);
            String str = a.getText().toString();
            Intent iSignUp = new Intent(MainActivity.this, signup.class);
            iSignUp.putExtra("Users",users);
            //iSignUp.putExtra("UserDetail",)
            startActivity(iSignUp);
        }

        if(v.getId() == R.id.Login)
        {
            EditText a = (EditText)findViewById(R.id.UserName);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.Password);
            String pass = b.getText().toString();
            boolean check = false;
//            for(int i=0;i<users.size();i++)
//            {
//                if(users.get(i).getName().equals(a) && users.get(i).getPassword().equals(b))
//                {
//                    check = true;
//                }
//            }
//
//            if(check)
//            {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("Username",str);
            startActivity(intent);
//            }
//            else
//            {
//                Toast sendPopUp = Toast.makeText(MainActivity.this,"The user doesn't exist!",Toast.LENGTH_SHORT);     TO CHECK IF USER EXISTS OR NOT
//                sendPopUp.show();
//            }
        }

                                                            //**************//
//Hey! Aditya here, the things that I commented above, they are just to check whether the user exists or not, however, my intent to transfer the user objects doesn't seem to work, but I will continue to work on this part today
                                                            //**************//
    }
}