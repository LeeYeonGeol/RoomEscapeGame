package com.example.roomescape;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.audiofx.DynamicsProcessing;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

import static java.util.logging.Logger.global;


public class Stage3 extends AppCompatActivity {
    TextView txtResult;
    public Button homeBtn;
    private Button Button_1;
    private Button Button_2;
    private Button Button_3;
    private Button Button_death;
    private Button Button_morte;
    private Button Button_deathgreece;
    private Button Button_dood;
    private Button Button_nepal;
    private Button Button_eyes;
    private Button annabel;
    private Button menuBtn;
    private Button Button_finger5;
    private Button Button_finger4;
    private Button Button_finger3;
    private Button Button_finger1;
    private Button Button_wipe;
    DBHelper dbhelper;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.stage3);

        gv.sf3 = getSharedPreferences("stage3_save_file",MODE_PRIVATE);
        gv.editor3 = gv.sf3.edit();

        ////////////////스토리라인///////////////
        gv.is = getResources().openRawResource(R.raw.stage3_main_story);
        gv.sc = new Scanner(gv.is, "MS949");
        gv.tv = (TextView) findViewById(R.id.txt_3) ;
        if ((Boolean) gv.sf.getBoolean("st3_story_read", false)) {
            gv.tv.setVisibility(View.GONE);
            gv.is = getResources().openRawResource(R.raw.clear);
            gv.sc = new Scanner(gv.is, "MS949");
        }
        gv.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gv.sc.hasNextLine()) {
                    String st3_story_line = gv.sc.nextLine();
                    gv.tv.setText(st3_story_line);
                }
                else{
                    gv.editor.putBoolean("st3_story_read",true);
                    gv.editor.commit();
                    gv.tv.setVisibility(View.GONE);
                }
            }
        });

        //Story End

        dbhelper = new DBHelper(this, "Death.db",null,1);
        db = dbhelper.getWritableDatabase();
        dbhelper.onCreate(db);


        Button_1 = (Button)findViewById(R.id.btn1);
        Button_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                gv.tv.setText("정체를 알 수 없는 물체이다.");
                gv.tv.setVisibility(View.VISIBLE);
            }
        });


        Button_2 = (Button)findViewById(R.id.Button_2);
        Button_2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                Cursor cursor = db.rawQuery("SELECT * FROM death",null);
                int val_sum = 0;
                while (cursor.moveToNext()) {

                    String text1 = cursor.getString(0);

                    int val = cursor.getInt(cursor.getColumnIndex("age"));

                    String text2 = cursor.getString(2);

                    gv.st3_door_result += val;
                }


                if (gv.st3_door_result != 21){
                    gv.tv.setText("아이템이 부족하여 나갈 수 없다.");
                    gv.tv.setVisibility(View.VISIBLE);
                    gv.st3_door_result = 0;
                }
                else
                    startActivity(new Intent(Stage3.this, Stage3_door.class));
                gv.st3_door_result = 0;
            }




        });

        Button_3 = (Button)findViewById(R.id.Button_3);
        Button_3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                Intent it = new Intent(Stage3.this,Stage3_window.class);
                startActivity(it);
            }
        });

        ///////////////////////////////////////////////////////
        ///////////뒤에 언어들에 대한 메시지///////////////
        //////////////////////////////////////////////////////
        Button_death = (Button)findViewById(R.id.Button_death);
        Button_death.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.tv.setText("영어로 죽음을 뜻한다.");
                gv.tv.setVisibility(View.VISIBLE);

            }
        });

        Button_deathgreece = (Button)findViewById(R.id.Button_deathgreece);
        Button_deathgreece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.tv.setText("그리스어로 죽음을 뜻한다.");
                gv.tv.setVisibility(View.VISIBLE);
            }
        });

        Button_morte = (Button)findViewById(R.id.Button_morte);
        Button_morte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.tv.setText("이태리어로 죽음을 뜻한다.");
                gv.tv.setVisibility(View.VISIBLE);
            }
        });

        Button_dood = (Button)findViewById(R.id.Button_dood);
        Button_dood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.tv.setText("네덜란드어로 죽음을 뜻한다.");
                gv.tv.setVisibility(View.VISIBLE);
            }
        });

        Button_nepal = (Button)findViewById(R.id.Button_nepal);
        Button_nepal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.tv.setText("네팔어로 죽음을 뜻한다.");
                gv.tv.setVisibility(View.VISIBLE);
            }
        });

        Button_eyes = (Button)findViewById(R.id.Button_eyes);
        Button_eyes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final SoundPool pool;
                pool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
                final int music = pool.load(Stage3.this, R.raw.qrccs,1);
                pool.setOnLoadCompleteListener (new SoundPool.OnLoadCompleteListener() {
                    @Override
                    public void onLoadComplete(SoundPool soundPool, int soundId, int status) {
                        pool.play(music, 1f, 1f, 0, 0, 1f);
                    }
                });
                gv.tv.setText("무슨 소리가 나기 시작한다... \n너무.. 무섭다.");
                gv.tv.setVisibility(View.VISIBLE);

            }
        });

        /////////메뉴관련/////////////////////////////////////
        gv.menuBtn = (Button) findViewById(R.id.menuBtn);
        gv.menuBar = (LinearLayout) findViewById(R.id.menuBar);
        gv.menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gv.menuBar.getVisibility() == View.INVISIBLE )
                    gv.menuBar.setVisibility(View.VISIBLE);
                else
                    gv.menuBar.setVisibility(View.INVISIBLE);
            }
        });
        gv.exitBtn = (Button) findViewById(R.id.exitBtn);
        gv.exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        gv.itemBoxBtn = (Button)findViewById(R.id.itemBox);
        gv.itemBoxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Stage3.this, ItemBox.class);
                startActivity(it);
            }
        });
        //////////////////////////////////////////////
        ///손수건///
        gv.editor3.putBoolean("st3_wipe",false);
        gv.editor3.commit();

        Button_wipe = (Button)findViewById(R.id.Stage3_wipe);
        Button_wipe.setOnClickListener(new OnSingleClickListener() {

            @Override

            public void onSingleClick(View v) {
                if((Boolean)gv.sf3.getBoolean("st3_wipe",true)) {
                    gv.tv.setText("더이상 아무런 일이 일어나지 않는다.");
                    gv.tv.setVisibility(View.VISIBLE);
                }
                else{
                    ContentValues values = new ContentValues();
                    values.put("name", "wipe");
                    values.put("age", 6);
                    values.put("address", "손");
                    db.insert("death",null,values);
                    Toast.makeText(Stage3.this,"아이템 '손수건' 을 획득하셨습니다.", Toast.LENGTH_SHORT).show();
                    gv.editor3.putBoolean("st3_wipe",true);
                    gv.editor3.commit();
                }
            }

        });
        ///////////////////////////////////손가락 스테이지/////////////////////////////////
        //1번째
        gv.editor3.putBoolean("st3_finger1",false);
        gv.editor3.commit();

        Button_finger1 = (Button)findViewById(R.id.Stage3_finger_1);
        Button_finger1.setOnClickListener(new OnSingleClickListener() {

            @Override

            public void onSingleClick(View v) {
                Cursor cursor = db.rawQuery("SELECT * FROM death",null);
                while (cursor.moveToNext()) {

                    String text1 = cursor.getString(0);

                    int val = cursor.getInt(cursor.getColumnIndex("age"));

                    String text2 = cursor.getString(2);
                    if (val == 3){
                        gv.st3_finger1_need += val;
                    }
                }
                if (gv.st3_finger1_need == 3){
                    if((Boolean)gv.sf3.getBoolean("st3_finger1",true)) {
                        gv.tv.setText("더이상 아무런 일이 일어나지 않는다.");
                        gv.tv.setVisibility(View.VISIBLE);
                        gv.st3_finger1_need = 0;
                    }
                    else{
                        ContentValues values = new ContentValues();
                        values.put("name", "finger1");
                        values.put("age", 1);
                        values.put("address", "영화");
                        db.insert("death",null,values);
                        Toast.makeText(Stage3.this,"아이템 '너의 1번째 손가락' 을 획득하셨습니다.", Toast.LENGTH_SHORT).show();
                        gv.editor3.putBoolean("st3_finger1",true);
                        gv.editor3.commit();
                        gv.st3_finger1_need = 0;
                    }
                }
                else{
                    gv.tv.setText("험악한 개다... 뭔가 필요할 것같은데...");
                    gv.tv.setVisibility(View.VISIBLE);
                    gv.st3_finger1_need = 0;
                }


            }

        });
        //3번쨰
        gv.editor3.putBoolean("st3_finger3",false);
        gv.editor3.commit();

        Button_finger3 = (Button)findViewById(R.id.Stage3_finger_3);
        Button_finger3.setOnClickListener(new OnSingleClickListener() {

            @Override

            public void onSingleClick(View v) {
                Cursor cursor = db.rawQuery("SELECT * FROM death",null);
                while (cursor.moveToNext()) {

                    String text1 = cursor.getString(0);

                    int val = cursor.getInt(cursor.getColumnIndex("age"));

                    String text2 = cursor.getString(2);
                    if (val == 2){
                        gv.st3_finger3_need += val;
                    }
                    if (val == 6){
                        gv.st3_finger3_need2 += val;
                    }
                }

                if (gv.st3_finger3_need == 2 && gv.st3_finger3_need2 == 6){
                    if((Boolean)gv.sf3.getBoolean("st3_finger3",true)) {
                        gv.tv.setText("더이상 아무런 일이 일어나지 않는다.");
                        gv.tv.setVisibility(View.VISIBLE);
                        gv.st3_finger3_need = 0;
                        gv.st3_finger3_need2 = 0;
                    }
                    else{
                        ContentValues values = new ContentValues();
                        values.put("name", "finger3");
                        values.put("age", 3);
                        values.put("address", "영화");
                        db.insert("death",null,values);
                        Toast.makeText(Stage3.this,"아이템 '너의 3번째 손가락' 을 획득하셨습니다.", Toast.LENGTH_SHORT).show();
                        gv.editor3.putBoolean("st3_finger3",true);
                        gv.editor3.commit();
                        gv.st3_finger3_need = 0;
                        gv.st3_finger3_need2 = 0;
                    }
                }
                else if (gv.st3_finger3_need == 2 && gv.st3_finger3_need2 != 6) {
                    gv.tv.setText("피를 닦아야 될것만 같은데...");
                    gv.tv.setVisibility(View.VISIBLE);
                    gv.st3_finger3_need = 0;
                    gv.st3_finger3_need2 = 0;
                }
                else if (gv.st3_finger3_need != 2 && gv.st3_finger3_need2 == 6) {
                    gv.tv.setText("아무런 일도 일어나지 않는다. 무언가 필요한 모양이다.");
                    gv.tv.setVisibility(View.VISIBLE);
                    gv.st3_finger3_need = 0;
                    gv.st3_finger3_need2 = 0;
                }
                else{
                    gv.tv.setText("식칼..이걸로 손을 자른건가..? 피가 많이 묻어있다...");
                    gv.tv.setVisibility(View.VISIBLE);
                    gv.st3_finger3_need = 0;
                    gv.st3_finger3_need2 = 0;
                }


            }

        });
        //2번째
        gv.editor3.putBoolean("st3_death_annabel",false);
        gv.editor3.commit();

        annabel = (Button)findViewById(R.id.annabel);
        annabel.setOnClickListener(new OnSingleClickListener() {

            @Override

            public void onSingleClick(View v) {
                Cursor cursor = db.rawQuery("SELECT * FROM death",null);
                while (cursor.moveToNext()) {

                    String text1 = cursor.getString(0);

                    int val = cursor.getInt(cursor.getColumnIndex("age"));

                    String text2 = cursor.getString(2);
                    if (val == 5){
                        gv.st3_finger2_need += val;
                    }
                }
                if (gv.st3_finger2_need == 5){
                    if((Boolean)gv.sf3.getBoolean("st3_death_annabel",true)) {
                        gv.tv.setText("더이상 아무런 일이 일어나지 않는다.");
                        gv.tv.setVisibility(View.VISIBLE);
                        gv.st3_finger2_need = 0;
                    }
                    else{
                        ContentValues values = new ContentValues();
                        values.put("name", "annabel");
                        values.put("age", 2);
                        values.put("address", "영화");
                        db.insert("death",null,values);
                        Toast.makeText(Stage3.this,"아이템 '너의 2번째 손가락' 을 획득하셨습니다.", Toast.LENGTH_SHORT).show();
                        gv.editor3.putBoolean("st3_death_annabel",true);
                        gv.editor3.commit();
                        gv.st3_finger2_need = 0;
                    }
                }
                else{
                    gv.tv.setText("아무런 일도 나지 않는다... 무언가 필요할 듯 한데...");
                    gv.tv.setVisibility(View.VISIBLE);
                    gv.st3_finger5_need = 0;
                }


            }

        });
        ///5번째
        Button_finger5 = (Button)findViewById(R.id.Stage3_finger5);
        gv.editor3.putBoolean("st3_death_note",false);
        gv.editor3.commit();
        Button_finger5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.rawQuery("SELECT * FROM death",null);
                while (cursor.moveToNext()) {

                    String text1 = cursor.getString(0);

                    int val = cursor.getInt(cursor.getColumnIndex("age"));

                    String text2 = cursor.getString(2);
                    if (val == 4){
                        gv.st3_finger5_need += val;
                    }
                }
                if (gv.st3_finger5_need == 4){
                    if((Boolean)gv.sf3.getBoolean("st3_death_note",true)) {
                        gv.tv.setText("더이상 들어갈 수 없다.");
                        gv.tv.setVisibility(View.VISIBLE);
                        gv.st3_finger5_need = 0;
                    }
                    else{
                        Intent it = new Intent(Stage3.this,Stage3_finger5.class);
                        startActivity(it);
                        gv.editor3.putBoolean("st3_death_note",true);
                        gv.editor3.commit();
                        gv.st3_finger5_need = 0;
                    }
                }
                else{
                    gv.tv.setText("아무런 일도 나지 않는다... 무언가 필요할 듯 한데...");
                    gv.tv.setVisibility(View.VISIBLE);
                    gv.st3_finger5_need = 0;
                }

            }
        });
        //4번째
        gv.editor3.putBoolean("st4_start",false);
        gv.editor3.commit();
        Button_finger4 = (Button)findViewById(R.id.Stage3_finger4);
        Button_finger4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if((Boolean)gv.sf3.getBoolean("st4_start",true)) {
                    gv.tv.setText("더이상 들어갈 수 없다.");
                    gv.tv.setVisibility(View.VISIBLE);
                }
                else{
                    startActivity(new Intent(Stage3.this, Stage3_finger4.class));
                    gv.editor3.putBoolean("st4_start",true);
                    gv.editor3.commit();

                }
            }
        });
    }
    //뒤로가기 설정
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, BackPressedPopup.class);
        startActivityForResult(intent, 1);
    }




}
