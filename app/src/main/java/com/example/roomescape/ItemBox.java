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

public class ItemBox extends Activity {
    DBHelper dbHelper;
    SQLiteDatabase db;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.itembox_layout);
        ///DB///

        dbHelper = new DBHelper(this,"Death.db",null,1);
        db = dbHelper.getWritableDatabase();
        dbHelper.onCreate(db);

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



        Cursor cursor = db.rawQuery("SELECT * FROM death",null);
        while (cursor.moveToNext()) {
            String text1 = cursor.getString(cursor.getColumnIndex("name"));

            int val = cursor.getInt(cursor.getColumnIndex("age"));

            String text2 = cursor.getString(2);
            if (val == 6){
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.stage3_wipe), "하얀 손수건", "무언가를 닦아내야만 할 것 같다");
            }

            if (val == 4){
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.finger_4), "너의 4번째 손가락", "문을 열기 위한 4번째 Key");
            }
            if (val == 5){
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.finger_5), "너의 5번째 손가락", "문을 열기 위한 5번째 Key");
            }
            if (val == 1){
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.finger_1), "너의 1번째 손가락", "문을 열기 위한 1번째 Key");
            }
            if (val == 2){
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.finger_2), "너의 2번째 손가락", "문을 열기 위한 2번째 Key");
            }
            if (val == 3){
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.finger_3), "너의 3번째 손가락", "문을 열기 위한 3번째 Key");
            }

        }


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
