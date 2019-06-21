package com.example.roomescape;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ItemBox_st2 extends Activity {
    DBHelper dbHelper;
    SQLiteDatabase db;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.itembox_layout);
        gv.sf = getSharedPreferences("save_file", MODE_PRIVATE);

        /* 위젯과 멤버변수 참조 획득 */
        mListView = (ListView)findViewById(R.id.listView);

        /* 아이템 추가 및 어댑터 등록 */
        dataSetting();

        gv.exitBtn = (Button) findViewById(R.id.exitBtn);
        gv.exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void dataSetting(){

        MyAdapter mMyAdapter = new MyAdapter();



        if(gv.sf.getBoolean("st2_crong_soul", false) == true)
            mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.st2_crong_soul), "공룡의 마음", "어딘가에 쓰일 것 같다.");

        if(gv.sf.getBoolean("st2_tree_soul", false) == true)
            mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.st2_tree_soul), "나무의 마음", "어딘가에 쓰일 것 같다.");

        if(gv.sf.getBoolean("st2_bat_soul", false) == true)
            mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.st2_bat_soul), "공룡의 마음", "어딘가에 쓰일 것 같다.");

        //mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.stage3_wipe), "하얀 손수건", "무언가를 닦아내야만 할 것 같다");
        //위와같이 조건 걸어서, 아이템 추가.




        /* 리스트뷰에 어댑터 등록 */
        mListView.setAdapter(mMyAdapter);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()== MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }





}

