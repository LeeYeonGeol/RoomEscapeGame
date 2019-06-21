package com.example.roomescape;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Scanner;

public class Stage2 extends AppCompatActivity {
    Boolean st2_crong_first = false;
    Boolean st2_tree_first_bool = false;
    Boolean st2_tree_second_bool = false;
    Boolean st2_oil_first_bool = false;
    Boolean st2_oil_puzzle_bool = false;
    Boolean st2_bat_first_bool = false;
    Button door_2;
    Button st2_clock;
    Button st2_filewall;
    Button st2_dinosaur;
    Button st2_numberBoard;
    Button st2_bat;
    Button st2_carpet;
    Button st2_tree;
    Button st2_beer;
    Button st2_candle;
    Button st2_oil;
    Button st2_menu;
    TextView txt_2;



    HorizontalScrollView horizontalScrollView;

    //뒤로가기 설정
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, BackPressedPopup.class);
        startActivityForResult(intent, 1);
    }//뒤로가기 끝

    //시작 텍스트 시작
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                gv.cancelBool = data.getBooleanExtra("result", true);
                if(gv.cancelBool == true){
                    gv.cancelBool = false;
                    finish();
                }
            }
        }
    }//시작 텍스트 끝



    //onCreate Start
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage2);
        horizontalScrollView = findViewById(R.id.horizontalScrollView4);
        horizontalScrollView.setHorizontalScrollBarEnabled(true);

        //객체 할당
        gv.is = getResources().openRawResource(R.raw.st2_story);
        gv.sc = new Scanner(gv.is, "MS949");
        st2_filewall = (Button)findViewById(R.id.firewall_2);   //끝
        st2_dinosaur = (Button)findViewById(R.id.crong_2);
        door_2 = (Button)findViewById(R.id.stageDoor_2);        //끝
        txt_2 = (TextView)findViewById(R.id.st2_txt);           //끝
        st2_clock = (Button)findViewById(R.id.clock_2);         //끝
        st2_numberBoard = (Button)findViewById(R.id.numberBoard_2);
        st2_bat = (Button)findViewById(R.id.bat_2);
        st2_carpet = (Button)findViewById(R.id.carpet_2);
        st2_tree = (Button)findViewById(R.id.tree_2);
        st2_beer = (Button)findViewById(R.id.beer_2);
        st2_candle = (Button)findViewById(R.id.candle_2);
        st2_oil = (Button)findViewById(R.id.oil_2);             //끝
        st2_menu = (Button)findViewById(R.id.menuBtn);

        //savefile 할당 start
        gv.sf = getSharedPreferences("save_file", MODE_PRIVATE);
        gv.editor.putBoolean("st2_clock", false);
        gv.editor.putBoolean("st2_baseball", false);
        gv.editor.putBoolean("st2_bat", false);
        gv.editor.putBoolean("st2_bat_soul", false);
        gv.editor.putBoolean("st2_crong_soul", false);
        gv.editor.putBoolean("st2_tree_soul", false);
        gv.editor.commit();
        gv.st2_clock_bool = false;
        gv.st2_oil_bool = false;

        st2_clock.setVisibility(View.GONE);
        st2_numberBoard.setVisibility(View.GONE);
        st2_bat.setVisibility(View.GONE);
        st2_carpet.setVisibility(View.GONE);
        st2_tree.setVisibility(View.GONE);
        st2_beer.setVisibility(View.GONE);
        st2_oil.setVisibility(View.GONE);

        final Intent intent2 = new Intent(this, st2_exit_puzzle.class);

        //item
        gv.itemBoxBtn = (Button)findViewById(R.id.itemBox);
        gv.itemBoxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Stage2.this, ItemBox_st2.class);
                startActivity(it);
            }
        });


        //Story Start
        if ((Boolean) gv.sf.getBoolean("st2_story_read", false)) {
            txt_2.setVisibility(View.GONE);
            gv.is = getResources().openRawResource(R.raw.clear);
            gv.sc = new Scanner(gv.is, "MS949");
        }
        txt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gv.sc.hasNextLine()) {
                    String st2_story_line = gv.sc.nextLine();
                    txt_2.setText(st2_story_line);
                }
                else{
                    gv.editor.putBoolean("st2_story_read",true);
                    gv.editor.commit();
                    txt_2.setVisibility(View.GONE);
                }
            }
        });
        //Story End


        //Menu Start
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
        });//Menu End

        //door_2 Start
        door_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gv.sf.getBoolean("st2_cleared",false) == false){
                    startActivity(intent2);
                }
                else{
                    ((SelectStage)SelectStage.mContext).st3_open();
                    finish();
                }
            }
        });//door_2 End


    }//onCreate End

    //oil Start
    public void oil_start(View v){
        if(st2_oil_puzzle_bool == false) {
            final Intent st2_oil_intent = new Intent(this, st2_oil_puzzle.class);
            startActivity(st2_oil_intent);
        }
        else{

        }
    }//oil End

    //carpet start
    public void carpet_start(View v){
        final Intent st2_number_intent = new Intent(this, st2_carpet_puzzle.class);
        startActivity(st2_number_intent);
    }//carpet End

    //numberBoard start
    public void numberboard_start(View v){
        final Intent st2_number_intent = new Intent(this, st2_number_puzzle.class);
        startActivity(st2_number_intent);
    }//numberBoard end

    //bat Start
    public void bat_start(View v){
        if(st2_bat_first_bool == false){
            gv.is = getResources().openRawResource(R.raw.st2_bat_first);
            gv.sc = new Scanner(gv.is, "MS949");
            txt_2.setVisibility(View.VISIBLE);
            st2_numberBoard.setVisibility(View.VISIBLE);
            if (gv.sc.hasNextLine()) {
                String st2_story_line = gv.sc.nextLine();
                txt_2.setText(st2_story_line);
            } else {
                txt_2.setVisibility(View.GONE);
            }
            st2_bat_first_bool = true;
        }
        else{
            if(gv.sf.getBoolean("st2_bat", false) == false){
                gv.is = getResources().openRawResource(R.raw.st2_bat_second);
                gv.sc = new Scanner(gv.is, "MS949");
                txt_2.setVisibility(View.VISIBLE);
                if (gv.sc.hasNextLine()) {
                    String st2_story_line = gv.sc.nextLine();
                    txt_2.setText(st2_story_line);
                } else {
                    txt_2.setVisibility(View.GONE);
                }
            }
            else{
                gv.is = getResources().openRawResource(R.raw.st2_bat_third);
                gv.sc = new Scanner(gv.is, "MS949");
                txt_2.setVisibility(View.VISIBLE);
                if (gv.sc.hasNextLine()) {
                    String st2_story_line = gv.sc.nextLine();
                    txt_2.setText(st2_story_line);
                } else {
                    txt_2.setVisibility(View.GONE);
                }
                st2_carpet.setVisibility(View.VISIBLE);
                st2_numberBoard.setVisibility(View.INVISIBLE);
            }
        }
    }//bat End

    //tree Start
    public void tree_start(View v){
        if(st2_tree_first_bool == false){
            gv.is = getResources().openRawResource(R.raw.st2_tree_first);
            gv.sc = new Scanner(gv.is, "MS949");
            txt_2.setVisibility(View.VISIBLE);
            if (gv.sc.hasNextLine()) {
                String st2_story_line = gv.sc.nextLine();
                txt_2.setText(st2_story_line);
            } else {
                txt_2.setVisibility(View.GONE);
            }
            st2_tree_first_bool = true;
            st2_tree_second_bool = true;
            st2_oil.setVisibility(View.VISIBLE);
        }
        else {
            if (gv.sf.getBoolean("st2_baseball", false) == false) {
                if (st2_tree_second_bool == true) {
                    gv.is = getResources().openRawResource(R.raw.st2_tree_second);
                    gv.sc = new Scanner(gv.is, "MS949");
                    txt_2.setVisibility(View.VISIBLE);
                    if (gv.sc.hasNextLine()) {
                        String st2_story_line = gv.sc.nextLine();
                        txt_2.setText(st2_story_line);
                    } else {
                        txt_2.setVisibility(View.GONE);
                    }
                }
            } else {
                gv.is = getResources().openRawResource(R.raw.st2_tree_third);
                gv.sc = new Scanner(gv.is, "MS949");
                txt_2.setVisibility(View.VISIBLE);
                if (gv.sc.hasNextLine()) {
                    String st2_story_line = gv.sc.nextLine();
                    txt_2.setText(st2_story_line);
                } else {
                    txt_2.setVisibility(View.GONE);
                }
                st2_bat.setVisibility(View.VISIBLE);
                st2_oil.setVisibility(View.INVISIBLE);
            }
        }
    }//tree End

    //light Start
    public void lightTurn(View v){
        ImageView st2_light = (ImageView)findViewById(R.id.st2_light);

        if(st2_light.getVisibility() == View.VISIBLE){
            st2_light.setVisibility(View.INVISIBLE);
        }
        else if(st2_light.getVisibility() == View.INVISIBLE){
            st2_light.setVisibility(View.VISIBLE);
        }
    }//light End

    //clock Start
    public void clock_click(View v){
        //물컵 받고
        final Intent st2_clock_intent = new Intent(this, st2_clock_puzzle.class);
        startActivity(st2_clock_intent);

    }

    //crong Start
    public void crong_click(View v){
        //if("물컵이 없을 때")
        if(st2_crong_first == false && gv.st2_clock_bool == false) {
            gv.is = getResources().openRawResource(R.raw.st2_crong_no_cup);
            gv.sc = new Scanner(gv.is, "MS949");
            txt_2.setVisibility(View.VISIBLE);
            if (gv.sc.hasNextLine()) {
                String st2_story_line = gv.sc.nextLine();
                txt_2.setText(st2_story_line);
            } else
                txt_2.setVisibility(View.GONE);
            st2_clock.setVisibility(View.VISIBLE);
            st2_crong_first = true;
        }
        else if(st2_crong_first == true && gv.st2_clock_bool == false){
            gv.is = getResources().openRawResource(R.raw.st2_crong_no_cup_2);
            gv.sc = new Scanner(gv.is, "MS949");
            txt_2.setVisibility(View.VISIBLE);
            if(gv.sc.hasNextLine()){
                String st2_story_line = gv.sc.nextLine();
                txt_2.setText(st2_story_line);
            } else
                txt_2.setVisibility(View.GONE);
        }

        //else if("물컵이 있을 떄")
        if(gv.st2_clock_bool == true) {
            st2_tree.setVisibility(View.VISIBLE);
            gv.is = getResources().openRawResource(R.raw.st2_crong_yes_cup);
            gv.sc = new Scanner(gv.is, "MS949");
            txt_2.setVisibility(View.VISIBLE);
            if(gv.sc.hasNextLine()){
                String st2_story_line = gv.sc.nextLine();
                txt_2.setText(st2_story_line);
            } else
                txt_2.setVisibility(View.GONE);
        }



    }//crong End



}//Stage1 End