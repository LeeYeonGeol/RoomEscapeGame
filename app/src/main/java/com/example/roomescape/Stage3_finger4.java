package com.example.roomescape;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Stage3_finger4 extends Activity {
    DBHelper dbHelper;
    SQLiteDatabase db;
    private TextView tv_4;
    private Button buttonmainback;
    private Button buttonsaveitary;
    EditText ett;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.stage3_finger4);
        ///DB///
        dbHelper = new DBHelper(this,"Death.db",null,1);
        db = dbHelper.getWritableDatabase();
        dbHelper.onCreate(db);


        tv_4 = (TextView)findViewById(R.id.txt_finger4);
        tv_4.setText("Morte는 어느 나라 말일까..? 하하 여기다 적어보지 않으련?");
        tv_4.setVisibility(View.VISIBLE);

        ett = (EditText) findViewById(R.id.editText5);

        buttonmainback = (Button)findViewById(R.id.fg4_buttonmainback);
        buttonmainback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                finish();
            }
        });

        buttonsaveitary = (Button)findViewById(R.id.fg4_buttonSave);
        buttonsaveitary.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();

                String str="";
                str = ett.getText().toString();

                if (str.equals("이태리어")){

                    values.put("name", str);
                    values.put("age", 4);
                    values.put("address", "5");
                    db.insert("death",null,values);

                    Toast.makeText(Stage3_finger4.this,"아이템 '너의 4번째 손가락' 을 획득하셨습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                    Toast.makeText(Stage3_finger4.this,"답은...가까운 곳에 있다...", Toast.LENGTH_SHORT).show();
            }




        });

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
