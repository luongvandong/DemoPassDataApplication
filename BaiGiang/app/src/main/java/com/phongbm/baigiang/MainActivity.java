package com.phongbm.baigiang;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button btnStartActivity;
    private LevelListDrawable lld;
    private ClipDrawable cd;
    private int level = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnStartActivity = (Button) findViewById(R.id.btn_start_activity);

        btnStartActivity.setOnClickListener(this);

        initializeComponents();
    }

    private void initializeComponents() {
        ImageView imgBattery = (ImageView) findViewById(R.id.img_battery);
        // imgBattery.getBackground(); // background="..."
        AnimationDrawable ad = (AnimationDrawable) imgBattery.getDrawable(); // src="..."
        ad.start();

        ImageView imgAvatar = (ImageView) findViewById(R.id.img_avatar);
        Button btnNextAvatar = (Button) findViewById(R.id.btn_next_avatar);

        // lld = (LevelListDrawable) imgAvatar.getDrawable();
        cd = (ClipDrawable) imgAvatar.getDrawable();
        btnNextAvatar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_next_avatar) {
            /*level++;
            if (level > 2) {
                level = 0;
            }
            lld.setLevel(level);*/

            level += 1000;
            if (level > 10000) {
                level = 0;
            }
            cd.setLevel(level);
        }

        if (v.getId() == R.id.btn_start_activity) {
            User user = new User("t3h", "123456");
            App app = (App) getApplicationContext();
            app.setUser(user);

            Intent intent = new Intent();
            intent.setClass(this, SecondActivity.class);
            startActivity(intent);
        }
    }
    
}