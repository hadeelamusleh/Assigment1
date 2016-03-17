package com.example.ham.assigment1;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
    EditText inputFromUser;
    TextView res;
    Random r = new Random();

    int myRandomNumber = r.nextInt(1000- 0) + 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputFromUser=(EditText)findViewById(R.id.inputFromUser);
        Button check=(Button)findViewById(R.id.check);
        res=(TextView)findViewById(R.id.res);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Double userNum=Double.parseDouble(inputFromUser.getText().toString());

                 if(userNum>myRandomNumber){
                  res.setText("Greater");
                }
                else if(userNum<myRandomNumber){
                    res.setText("Smaller");
                }
                else {
                    res.setText("Is Equal,Congratulation");
                }
                if((userNum-myRandomNumber<=5)&&(userNum-myRandomNumber>=-5)&&(userNum-myRandomNumber!=0)){
                    Context context = getApplicationContext();
                    CharSequence text = "Very Close!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        Button restart=(Button)findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                 myRandomNumber = r.nextInt(1000- 0) + 0;
                inputFromUser.setText("");
                res.setText("");
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
