package com.example.roomescape;


import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Stage3_window extends Activity {
    TextView tvv;
    MediaPlayer mp;
    private Button buttonmainback;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        DBHelper dbHelper;
        SQLiteDatabase db;

        dbHelper = new DBHelper(this,"Death.db",null,1);
        db = dbHelper.getWritableDatabase();
        dbHelper.onCreate(db);
        mp = MediaPlayer.create(Stage3_window.this,R.raw.trapsound);
        mp.start();



        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.stage3_window);

        db.execSQL("delete from " + "death");

        gv.sf3 = getSharedPreferences("stage3_save_file",MODE_PRIVATE);
        gv.editor3 = gv.sf3.edit();
        gv.editor3.putBoolean("st3_death_note",false);
        gv.editor3.commit();
        gv.editor3.putBoolean("st3_finger1",false);
        gv.editor3.commit();
        gv.editor3.putBoolean("st3_finger3",false);
        gv.editor3.commit();
        gv.editor3.putBoolean("st3_death_annabel",false);
        gv.editor3.commit();
        gv.editor3.putBoolean("st3_wipe",false);
        gv.editor3.commit();
        gv.editor3.putBoolean("st4_start",false);
        gv.editor3.commit();

        gv.st3_finger5_need = 0;
        gv.st3_finger2_need = 0;
        gv.st3_finger3_need = 0;
        gv.st3_finger1_need = 0;
        gv.st3_finger3_need2 = 0;

        tvv = (TextView)findViewById(R.id.txt);
        tvv.setText("도망간 자에게는 축복을... 그렇지 않은 자에게는 재앙을...");
        tvv.setVisibility(View.VISIBLE);
        buttonmainback = (Button)findViewById(R.id.buttonmainback);
        buttonmainback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                mp.stop();
                mp.reset();

                finish();
            }
        });



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

