package com.example.meteo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {



    private TextView desc1Text;
    private TextView desc2Text;
    private TextView desc3Text;
    private TextView desc4Text;
    private TextView desc5Text;
    private TextView desc6Text;
    private TextView desc7Text;
    private TextView desc8Text;
    private TextView desc9Text;
    private TextView desc10Text;
    private TextView desc11Text;
    private TextView desc12Text;
    private TextView desc13Text;
    private TextView desc14Text;
    private TextView desc15Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        desc1Text = findViewById(R.id.desc1_text);
        desc2Text = findViewById(R.id.desc2_text);
        desc3Text = findViewById(R.id.desc3_text);
        desc4Text = findViewById(R.id.desc4_text);
        desc5Text = findViewById(R.id.desc5_text);
        desc6Text = findViewById(R.id.desc6_text);
        desc7Text = findViewById(R.id.desc7_text);
        desc8Text = findViewById(R.id.desc8_text);
        desc9Text = findViewById(R.id.desc9_text);
        desc10Text = findViewById(R.id.desc10_text);
        desc11Text = findViewById(R.id.desc11_text);
        desc12Text = findViewById(R.id.desc12_text);
        desc13Text = findViewById(R.id.desc13_text);
        desc14Text = findViewById(R.id.desc14_text);
        desc15Text = findViewById(R.id.desc15_text);

        String desc1 = getIntent().getStringExtra("DESCRIPTION1");
        desc1Text.setText(desc1);
        String desc2 = getIntent().getStringExtra("DESCRIPTION2");
        desc2Text.setText(desc2);
        String desc3 = getIntent().getStringExtra("DESCRIPTION3");
        desc3Text.setText(desc3);
        String desc4 = getIntent().getStringExtra("DESCRIPTION4");
        desc4Text.setText(desc4);
        String desc5 = getIntent().getStringExtra("DESCRIPTION5");
        desc5Text.setText(desc5);
        String desc6 = getIntent().getStringExtra("DESCRIPTION6");
        desc6Text.setText(desc6);
        String desc7 = getIntent().getStringExtra("DESCRIPTION7");
        desc7Text.setText(desc7);
        String desc8 = getIntent().getStringExtra("DESCRIPTION8");
        desc8Text.setText(desc8);
        String desc9 = getIntent().getStringExtra("DESCRIPTION9");
        desc9Text.setText(desc9);
        String desc10 = getIntent().getStringExtra("DESCRIPTION10");
        desc10Text.setText(desc10);
        String desc11 = getIntent().getStringExtra("DESCRIPTION11");
        desc11Text.setText(desc11);
        String desc12 = getIntent().getStringExtra("DESCRIPTION12");
        desc12Text.setText(desc12);
        String desc13 = getIntent().getStringExtra("DESCRIPTION13");
        desc13Text.setText(desc13);
        String desc14 = getIntent().getStringExtra("DESCRIPTION14");
        desc14Text.setText(desc14);
        String desc15 = getIntent().getStringExtra("DESCRIPTION15");
        desc15Text.setText(desc15);
    }
}