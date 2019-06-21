package com.example.roomescape;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class st2_baseball extends Activity {
    int st2_hun;
    int st2_ten;
    int st2_num;
    int isStrike = 0, isBall = 0;
    String st2_result_string;
    EditText st2_baseball_txt;
    Button st2_baseball_btn;
    ListView listview;

    ArrayList<String> items;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.st2_baseball);


        st2_baseball_btn = (Button)findViewById(R.id.st2_baseball_btn);
        listview = (ListView)findViewById(R.id.st2_baseball_listView);
        gv.st2_baseball_bool = false;
        gv.sf = getSharedPreferences("save_file", MODE_PRIVATE);
        items = new ArrayList<String>();
        items.add("시작합니다.");

        adapter = new ArrayAdapter<String>(st2_baseball.this, android.R.layout.simple_list_item_1, items){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView)view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.WHITE);
                return view;
            }
        };

        listview.setAdapter(adapter);

        st2_hun = (int) (Math.random() * 9) + 1;
        st2_ten = (int) (Math.random() * 9) + 1;
        st2_num = (int) (Math.random() * 9) + 1;

        if(st2_hun == st2_ten || st2_ten == st2_num || st2_hun == st2_num){
            while(st2_hun == st2_ten || st2_ten == st2_num || st2_hun == st2_num) {
                st2_hun = (int) (Math.random() * 9) + 1;
                st2_ten = (int) (Math.random() * 9) + 1;
                st2_num = (int) (Math.random() * 9) + 1;
            }
        }

        gv.st2_baseball_result = st2_hun*100 + st2_ten*10 + st2_num;
        st2_result_string = String.valueOf(gv.st2_baseball_result);

        st2_baseball_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStrike = 0;
                isBall = 0;
                st2_baseball_txt = (EditText)findViewById(R.id.st2_baseball_txt);
                String text = st2_baseball_txt.getText().toString();
                if(!text.isEmpty()){
                    items.add(findResult(text, st2_result_string));
                    st2_baseball_txt.setText("");
                    adapter.notifyDataSetChanged();
                }

                if(isStrike == 3){
                    Toast.makeText(st2_baseball.this, "맞았습니다.", Toast.LENGTH_SHORT).show();
                    gv.editor.putBoolean("st2_tree_soul", true);
                    gv.editor.putBoolean("st2_baseball", true);
                    gv.editor.commit();
                    gv.st2_baseball_bool = true;
                    finish();
                }
            }
        });

    }

    public String findResult(String input, String result){

        char[] inparr = input.toCharArray();
        char[] resarr = result.toCharArray();

        for(int i = 0; i < inparr.length; i++){
            for(int j = 0; j < resarr.length; j++){
                if(inparr[i] == resarr[j]){
                    if (i == j)
                        isStrike++;
                    else
                        isBall++;
                }
            }
        }

        return input.concat("   ".concat(String.valueOf(isStrike).concat("  "
                                 .concat(String.valueOf(isBall)))));
    }


}
