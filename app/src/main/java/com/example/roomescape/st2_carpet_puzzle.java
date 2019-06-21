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

public class st2_carpet_puzzle extends Activity {
    ImageView st2_carpet_image11;
    ImageView st2_carpet_image22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.st2_carpet_puzzle);

        //객체 할당
        st2_carpet_image11 = (ImageView)findViewById(R.id.st2_carpet_image1);
        st2_carpet_image11.setImageResource(R.drawable.st2_numbers);
        st2_carpet_image22 = (ImageView)findViewById(R.id.st2_carpet_image2);
        st2_carpet_image22.setImageResource(R.drawable.st2_number_answer);
        gv.sf = getSharedPreferences("save_file", MODE_PRIVATE);

    }
}
