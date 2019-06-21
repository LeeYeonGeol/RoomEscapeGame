package com.example.roomescape;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class st2_number_puzzle extends Activity {
    Button st2_number_input_btn;
    EditText st2_number_input_txt;
    ImageView st2_number_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.st2_number_puzzle);

        //객체 할당
        st2_number_input_btn = (Button)findViewById(R.id.st2_number_btn);
        st2_number_input_txt = (EditText)findViewById(R.id.st2_number_txt);
        st2_number_image = (ImageView)findViewById(R.id.st2_number_image);
        st2_number_image.setImageResource(R.drawable.st2_numberboard);
        gv.sf = getSharedPreferences("save_file", MODE_PRIVATE);

    }

    //input btn Start
    public void clock_input_click(View v){
        String inputString = st2_number_input_txt.getText().toString();
        if(inputString.equals("16")){
            gv.editor.putBoolean("st2_bat", true);
            gv.editor.putBoolean("st2_bat_soul", true);
            gv.editor.commit();
            gv.st2_clock_bool = true;

            Toast.makeText(this, "맞았습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(this, "틀렸습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }//input btn End
}