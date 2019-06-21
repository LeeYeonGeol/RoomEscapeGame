package com.example.roomescape;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class st2_oil_puzzle extends Activity {
    ImageButton st2_oil_start_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.st2_oil_puzzle);

        //객체 할당
        st2_oil_start_btn = (ImageButton)findViewById(R.id.st2_oil_start);
        st2_oil_start_btn.setImageResource(R.drawable.st2_baseball_start);
        final Intent st2_oil_to_game = new Intent(this, st2_baseball.class);
        st2_oil_start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(st2_oil_to_game);
                finish();
            }
        });

    }
}
