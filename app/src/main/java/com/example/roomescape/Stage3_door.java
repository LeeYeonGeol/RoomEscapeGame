package com.example.roomescape;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class Stage3_door extends Activity {
    MediaPlayer mp;
    DBHelper dbHelper;
    SQLiteDatabase db;
    private Button endBtn;
    private Button searchBtn;
    private Button deleteBtn;
    private Button fingerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.stage3_door);

        ///DB///

        dbHelper = new DBHelper(this,"Death.db",null,1);
        db = dbHelper.getWritableDatabase();
        dbHelper.onCreate(db);


        ////////////////스토리라인///////////////
        gv.is = getResources().openRawResource(R.raw.ending);
        gv.sc = new Scanner(gv.is, "MS949");
        gv.tv = (TextView) findViewById(R.id.txt_door) ;
        gv.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gv.sc.hasNextLine()) {
                    String st3_story_line = gv.sc.nextLine();
                    gv.tv.setText(st3_story_line);
                }
                else
                    gv.tv.setVisibility(View.GONE);
            }
        });

        //Story End

        mp = MediaPlayer.create(Stage3_door.this,R.raw.ending_song);
        mp.start();



    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // MediaPlayer 해지
        if (mp != null) {
            mp.release();
            mp = null;
        }

    }
}