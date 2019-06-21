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

public class st2_clock_puzzle extends Activity {
    Button st2_clock_input_btn;
    EditText st2_clock_input_txt;
    ImageView st2_clock_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.st2_clock_puzzle);

        //객체 할당
        gv.sf = getSharedPreferences("save_file", MODE_PRIVATE);
        st2_clock_input_btn = (Button)findViewById(R.id.st2_clock_btn);
        st2_clock_input_txt = (EditText)findViewById(R.id.st2_clock_txt);
        st2_clock_image = (ImageView)findViewById(R.id.st2_clock_image);
        st2_clock_image.setImageResource(R.drawable.st2_clock);
    }

    //input btn Start
    public void clock_input_click(View v){
        String inputString = st2_clock_input_txt.getText().toString();
        if(inputString.equals("22")){
            //물컵 돌려주고 finish
            gv.st2_clock_bool = true;
            gv.editor.putBoolean("st2_crong_soul", true);
            gv.editor.commit();
            Toast.makeText(this, "맞았습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(this, "틀렸습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }//input btn End
}
