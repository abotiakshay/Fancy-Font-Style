package com.FFLOL.freefirenickname;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Theme extends AppCompatActivity {
    at.markushi.ui.CircleButton default_theme ;
    at.markushi.ui.CircleButton theme_purple ;
    at.markushi.ui.CircleButton theme_sky;
    at.markushi.ui.CircleButton theme_pink ;
    Switch theme_dark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        default_theme = findViewById(R.id.theme_default);
        theme_purple = findViewById(R.id.theme_purple);
        theme_sky = findViewById(R.id.theme_sky);
        theme_pink = findViewById(R.id.theme_pink);
        theme_dark= findViewById(R.id.dark_theme);
        SharedPreferences sharedPreferences=getSharedPreferences("Mypreference",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String dark=sharedPreferences.getString("dark","no");
        if(dark.equals("yes"))
        {
            theme_dark.setChecked(true);
        }
        else {
            theme_dark.setChecked(false);
        }


        theme_dark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    editor.putString("dark","yes");
                    editor.commit();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                }
                else{
                    editor.putString("dark","no");
                    editor.commit();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    }
            }
        });




        default_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Theme.this,"Coming soon..",Toast.LENGTH_SHORT).show();
             /*   setTheme(R.style.Theme_FreeFireNickname);
                default_theme.setImageResource(R.drawable.ic_action_tick);
                theme_purple.setImageDrawable(null);
                theme_sky.setImageDrawable(null);
                theme_pink.setImageDrawable(null);*/
            }
        });
        theme_purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Theme.this,"Coming soon..",Toast.LENGTH_SHORT).show();

                /*setTheme(R.style.Purple_theme);
                theme_purple.setImageResource(R.drawable.ic_action_tick);
                default_theme.setImageDrawable(null);
                theme_sky.setImageDrawable(null);
                theme_pink.setImageDrawable(null);*/
            }                                                     // you can continue 200
        });

        theme_sky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Theme.this,"Coming soon..",Toast.LENGTH_SHORT).show();
              /*  setTheme(R.style.Sky_theme);

                theme_sky.setImageResource(R.drawable.ic_action_tick);
                default_theme.setImageDrawable(null);
                theme_purple.setImageDrawable(null);
                theme_pink.setImageDrawable(null);*/
            }
        });
        theme_pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Theme.this,"Coming soon..",Toast.LENGTH_SHORT).show();
               /* setTheme(R.style.Pink_theme);
                theme_pink.setImageResource(R.drawable.ic_action_tick);
                default_theme.setImageDrawable(null);
                theme_purple.setImageDrawable(null);
                theme_sky.setImageDrawable(null);*/
            }
        });



    }
}