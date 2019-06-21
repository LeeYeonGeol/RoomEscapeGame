package com.example.roomescape;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class SelectStage extends AppCompatActivity {
    private Button goStage1;
    private Button goStage2;
    private Button goStage3;
    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.select_stage);

        mContext = this;

        gv.sf = getSharedPreferences("save_file",MODE_PRIVATE);
        gv.editor = gv.sf.edit();

        goStage1 = (Button) findViewById(R.id.goStage1);
        goStage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectStage.this, Stage1.class);
                startActivity(intent);
            }
        });
        goStage2 = (Button) findViewById(R.id.goStage2);
        goStage2.setEnabled(false);
        if((boolean)gv.sf.getBoolean("st1_cleared",false)){
            goStage2.setBackgroundResource(R.drawable.stage2_btn);
            goStage2.setEnabled(true);
        }
        goStage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectStage.this, Stage2.class);
                startActivity(intent);
            }
        });
        goStage3 = (Button) findViewById(R.id.goStage3);
        goStage3.setEnabled(false);
        if((boolean)gv.sf.getBoolean("st2_cleared",false)){
            goStage3.setBackgroundResource(R.drawable.stage3_btn);
            goStage3.setEnabled(true);
        }
        goStage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectStage.this, Stage3.class);
                startActivity(intent);
            }
        });
    }
    public void st2_open()
    {
        goStage2 = (Button) findViewById(R.id.goStage2);
        goStage2.setBackgroundResource(R.drawable.stage2_btn);
        goStage2.setEnabled(true);
    }
    public void st3_open()
    {
        goStage3 = (Button) findViewById(R.id.goStage3);
        goStage3.setBackgroundResource(R.drawable.stage3_btn);
        goStage3.setEnabled(true);
    }
}
