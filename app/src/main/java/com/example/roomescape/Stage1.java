package com.example.roomescape;


import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Scanner;

public class Stage1 extends AppCompatActivity {
    private Button doorBtn;
    private Button mathBtn;
    private Button cofferBtn;
    private Button bookBtn;
    private Button bedBtn;
    private Button carpetBtn;
    private Button sofaBtn;
    private Button drawerBtn;
    private Button posterBtn;
    private Button hintBtn;
    private Button hintImg;
    private LinearLayout st1_background;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.stage1);

        gv.sf = getSharedPreferences("save_file",MODE_PRIVATE);
        gv.editor = gv.sf.edit();

        gv.is = getResources().openRawResource(R.raw.st1_story);
        gv.sc = new Scanner(gv.is, "MS949");

        gv.tv = (TextView) findViewById(R.id.textView1);
        if((Boolean)gv.sf.getBoolean("st1_story_read",false)) {
            gv.tv.setVisibility(View.GONE);
            gv.is = getResources().openRawResource(R.raw.clear);
            gv.sc = new Scanner(gv.is, "MS949");
        }
        gv.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gv.sc.hasNextLine()) {
                    String ch = gv.sc.nextLine();
                    gv.tv.setText(ch);
                } else{
                    gv.editor.putBoolean("st1_story_read",true);
                    gv.editor.commit();
                    gv.tv.setVisibility(View.GONE);
                }
            }
        });

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
        gv.itemBoxBtn = (Button)findViewById(R.id.itemBox);
        gv.itemBoxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Stage1.this, ItemBox_st1.class);
                startActivity(it);
            }
        });

        gv.exitBtn = (Button) findViewById(R.id.exitBtn);
        gv.exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        doorBtn = (Button) findViewById(R.id.doorLock);
        doorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Boolean) gv.sf.getBoolean("st1_cleared",false)){
                    ((SelectStage)SelectStage.mContext).st2_open();
                    finish();
                } else {
                    Intent intent = new Intent(Stage1.this, exit_password.class);
                    startActivity(intent);
                }

            }
        });

        bedBtn = (Button) findViewById(R.id.bed);
        bedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.tv.setText("깔끔한 침대이다. \n설마 침대안에 무언가 들어있진 않겠지...");
                gv.tv.setVisibility(View.VISIBLE);
            }
        });

        carpetBtn = (Button) findViewById(R.id.carpet);
        carpetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.tv.setText("고급스러운 카펫이다. \n밑을 확인해 보았지만 아무것도 없다.");
                gv.tv.setVisibility(View.VISIBLE);
            }
        });

        mathBtn = (Button) findViewById(R.id.numberBoard);
        mathBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.is = getResources().openRawResource(R.raw.st1_number_board);
                gv.viewText();
            }
        });
        sofaBtn = (Button) findViewById(R.id.sofa);
        sofaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.tv.setText("편안해 보이는 소파이다. \n여기 앉아서 책을 읽으면 잠이 잘 올 것 같다.");
                gv.tv.setVisibility(View.VISIBLE);
            }
        });

        bookBtn = (Button) findViewById(R.id.book);
        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gv.sf.getBoolean("st1_memo",false)){
                    gv.tv.setText("메모 이외에는 특별한 것이 없다.");
                    gv.tv.setVisibility(View.VISIBLE);
                }else{
                    gv.editor.putBoolean("st1_memo", true);
                    gv.editor.commit();
                    gv.is = getResources().openRawResource(R.raw.st1_memo);
                    gv.viewText();
                }
            }
        });

        cofferBtn = (Button) findViewById(R.id.coffer);
        cofferBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gv.sf.getBoolean("st1_knife",false)){
                    gv.tv.setText("커터칼 이외에는 아무 것도 없다.");
                    gv.tv.setVisibility(View.VISIBLE);
                }
                else if((Boolean) gv.sf.getBoolean("st1_cofferPW",false))
                {
                    gv.editor.putBoolean("st1_knife",true);
                    gv.editor.commit();
                    gv.tv.setText("상자가 열렸다.\n안에서 커터칼을 발견했다.");
                    gv.tv.setVisibility(View.VISIBLE);
                }
                else {
                    Intent intent = new Intent(Stage1.this, coffer_pw.class);
                    startActivity(intent);
                }
            }
        });

        drawerBtn = (Button) findViewById(R.id.drawer);
        drawerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.tv.setText("서랍 안에는 아무것도 없다.\n다른 곳을 찾아보자.");
                gv.tv.setVisibility(View.VISIBLE);
            }
        });
        hintBtn = (Button) findViewById(R.id.hint);
        hintImg = (Button) findViewById(R.id.hintImg);
        hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintImg.setVisibility(View.VISIBLE);
            }
        });
        hintImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintImg.setVisibility(View.INVISIBLE);
            }
        });
        posterBtn = (Button) findViewById(R.id.poster);
        st1_background = (LinearLayout) findViewById(R.id.st1_background);
        if((Boolean) gv.sf.getBoolean("st1_hint_open",false)){
            st1_background.setBackgroundResource(R.drawable.stage1_1);
            hintBtn.setVisibility(View.VISIBLE);
        }
        posterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Boolean) gv.sf.getBoolean("st1_knife",false))
                {
                    st1_background.setBackgroundResource(R.drawable.stage1_1);
                    hintBtn.setVisibility(View.VISIBLE);
                    gv.editor.putBoolean("st1_hint_open",true);
                    gv.editor.commit();
                    gv.tv.setText("포스터 뒤에서 메모를 발견하였다.");
                    gv.tv.setVisibility(View.VISIBLE);
                }
                else {
                    gv.tv.setText("두꺼운 포스터이다.\n손으로는 떼어지지 않을 것 같다.");
                    gv.tv.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}