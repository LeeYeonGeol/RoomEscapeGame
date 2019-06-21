package com.example.roomescape;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class BackPressedPopup extends Activity {
    TextView txtText;
    Button acceptBtn;
    Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.backpressedpopup);

        //UI 객체 생성
        txtText = (TextView)findViewById(R.id.wannaBackTxt);
        acceptBtn = (Button)findViewById(R.id.acceptBack);
        cancelBtn = (Button)findViewById(R.id.cancleBack);

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        txtText.setText("처음으로 돌아가시겠습니까?");

        cancelBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    //확인 버튼 눌렸을 때
    public void mOnClose(View v){
        Intent intent = new Intent();
        intent.putExtra("result", true);
        setResult(RESULT_OK, intent);

        finish();
    }


    //바깥 부분 클릭해도 안 꺼지는 것
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }

        return true;
    }

    //뒤로가기 버튼 비활성화
    @Override
    public void onBackPressed() {
        return;
    }
}
