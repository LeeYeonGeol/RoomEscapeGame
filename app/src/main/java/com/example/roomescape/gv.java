package com.example.roomescape;

import android.app.Application;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class gv extends Application {
    public static Button menuBtn;
    public static Button itemBoxBtn;
    public static Button exitBtn;
    public static LinearLayout menuBar;
    public static TextView tv;
    public static InputStream is;
    public static Scanner sc;
    public static SharedPreferences sf = null;
    public static SharedPreferences.Editor editor = null;
    public static Boolean cancelBool;
    public static Boolean st2_clock_bool;
    public static Boolean st2_oil_bool;
    public static Boolean st2_baseball_bool;
    public static int st2_baseball_result;
    public static int st3_door_result = 0;
    public static int st3_finger5_need = 0;
    public static int st3_finger2_need = 0;
    public static int st3_finger3_need = 0;
    public static int st3_finger3_need2 = 0;
    public static int st3_finger1_need = 0;
    public static SharedPreferences sf3 = null;
    public static SharedPreferences.Editor editor3 = null;

    public static void viewText() {
        gv.sc = new Scanner(gv.is, "MS949");
        String ch = gv.sc.nextLine();
        gv.tv.setText(ch);
        gv.tv.setVisibility(View.VISIBLE);
    }
}
