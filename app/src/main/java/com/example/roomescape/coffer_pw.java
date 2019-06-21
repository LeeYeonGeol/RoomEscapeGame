package com.example.roomescape;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class coffer_pw extends Activity {

    private EditText pwInput;
    private Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.exit_password);
        setContentView(R.layout.coffer_pw);

        gv.sf = getSharedPreferences("save_file",MODE_PRIVATE);
        gv.editor = gv.sf.edit();

        gv.editor.putBoolean("st1_cofferPW", false);

        pwInput = (EditText) findViewById(R.id.pwInput);

        okBtn = (Button) findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pw = pwInput.getText().toString();
                if( pw.equals("guild") ) {
                    gv.editor.putBoolean("st1_cofferPW", true);
                    gv.editor.commit();
                    Toast.makeText(coffer_pw.this, "잠금이 해제되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(coffer_pw.this, "잘못된 암호입니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
}
