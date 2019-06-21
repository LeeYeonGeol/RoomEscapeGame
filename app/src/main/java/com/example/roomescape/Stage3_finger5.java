package com.example.roomescape;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Scanner;

import static com.example.roomescape.R.id.txt_3;

public class Stage3_finger5 extends Activity {
    DBHelper dbHelper;
    SQLiteDatabase db;
    EditText et;
    Button buttonSave;
    Button buttonmainback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.stage3_finger5);

        et = (EditText) findViewById(R.id.editTextDeath);

        buttonSave = (Button)findViewById(R.id.buttonSave);

        ////////////////스토리라인///////////////
        gv.is = getResources().openRawResource(R.raw.stage3_finger5_story);
        gv.sc = new Scanner(gv.is, "MS949");

        final TextView txt_3 = (TextView) findViewById(R.id.txt_3) ;
        txt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gv.sc.hasNextLine()) {
                    String st3_story_line = gv.sc.nextLine();
                    txt_3.setText(st3_story_line);
                }
                else
                    txt_3.setVisibility(View.GONE);
            }
        });

        //////DB관련///////

        dbHelper = new DBHelper(this,"Death.db",null,1);
        db = dbHelper.getWritableDatabase();
        dbHelper.onCreate(db);

        buttonSave.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();

                String str="";
                str = et.getText().toString();

                values.put("name", str);
                values.put("age", 5);
                values.put("address", "5");
                db.insert("death",null,values);

                Toast.makeText(Stage3_finger5.this,"아이템 '너의 5번째 손가락' 을 획득하셨습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }



        });

        buttonmainback = (Button)findViewById(R.id.fg5_buttonmainback);
        buttonmainback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                finish();
            }
        });

    }

}
