package com.course.term_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.course.Term_Project.R;

public class MainActivity extends AppCompatActivity {
    Button sl;
    TextView em, tel, loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sl = (Button)findViewById(R.id.button);

        sl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Showlist.class);
                startActivity(intent);
            }
        });

        em = (TextView)findViewById(R.id.sendEmail);

        em.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                sendEmail();
            }
        });

        tel = (TextView)findViewById(R.id.telShop);

        tel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("tel:01023677532"));
                startActivity(intent);
            }
        });

        loc = (TextView)findViewById(R.id.showloc);

        loc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/place/%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C+%ED%95%84%EB%8F%99+%EB%8F%99%EA%B5%AD%EB%8C%80%ED%95%99%EA%B5%90+%EC%8B%A0%EA%B3%B5%ED%95%99%EA%B4%80/@37.558096,126.9960291,17z/data=!3m1!4b1!4m5!3m4!1s0x357ca302befa0c31:0x56e51c74b1946e96!8m2!3d37.5580918!4d126.9982178?hl=ko"));
                startActivity(intent);
            }
        });
    }

    protected void sendEmail() {
        String[] TO = {"327cjm@dongguk.edu"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                "ICE shop 메일 문의");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "문의사항을 적어주세요");
        try {
            startActivity(Intent.createChooser(emailIntent,
                    "이메일 보내기..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(MainActivity.this, "이메일 클라이언트가 없네요.", Toast.LENGTH_SHORT).show();
        }
    }
}