package com.example.roomescape;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class st2_exit_puzzle extends Activity {
    TextView statusTxt;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    int[] st2_exit_password = new int[5];
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.st2_exit_puzzle);

        final Intent intent = new Intent();

        statusTxt = (TextView) findViewById(R.id.st2_exit_puzzle_status);
        btn1 = (Button) findViewById(R.id.st2_button);
        btn2 = (Button) findViewById(R.id.st2_button2);
        btn3 = (Button) findViewById(R.id.st2_button3);
        btn4 = (Button) findViewById(R.id.st2_button4);
        btn5 = (Button) findViewById(R.id.st2_button5);
        btn6 = (Button) findViewById(R.id.st2_button6);
        btn7 = (Button) findViewById(R.id.st2_button7);
        btn8 = (Button) findViewById(R.id.st2_button8);
        btn9 = (Button) findViewById(R.id.st2_button9);


    }


    //password Start
    public void counter_check(){
        if(counter >= 4){
            Toast.makeText(this, "암호는 4자리입니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }


    public void st2_password(View view) {
        boolean st2_answer = false;
        switch (view.getId()){
            case R.id.st2_button:
                counter_check();
                st2_exit_password[counter] = 1;
                counter++;
                break;
            case R.id.st2_button2:
                counter_check();
                st2_exit_password[counter] = 2;
                counter++;
                break;
            case R.id.st2_button3:
                counter_check();
                st2_exit_password[counter] = 3;
                counter++;
                break;
            case R.id.st2_button4:
                counter_check();
                st2_exit_password[counter] = 4;
                counter++;
                break;
            case R.id.st2_button5:
                counter_check();
                st2_exit_password[counter] = 5;
                counter++;
                break;
            case R.id.st2_button6:
                counter_check();
                st2_exit_password[counter] = 6;
                counter++;
                break;
            case R.id.st2_button7:
                counter_check();
                st2_exit_password[counter] = 7;
                counter++;
                break;
            case R.id.st2_button8:
                counter_check();
                st2_exit_password[counter] = 8;
                counter++;
                break;
            case R.id.st2_button9:
                counter_check();
                st2_exit_password[counter] = 9;
                counter++;
                break;
            case R.id.st2_password_input:
                if(counter != 4){
                    Toast.makeText(this, "암호는 4자리입니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }

                if (st2_exit_password[0] == 1)
                    if (st2_exit_password[1] == 5)
                        if (st2_exit_password[2] == 4)
                            if (st2_exit_password[3] == 8) {
                                st2_answer = true;
                            }

                if(st2_answer == false){
                    Toast.makeText(this, "암호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(this, "암호가 맞았습니다.", Toast.LENGTH_SHORT).show();
                    gv.editor.putBoolean("st2_cleared", true);
                    gv.editor.commit();
                    finish();
                }
                break;
        }
    }//password End
}
