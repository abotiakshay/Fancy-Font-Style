package com.FFLOL.freefirenickname;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.fonts.Font;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static android.os.Build.VERSION_CODES.O;

public class MainActivity extends AppCompatActivity {
    private Spinner homespinner01,homespinner02,homespinnermidddle;
    public DrawerLayout dl;
    public NavigationView nv;
    ArrayList<String> fonts = new ArrayList<String>();
    private ImageView menu_btn,random_number;
    String data1="";
    String left=null,right=null,middel=null;
    private SearchView homeentername;
    recycleradapter recycleradapter1;
    RecyclerView namewithstyle;

    String randomnstyle[]={ "Devil", "The King", "Adam", "Rider", "FreeFire", "Alok", "Raistar", "Sk Sabir Boss", "PUBG", "Dynamo", "Mortal",
                            "GOD", "BOSS", "KING", "Queen", "Angel", "Knight", "Joker",  "Bee", "Sakshi", "Lucia", "LOL", "Ninja", "Marshmello", "Ghost",
                            "Legend", "Predator", "Broken Heart", "Victor", "Sara", "Nicole","Laura", "Michelle", "Paula", "Maria", "Nikki", "Shadow", "Lynx",
                            "Shreya", "Doremon", "Raja", "Jessie", "Nobita", "Sizuka", "Akshay", "Hacker", "Saktiman", "NOOB", "PRO",  "BINOD" , "Killer" , "" };

//    String leftstyle[]= new String[]{
//            "Left","꧁" ,"꧁༺","꧁☬","༒","꧁༒","▄︻┻═┳一","︻╦╤─","︻╦̵̵͇̿̿̿̿══╤─","︻╦̵̵͇̿̿̿̿☆","▄▅▆▇█▓▒░","╚»★«╝","( ͡° ͜ʖ ͡°)","☪","⧭","៚","⎊","⚘","㊜","〖","⫷","❣","❀","◦•●◉✿","༺","☼","｟","ঔৣ","☬","✞","༄ᶦᶰᵈ","🌻","࿇","👑","✔️","༺","💀","۝","乂","°ᴾᴿᴼ°","ᴳᵒᵈ","彡","😈","💉🔪","✵","😎","💥","O.O","🎶","👀","☠","👻","彡","𒆜","☁","✨","爱","≪","⚔️","ツ","🔥","≋","ᴮᴼˢˢ","♔", "♕", "♖", "♗", "♘", "♙", "♚", "♛", "♜", "♝", "♞", "♟", "♤", "♠", "♧", "♣", "♡", "♢", "♦", "★", "☆", "✡", "✦", "✧", "✩", "✪", "✫", "✮", "✰", "⁑", "✣", "✤", "✱", "✲", "✴", "✵", "✸", "✺", "✽", "✼", "✽", "✿", "❀", "❁", "❂", "❃", "❇", "❈", "❉", "❊", "❋", "❆", "❅","⊘"};
//    String rightstyle[]= new String[]{
//            "Right","꧂" ,"༺꧂","☬꧂","༒","༒꧂","一┳═┻︻▄","─╤╦︻","─╤══̵̵͇̿̿̿̿╦︻","☆︻╦̵̵͇̿̿̿̿","░▒▓█▇▆▅","╚»★«╝","( ͡° ͜ʖ ͡°)","☪","⧭","៚","⚘","⎊","㊜","〗","⫸","❣","❀","✿◉●•◦","༺","☼","｠","ঔৣ","☬","✞","࿐","🌻","࿇","👑","✔️","༺","💀","۝","乂","°ᴾᴿᴼ°","ᴳᵒᵈ","彡","😈","💉🔪","✵","😎","💥","O.O","🎶","👀","☠","👻","彡","𒆜","☁","✨","爱","≫","⚔️","ツ","🔥","≋","ᴮᴼˢˢ","♔", "♕", "♖", "♗", "♘", "♙", "♚", "♛", "♜", "♝", "♞", "♟", "♤", "♠", "♧", "♣", "♡", "♢", "♦", "★", "☆", "✡", "✦", "✧", "✩", "✪", "✫", "✮", "✰", "⁑", "✣", "✤", "✱", "✲", "✴", "✵", "✸", "✺", "✽", "✼", "✽", "✿", "❀", "❁", "❂", "❃", "❇", "❈", "❉", "❊", "❋", "❆", "❅","⊘"};

    String leftstyle[] = new String[]{
            "Left", "꧁", "꧁༺", "꧁☬", "꧁༒", "༒࿐៚", "•♫•♬•", "◦•●◉✿", "°•✮•°",

            "࿐", "༺", "☬", "༒", "៚", "⸙", "𓅂", "〆", "々", "⌁", "シ", "ッ", "ツ", "ジ",

            "▄︻┻═┳一", "︻╦╤─", "︻╦̵̵͇̿̿̿̿══╤─", "一┳═┻︻▄", "─╤╦︻", "─╤══̵̵͇̿̿̿̿╦︻", "☆̵̵͇̿̿̿̿╦︻", "╚»★«╝",

            "༄ᶦᶰᵈ", "°ᴾᴿᴼ°", "ᴵᴬᴹ", "ᴳᵒᵈ", "ॐ", "ঔৣ", "☠",

            "彡", "乡","亗", "ꁈ", "☬", "۝", "☣", "֍", "֎", "⊹", "᭄", "° ᭄",

            "ㄔ", "ム", "么", "メ", "乂", "义", "父", "丈", "卍", "𒆜", "𒁂", "ᚏ",

            "♔", "♕", "♖", "♗", "♘", "♙", "♚", "♛", "♜", "♝", "♞", "♟", "♤", "♠", "♧", "♣", "♡", "♢", "♦",

            "༗", "༫", "❣", "✡", "☆", "★", "⍟", "✪", "⚝", "⛤", "⛦", "⛥", "✩", "✫", "✬", "✭", "✮", "✯", "✰", "✦", "✧", "☼",

            "⁑", "✣", "✤", "✱", "✲", "✴", "✵", "✸", "✺", "✽", "✼", "✽", "✿", "❀", "❁", "❂", "❃", "❇", "❈", "❉", "❊", "❋", "❆", "❅","⊘",

            "↯", "⇋", "↽", "↼", "⇁", "⇀", "⇜", "◥", "◤",

            "᚜", "≺", "≼", "⫷", "⌜", "『",  "〖", "【", "〘", "｟", "❲", "◜", "❬", "❮", "❰", "«", "❪", "₍", "⚞",

            "♬", "♪", "☪", "✞", "࿇", "⧭", "⎊", "⚘", "ꋧ", "ꋊ", "⚒", "⚔", "ｯ", "㋛", "㋡", "⍨", "⑆", "⍩", "⍥", "⍤", "⍣", "✔", "✘", "✓", "✗", "✕", "༝", "↺", "↻",

            "𖣘", "𖣇", "𖠄", "𖠌", "𖠋", "𖠍", "𖤍", "𖠃", "𖠔", "𖠚", "𖠺", "𖣨", "𖣠", "𖣥", "𖤛", "𖤠", "𖥂", "⛻", "𒈒", "𒈞", "𒀱", "𒅒", "☄", "🕸", "☢", "☯", "ཌ", "ད", "⚕", "☘", "҉", "⏤͟͟͞͞★", "★͟͟͞͞⏤",

            "( ͡° ͜ʖ ͡°)", "☁",

            "░▒▓", "▓▒░", "█▇▆▅▄▃▂▁", "▁▂▃▄▅▆▇█","║▌║▌║█│▌▌│█║▌║▌║",

            "©", "®", "™",
    };

    String rightstyle[] = new String[]{
            "Right", "꧂", "༺꧂", "☬꧂", "༒꧂", "༒࿐៚", "•♫•♬•", "✿◉●•◦", "°•✮•°",

            "࿐", "༺", "☬", "༒", "៚", "⸙", "𓅂", "〆", "々", "⌁", "シ", "ッ", "ツ", "ジ",

            "一┳═┻︻▄", "─╤╦︻", "─╤══̵̵͇̿̿̿̿╦︻", "☆̵̵͇̿̿̿̿╦︻", "▄︻┻═┳一", "︻╦╤─", "︻╦̵̵͇̿̿̿̿══╤─", "╚»★«╝",

            "༄ᶦᶰᵈ", "°ᴾᴿᴼ°", "ᴵᴬᴹ", "ᴳᵒᵈ", "ॐ", "ঔৣ", "☠",

            "彡", "乡","亗", "ꁈ", "☬", "۝", "☣", "֍", "֎", "⊹", "᭄", "° ᭄",

            "ㄔ", "ム", "么", "メ", "乂", "义", "父", "丈", "卍", "𒆜", "𒁂", "ᚏ",

            "♔", "♕", "♖", "♗", "♘", "♙", "♚", "♛", "♜", "♝", "♞", "♟", "♤", "♠", "♧", "♣", "♡", "♢", "♦",

            "༗", "༫", "❣", "✡", "☆", "★", "⍟", "✪", "⚝", "⛤", "⛦", "⛥", "✩", "✫", "✬", "✭", "✮", "✯", "✰", "✦", "✧", "☼",

            "⁑", "✣", "✤", "✱", "✲", "✴", "✵", "✸", "✺", "✽", "✼", "✽", "✿", "❀", "❁", "❂", "❃", "❇", "❈", "❉", "❊", "❋", "❆", "❅","⊘",

            "↯", "⇋", "↽", "↼", "⇁", "⇀","⇝", "◥", "◤",

            "᚛", "≻", "≽", "⫸", "⌟", "』", "〗", "】", "〙", "｠", "❳", "◞", "❱", "❯", "❭", "»", "❫", "₎", "⚟",

            "♬", "♪", "☪", "✞", "࿇", "⧭", "⎊", "⚘", "ꋧ", "ꋊ", "⚒", "⚔", "ｯ", "㋛", "㋡", "⍨", "⑆", "⍩", "⍥", "⍤", "⍣", "✔", "✘", "✓", "✗", "✕", "༝", "↺", "↻",

            "𖣘", "𖣇", "𖠄", "𖠌", "𖠋", "𖠍", "𖤍", "𖠃", "𖠔", "𖠚", "𖠺", "𖣨", "𖣠", "𖣥", "𖤛", "𖤠", "𖥂", "⛻", "𒈒", "𒈞", "𒀱", "𒅒", "☄", "🕸", "☢", "☯", "ཌ", "ད", "⚕", "☘", "҉", "★͟͟͞͞⏤", "⏤͟͟͞͞★",

            "( ͡° ͜ʖ ͡°)", "☁",

            "░▒▓", "▓▒░", "█▇▆▅▄▃▂▁", "▁▂▃▄▅▆▇█","║▌║▌║█│▌▌│█║▌║▌║",

            "©", "®", "™",
    };
    String middlestyle[] = new String[]{

            "", "꧁", "꧂", "༒࿐៚", "•♫•♬•", "◦•●◉✿", "°•✮•°", "༺",

            "☬", "༒", "៚", "⸙", "𓅂", "〆", "々", "⌁", "シ", "ッ", "ツ", "ジ",

            "▄︻┻═┳一", "︻╦╤─", "︻╦̵̵͇̿̿̿̿══╤─", "︻╦̵̵͇̿̿̿̿☆", "╚»★«╝",

            "༄ᶦᶰᵈ", "°ᴾᴿᴼ°", "ᴳᵒᵈ", "ᴵᴬᴹ", "ॐ", "ঔৣ", "☠",

            "彡", "乡","亗", "ꁈ", "☬", "۝", "☣", "֍", "֎", "⊹", "᭄", "° ᭄",

            "ㄔ", "ム", "么", "メ", "乂", "义", "父", "丈", "卍", "𒆜", "𒁂",  "ᚏ",

            "♔", "♕", "♖", "♗", "♘", "♙", "♚", "♛", "♜", "♝", "♞", "♟", "♤", "♠", "♧", "♣", "♡", "♢", "♦",

            "༗", "༫", "❣", "✡", "☆", "★", "⍟", "✪", "⚝", "⛤", "⛦", "⛥", "✩", "✫", "✬", "✭", "✮", "✯", "✰", "✦", "✧", "☼",

            "⁑", "✣", "✤", "✱", "✲", "✴", "✵", "✸", "✺", "✽", "✼", "✽", "✿", "❀", "❁", "❂", "❃", "❇", "❈", "❉", "❊", "❋", "❆", "❅","⊘",

            "↯", "⇋", "↽", "↼", "⇁", "⇀", "⇝", "⇜", "◥", "◤",

            "᚜", "᚛", "≺", "≻", "≼", "≽", "⫷", "⫸", "⌜", "⌟", "『", "』",  "〖", "〗", "【", "】", "〘", "〙", "☾", "☽", "｟", "｠", "❲", "❳", "◜", "◞", "❬", "❮", "❰", "❱", "❯", "❭", "«", "»", "❪", "❫", "₍", "₎", "⚞", "⚟",

            "♬", "♪", "☪", "✞", "࿇", "⧭", "⎊", "⚘", "ꋧ", "ꋊ", "⚒", "⚔", "ｯ", "㋛", "㋡", "⍨", "⑆", "⍩", "⍥", "⍤", "⍣", "✔", "✘", "✓", "✗", "✕", "༝", "↺", "↻",

            "𖣘", "𖣇", "𖠄", "𖠌", "𖠋", "𖠍", "𖤍", "𖠃", "𖠔", "𖠚", "𖠺", "𖣨", "𖣠", "𖣥", "𖤛", "𖤠", "𖥂", "⛻", "𒈒", "𒈞", "𒀱", "𒅒", "☄", "🕸", "☢", "☯", "ཌ", "ད", "⚕", "☘", "҉", "⏤͟͟͞͞★",

            "( ͡° ͜ʖ ͡°)", "☁",

            "░▒▓", "▓▒░", "█▇▆▅▄▃▂▁", "▁▂▃▄▅▆▇█","║▌║▌║█│▌▌│█║▌║▌║",

            "©", "®", "™",
    };
    String lol[]=new String[]{
             "", "༒","☪","⧭","៚","⎊","⚘","㊜","❣","❀","༺","☼","ঔৣ","☬","✞","༄ᶦᶰᵈ","🌻","࿇","👑","✔️","༺","💀","۝","乂","°ᴾᴿᴼ°","ᴳᵒᵈ","彡","😈","💉🔪","✵","😎","💥","O.O","🎶","👀","☠","👻","彡","𒆜","☁","✨","爱","⚔️","ツ","🔥","≋","ᴮᴼˢˢ","╚»★«╝","♔", "♕", "♖", "♗", "♘", "♙", "♚", "♛", "♜", "♝", "♞", "♟", "♤", "♠", "♧", "♣", "♡", "♢", "♦", "★", "☆", "✡", "✦", "✧", "✩", "✪", "✫", "✮", "✰", "⁑", "✣", "✤", "✱", "✲", "✴", "✵", "✸", "✺", "✽", "✼", "✽", "✿", "❀", "❁", "❂", "❃", "❇", "❈", "❉", "❊", "❋", "❆", "❅","⊘"};

    public void onBackPressed() {   // when back press if drawer window open then close drawer window
        if (dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
//            finish();
//           System.exit(0);

        }

    }




    private void darkmode()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Mypreference", Context.MODE_PRIVATE);

        String dark=sharedPreferences.getString("dark","no");
        if(dark.equals("yes"))
        {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naviagation_menu);
        fonts.clear();
        assignId();
        darkmode();

        // random number
        random_number =  findViewById(R.id.random_name);
        random_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new  Random();
                int rand=random.nextInt(randomnstyle.length -1);
                String randomename=randomnstyle[rand];
                homeentername.setQuery(randomename, true);
            }
        });


        dl=(DrawerLayout) findViewById(R.id.drawer_layout);                       // logic for drawer layout
        nv=(NavigationView) findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        dl.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_theme:
                        Intent i=new Intent(MainActivity.this,Theme.class);
                        startActivity(i);
                        break;
                    case R.id.nav_rateus:
                        Toast.makeText(MainActivity.this,"Redirected on Google Play Store..", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store") ) );
                        break;
                    case R.id.nav_share:
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT,"Coming Soon");
                        startActivity(Intent.createChooser(intent,"Share Via"));
                        break;
                    case R.id.nav_contact_us:

                        String emailsend = "bot.software.404@gmail.com";


                        // define Intent object
                        // with action attribute as ACTION_SEND
                        Intent intent1 = new Intent(Intent.ACTION_SEND);

                        // add three fiels to intent using putExtra function
                        intent1.putExtra(Intent.EXTRA_EMAIL,
                                new String[] { emailsend });


                        // set type of intent
                        intent1.setType("message/rfc822");

                        // startActivity with intent with chooser
                        // as Email client using createChooser function
                        startActivity(
                                Intent
                                        .createChooser(intent1,
                                                "Choose an Email client :"));

                        break;
                    case R.id.nav_help:
                        i=new Intent(MainActivity.this,Help.class);
                        startActivity(i);
                        break;
                    case R.id.nav_privacy_policy:

                        Toast.makeText(MainActivity.this,"Redirected on Privacy Policy Page..", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.freeprivacypolicy.com/live/cf1ea354-fb06-4a84-aa3e-c114826a8beb") ) );
                        break;
                    case R.id.nav_aboutapp:
                        Toast.makeText(MainActivity.this,"Coming Soon...", Toast.LENGTH_SHORT).show();
                        break;
//                        i=new Intent(MainActivity.this,AboutApp.class);
//                        startActivity(i);



                }

                return true;
            }
        });
        menu_btn=findViewById(R.id.menu_btn);
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dl.isDrawerOpen(GravityCompat.START))
                {
                    dl.closeDrawer(GravityCompat.START);
                }
                else{
                    dl.openDrawer(GravityCompat.START);
                }
            }
        });





        ArrayAdapter spinner1 = new ArrayAdapter(MainActivity.this, R.layout.spinner, R.id.textView2, leftstyle);
        ArrayAdapter spinner2 = new ArrayAdapter(MainActivity.this, R.layout.spinner, R.id.textView2, rightstyle);
        ArrayAdapter spinner3 = new ArrayAdapter(MainActivity.this, R.layout.spinner, R.id.textView2, middlestyle);

        homespinner01.setAdapter(spinner1);
        homespinner02.setAdapter(spinner2);
        homespinnermidddle.setAdapter(spinner3);        // assigning initial style to spinner



        namewithstyle.setAdapter(recycleradapter1);

        homespinner01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                left = leftstyle[position];

                fonts.clear();
                String styles[] = customfont(data1, left, right,middel);
                fonts.addAll(Arrays.asList(styles));


                recycleradapter1 = new recycleradapter(MainActivity.this, fonts);

                namewithstyle.setAdapter(recycleradapter1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        homespinner02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                right = rightstyle[position];

                fonts.clear();
                String styles[] = customfont(data1, left, right,middel);
                fonts.addAll(Arrays.asList(styles));

                recycleradapter1 = new recycleradapter(MainActivity.this, fonts);
                namewithstyle.setAdapter(recycleradapter1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    homespinnermidddle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            middel = middlestyle[position];

            fonts.clear();
            String styles[] = customfont(data1, left, right,middel);
            fonts.addAll(Arrays.asList(styles));

            recycleradapter1 = new recycleradapter(MainActivity.this, fonts);
            namewithstyle.setAdapter(recycleradapter1);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
            // your code here
        }

    });


        namewithstyle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        homeentername.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Log.d("Hmmm2", query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                Log.d("Hmmm", newText);
                data1 = newText;
                fonts.clear();

                String styles[] = customfont(newText, left, right,middel);
                fonts.addAll(Arrays.asList(styles));

                recycleradapter1 = new recycleradapter(MainActivity.this, fonts);
                namewithstyle.setAdapter(recycleradapter1);
                return true;
            }
        });



    }


    final String[][] customStyleArr = {

            {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0"},


            {"Ⓐ","Ⓑ","Ⓒ","Ⓓ","Ⓔ","Ⓕ","Ⓖ","Ⓗ","Ⓘ","Ⓙ","Ⓚ","Ⓛ","Ⓜ","Ⓝ","Ⓞ","Ⓟ","Ⓠ","Ⓡ","Ⓢ","Ⓣ","Ⓤ","Ⓥ","Ⓦ","Ⓧ","Ⓨ","Ⓩ","ⓐ","ⓑ","ⓒ","ⓓ","ⓔ","ⓕ","ⓖ","ⓗ","ⓘ","ⓙ","ⓚ","ⓛ","ⓜ","ⓝ","ⓞ","ⓟ","ⓠ","ⓡ","ⓢ","ⓣ","ⓤ","ⓥ","ⓦ","ⓧ","ⓨ","ⓩ","1","2","3","4","5","6","7","8","9","0"},
            {"🅐","🅑","🅒","🅓","🅔","🅕","🅖","🅗","🅘","🅙","🅚","🅛","🅜","🅝","🅞","🅟","🅠","🅡","🅢","🅣","🅤","🅥","🅦","🅧","🅨","🅩","🅐","🅑","🅒","🅓","🅔","🅕","🅖","🅗","🅘","🅙","🅚","🅛","🅜","🅝","🅞","🅟","🅠","🅡","🅢","🅣","🅤","🅥","🅦","🅧","🅨","🅩","1","2","3","4","5","6","7","8","9","0"},
            {"🄰","🄱","🄲","🄳","🄴","🄵","🄶","🄷","🄸","🄹","🄺","🄻","🄼","🄽","🄾","🄿","🅀","🅁","🅂","🅃","🅄","🅅","🅆","🅇","🅈","🅉","🄰","🄱","🄲","🄳","🄴","🄵","🄶","🄷","🄸","🄹","🄺","🄻","🄼","🄽","🄾","🄿","🅀","🅁","🅂","🅃","🅄","🅅","🅆","🅇","🅈","🅉","1","2","3","4","5","6","7","8","9","0"},
            {"🅰","🅱","🅲","🅳","🅴","🅵","🅶","🅷","🅸","🅹","🅺","🅻","🅼","🅽","🅾","🅿","🆀","🆁","🆂","🆃","🆄","🆅","🆆","🆇","🆈","🆉","🅰","🅱","🅲","🅳","🅴","🅵","🅶","🅷","🅸","🅹","🅺","🅻","🅼","🅽","🅾","🅿","🆀","🆁","🆂","🆃","🆄","🆅","🆆","🆇","🆈","🆉","1","2","3","4","5","6","7","8","9","0"},
            {"🇦 ","🇧 ","🇨 ","🇩 ","🇪 ","🇫 ","🇬 ","🇭 ","🇮 ","🇯 ","🇰 ","🇱 ","🇲 ","🇳 ","🇴 ","🇵 ","🇶 ","🇷 ","🇸 ","🇹 ","🇺 ","🇻 ","🇼 ","🇽 ","🇾 ","🇿 ","🇦 ","🇧 ","🇨 ","🇩 ","🇪 ","🇫 ","🇬 ","🇭 ","🇮 ","🇯 ","🇰 ","🇱 ","🇲 ","🇳 ","🇴 ","🇵 ","🇶 ","🇷 ","🇸 ","🇹 ","🇺 ","🇻 ","🇼 ","🇽 ","🇾 ","🇿 ","1","2","3","4","5","6","7","8","9","0"},
            {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","ᴀ","ʙ","ᴄ","ᴅ","ᴇ","ғ","ɢ","ʜ","ɪ","ᴊ","ᴋ","ʟ","ᴍ","ɴ","ᴏ","ᴘ","ϙ","ʀ","s","ᴛ","ᴜ","ᴠ","ᴡ","x","ʏ","ᴢ","1","2","3","4","5","6","7","8","9","0"},

            {"ᴀ","ʙ","ᴄ","ᴅ","ᴇ","ғ","ɢ","ʜ","ɪ","ᴊ","ᴋ","ʟ","ᴍ","ɴ","ᴏ","ᴘ","ϙ","ʀ","s","ᴛ","ᴜ","ᴠ","ᴡ","x","ʏ","ᴢ","ᴀ","ʙ","ᴄ","ᴅ","ᴇ","ғ","ɢ","ʜ","ɪ","ᴊ","ᴋ","ʟ","ᴍ","ɴ","ᴏ","ᴘ","ϙ","ʀ","s","ᴛ","ᴜ","ᴠ","ᴡ","x","ʏ","ᴢ","1","2","3","4","5","6","7","8","9","0"},
            {"ᵃ","ᵇ","ᶜ","ᵈ","ᵉ","ᶠ","ᵍ","ʰ","ⁱ","ʲ","ᵏ","ˡ","ᵐ","ⁿ","ᵒ","ᵖ","ᵠ","ʳ","ˢ","ᵗ","ᵘ","ᵛ","ʷ","ˣ","ʸ","ᶻ","ᵃ","ᵇ","ᶜ","ᵈ","ᵉ","ᶠ","ᵍ","ʰ","ⁱ","ʲ","ᵏ","ˡ","ᵐ","ⁿ","ᵒ","ᵖ","ᵠ","ʳ","ˢ","ᵗ","ᵘ","ᵛ","ʷ","ˣ","ʸ","ᶻ","1","2","3","4","5","6","7","8","9","0"},
            {"ᴀ","ʙ","ᴄ","ᴅ","ᴇ","ғ","ɢ","ʜ","ɪ","ᴊ","ᴋ","ʟ","ᴍ","ɴ","ᴏ","ᴘ","ϙ","ʀ","s","ᴛ","ᴜ","ᴠ","ᴡ","x","ʏ","ᴢ","ᵃ","ᵇ","ᶜ","ᵈ","ᵉ","ᶠ","ᵍ","ʰ","ⁱ","ʲ","ᵏ","ˡ","ᵐ","ⁿ","ᵒ","ᵖ","ᵠ","ʳ","ˢ","ᵗ","ᵘ","ᵛ","ʷ","ˣ","ʸ","ᶻ","1","2","3","4","5","6","7","8","9","0"},
            {"卂","乃","匚","ᗪ","乇","千","Ꮆ","卄","丨","丿","Ҡ","ㄥ","爪","几","ㄖ","卩","Ɋ","尺","丂","ㄒ","凵","ᐯ","山","乂","ㄚ","乙","卂","乃","匚","ᗪ","乇","千","Ꮆ","卄","丨","丿","Ҡ","ㄥ","爪","几","ㄖ","卩","Ɋ","尺","丂","ㄒ","凵","ᐯ","山","乂","ㄚ","乙","1","2","3","4","5","6","7","8","9","0"},
            {"ﾑ","乃","ζ","Ð","乇","ｷ","g","ん","ﾉ","ﾌ","ズ","ﾚ","ᄊ","刀","Ծ","ｱ","Q","尺","丂","ｲ","Ʋ","Џ","Щ","ﾒ","ﾘ","乙","ﾑ","乃","ζ","Ð","乇","ｷ","g","ん","ﾉ","ﾌ","ズ","ﾚ","ᄊ","刀","Ծ","ｱ","Q","尺","丂","ｲ","Ʋ","Џ","Щ","ﾒ","ﾘ","乙","1","2","3","4","5","6","7","8","9","0"},
            {"Ａ","Ｂ","Ｃ","Ｄ","Ｅ","Ｆ","Ｇ","Ｈ","Ｉ","Ｊ","Ｋ","Ｌ","Ｍ","Ｎ","Ｏ","Ｐ","Ｑ","Ｒ","Ｓ","Ｔ","Ｕ","Ｖ","Ｗ","Ｘ","Ｙ","Ｚ","ａ","ｂ","ｃ","ｄ","ｅ","ｆ","ｇ","ｈ","ｉ","ｊ","ｋ","ｌ","ｍ","ｎ","ｏ","ｐ","ｑ","ｒ","ｓ","ｔ","ｕ","ｖ","ｗ","ｘ","ｙ","ｚ","1","2","3","4","5","6","7","8","9","0"},
            {"₳","Ƀ","€","Ɖ","Ɇ","₣","₲","Ħ","Ɨ","Ɉ","Ԟ","Ⱡ","Ⲙ","₦","Ø","₱","Q̶","Ɍ","$","₮","Ʉ","⩔","₩","Ӿ","¥","Ƶ","₳","Ƀ","€","Ɖ","Ɇ","₣","₲","Ħ","Ɨ","Ɉ","Ԟ","Ⱡ","Ⲙ","₦","Ø","₱","Q̶","Ɍ","$","₮","Ʉ","⩔","₩","Ӿ","¥","Ƶ","1","2","3","4","5","6","7","8","9","0"},
            {"α","ɓ","c","∂","ε","ƒ","ɠ","ɦ","เ","ʝ","ҡ","ℓ","ɱ","ɳ","σ","ρ","φ","ɾ","ร","ƭ","µ","ѵ","ω","א","ყ","ƶ","α","ɓ","c","∂","ε","ƒ","ɠ","ɦ","เ","ʝ","ҡ","ℓ","ɱ","ɳ","σ","ρ","φ","ɾ","ร","ƭ","µ","ѵ","ω","א","ყ","ƶ","1","2","3","4","5","6","7","8","9","0"},
            {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","aͤ","bͣ","cⷦ","dⷡ","eͮ","fͨ","gͮ","hⷡ","iͤ","jͮ","kⷪ","lⷦ","mⷴ","nͦ","oͥ","pⷴ","qͫ","rⷨ","sⷴ","tⷦ","uͮ","vͪ","wⷦ","xͬ","yⷴ","zͯ","1","2","3","4","5","6","7","8","9","0"},



            //10
            {"Թ","Յ","Շ","Ժ","e","Բ","Գ","ɧ","ɿ","ʝ","k","ʅ","ʍ","Ռ","Ծ","ρ","φ","Ր","Տ","Ե","Մ","ע","ա","Ճ","Վ","Հ","Թ","Յ","Շ","Ժ","e","Բ","Գ","ɧ","ɿ","ʝ","k","ʅ","ʍ","Ռ","Ծ","ρ","φ","Ր","Տ","Ե","Մ","ע","ա","Ճ","Վ","Հ","1","2","3","4","5","6","7","8","9","0"},
            {"α","ϐ","ϲ","∂","є","ƒ","g","н","ι","נ","κ","ℓ","м","и","ο","ρ","գ","я","ѕ","τ","υ","ν","ω","ϰ","γ","z","α","ϐ","ϲ","∂","є","ƒ","g","н","ι","נ","κ","ℓ","м","и","ο","ρ","գ","я","ѕ","τ","υ","ν","ω","ϰ","γ","z","1","2","3","4","5","6","7","8","9","0"},
            {"α","ճ","c","ժ","ҽ","բ","ց","հ","í","յ","k","l","ต","ղ","օ","թ","զ","ɾ","s","Ե","մ","ѵ","ա","x","վ","z","α","ճ","c","ժ","ҽ","բ","ց","հ","í","յ","k","l","ต","ղ","օ","թ","զ","ɾ","s","Ե","մ","ѵ","ա","x","վ","z","1","2","3","4","5","6","7","8","9","0"},
//          15  {"0","9","8","7","6","5","4","3","2","1","z","ʎ","x","ʍ","ʌ","n","ʇ","s","ɹ","b","d","o","u","ɯ","l","ʞ","ɾ","ᴉ","ɥ","ƃ","ɟ","ǝ","p","ɔ","q","ɐ","Z","ʎ","X","M","Λ","ᑎ","⊥","S","Ꞟ","Ό","Ԁ","O","N","ꟽ","Ꞁ","Ʞ","ſ","I","H","⅁","Ⅎ","Ǝ","ᗭ","Ͻ","ᗺ","∀"},

            {"♬","ᖲ","¢","ᖱ","៩","⨏","❡","Ϧ","ɨ","ɉ","ƙ","ɭ","៣","⩎","០","ᖰ","ᖳ","Ʀ","ន","Ƭ","⩏","⩔","Ɯ","✗","ƴ","Ȥ","♬","ᖲ","¢","ᖱ","៩","⨏","❡","Ϧ","ɨ","ɉ","ƙ","ɭ","៣","⩎","០","ᖰ","ᖳ","Ʀ","ន","Ƭ","⩏","⩔","Ɯ","✗","ƴ","Ȥ","1","2","3","4","5","6","7","8","9","0"},
            {"ค","๒","ς","๔","є","Ŧ","ﻮ","ђ","เ","ן","к","l","๓","ภ","๏","ק","ợ","г","ร","t","ย","ש","ฬ","ץ","א","z","ค","๒","ς","๔","є","Ŧ","ﻮ","ђ","เ","ן","к","l","๓","ภ","๏","ק","ợ","г","ร","t","ย","ש","ฬ","ץ","א","z","1","2","3","4","5","6","7","8","9","0"},
            {"Ꭺ","Ᏼ","Ꮯ","Ꭰ","Ꭼ","Ғ","Ꮐ","Ꮋ","Ꮖ","Ꭻ","Ꮶ","Ꮮ","Ꮇ","Ν","ϴ","Ꮲ","Ϙ","Ꭱ","Տ","Ͳ","Ⴎ","Ꮩ","Ꮤ","Х","Ꮍ","Ꮓ","Ꭺ","Ᏼ","Ꮯ","Ꭰ","Ꭼ","Ғ","Ꮐ","Ꮋ","Ꮖ","Ꭻ","Ꮶ","Ꮮ","Ꮇ","Ν","ϴ","Ꮲ","Ϙ","Ꭱ","Տ","Ͳ","Ⴎ","Ꮩ","Ꮤ","Х","Ꮍ","Ꮓ","1","2","3","4","5","6","7","8","9","0"},
            {"ᗩ","ᗷ","ᑕ","ᗞ","ᗴ","ᖴ","Ꮐ","ᕼ","Ꮖ","ᒍ","Ꮶ","し","ᗰ","ᑎ","ᝪ","ᑭ","ᑫ","ᖇ","ᔑ","Ꭲ","ᑌ","ᐯ","ᗯ","᙭","Ꭹ","Ꮓ","ᗩ","ᗷ","ᑕ","ᗞ","ᗴ","ᖴ","Ꮐ","ᕼ","Ꮖ","ᒍ","Ꮶ","し","ᗰ","ᑎ","ᝪ","ᑭ","ᑫ","ᖇ","ᔑ","Ꭲ","ᑌ","ᐯ","ᗯ","᙭","Ꭹ","Ꮓ","1","2","3","4","5","6","7","8","9","0"},

            //20
            {"ꍏ","ꌃ","ꉓ","ꀸ","ꍟ","ꎇ","ꁅ","ꃅ","ꀤ","ꀭ","ꀘ","꒒","ꎭ","ꈤ","ꂦ","ᖘ","ꆰ","ꋪ","ꌗ","꓄","ꀎ","Ꮙ","ꅏ","ꊼ","ꌩ","ꁴ","ꍏ","ꌃ","ꉓ","ꀸ","ꍟ","ꎇ","ꁅ","ꃅ","ꀤ","ꀭ","ꀘ","꒒","ꎭ","ꈤ","ꂦ","ᖘ","ꆰ","ꋪ","ꌗ","꓄","ꀎ","Ꮙ","ꅏ","ꊼ","ꌩ","ꁴ","1","2","3","4","5","6","7","8","9","0"},
            {"ꋬ","ꃳ","ꉔ","꒯","ꏂ","ꊰ","ꍌ","ꁝ","꒐","꒻","ꀘ","꒒","ꂵ","ꋊ","ꄲ","ꉣ","ꆰ","ꋪ","ꇙ","꓄","꒤","꒦","ꅐ","ꉧ","ꌦ","ꁴ","ꋬ","ꃳ","ꉔ","꒯","ꏂ","ꊰ","ꍌ","ꁝ","꒐","꒻","ꀘ","꒒","ꂵ","ꋊ","ꄲ","ꉣ","ꆰ","ꋪ","ꇙ","꓄","꒤","꒦","ꅐ","ꉧ","ꌦ","ꁴ","1","2","3","4","5","6","7","8","9","0"},
            {"ꋫ","ꃃ","ꏸ","ꁕ","ꍟ","ꄘ","ꁍ","ꑛ","ꂑ","ꀭ","ꀗ","꒒","ꁒ","ꁹ","ꆂ","ꉣ","ꁸ","꒓","ꌚ","꓅","ꐇ","ꏝ","ꅐ","ꇓ","ꐟ","ꁴ","ꋫ","ꃃ","ꏸ","ꁕ","ꍟ","ꄘ","ꁍ","ꑛ","ꂑ","ꀭ","ꀗ","꒒","ꁒ","ꁹ","ꆂ","ꉣ","ꁸ","꒓","ꌚ","꓅","ꐇ","ꏝ","ꅐ","ꇓ","ꐟ","ꁴ","1","2","3","4","5","6","7","8","9","0"},
            {"ꋬ","ꍗ","ꏳ","ꂟ","ꏂ","ꄟ","ꍌ","ꃬ","꒐","꒻","ꀘ","꒒","ꂵ","ꂚ","ꉻ","ꉣ","ꋠ","ꋪ","ꑄ","꓄","ꀎ","꒦","ꅐ","ꉼ","ꐞ","ꑓ","ꋬ","ꍗ","ꏳ","ꂟ","ꏂ","ꄟ","ꍌ","ꃬ","꒐","꒻","ꀘ","꒒","ꂵ","ꂚ","ꉻ","ꉣ","ꋠ","ꋪ","ꑄ","꓄","ꀎ","꒦","ꅐ","ꉼ","ꐞ","ꑓ","1","2","3","4","5","6","7","8","9","0"},

            {"ꁲ","ꃃ","ꇃ","ꂡ","ꏹ","ꄙ","ꁍ","ꀍ","ꀤ","ꀭ","ꈵ","꒒","ꂵ","ꋊ","ꁏ","ꉣ","ꆰ","ꋪ","ꌚ","ꋖ","ꌈ","ꃴ","ꅏ","ꋚ","ꂖ","ꁴ","ꁲ","ꃃ","ꇃ","ꂡ","ꏹ","ꄙ","ꁍ","ꀍ","ꀤ","ꀭ","ꈵ","꒒","ꂵ","ꋊ","ꁏ","ꉣ","ꆰ","ꋪ","ꌚ","ꋖ","ꌈ","ꃴ","ꅏ","ꋚ","ꂖ","ꁴ","1","2","3","4","5","6","7","8","9","0"},
            {"🄐","🄑","🄒","🄓","🄔","🄕","🄖","🄗","🄘","🄙","🄚","🄛","🄜","🄝","🄞","🄟","🄠","🄡","🄢","🄣","🄤","🄥","🄦","🄧","🄨","🄩","⒜","⒝","⒞","⒟","⒠","⒡","⒢","⒣","⒤","⒥","⒦","⒧","⒨","⒩","⒪","⒫","⒬","⒭","⒮","⒯","⒰","⒱","⒲","⒳","⒴","⒵","1","2","3","4","5","6","7","8","9","0"},

            {"Δ","β","Ć","Đ","€","₣","G","Ħ","I","Ĵ","Ҝ","Ł","Μ","Ň","Ø","P","Ω","Ř","Ş","Ŧ","Ữ","V","Ŵ","Ж","¥","Ž","Δ","β","Ć","Đ","€","₣","G","Ħ","I","Ĵ","Ҝ","Ł","Μ","Ň","Ø","P","Ω","Ř","Ş","Ŧ","Ữ","V","Ŵ","Ж","¥","Ž","1","2","3","4","5","6","7","8","9","0"},
            {"∀","q","Ɔ","p","Ǝ","Ⅎ","פ","H","I","ſ","ʞ","˥","W","N","O","Ԁ","Q","ɹ","S","┴","∩","Λ","M","X","⅄","Z","ɐ","q","ɔ","p","ǝ","ɟ","ƃ","ɥ","ᴉ","ɾ","ʞ","l","ɯ","u","o","d","b","ɹ","s","ʇ","n","ʌ","ʍ","x","ʎ","z","Ɩ","ᄅ","Ɛ","ㄣ","ϛ","9","ㄥ","8","6","0",},
            {"A̶","B̶","C̶","D̶","E̶","F̶","G̶","H̶","I̶","J̶","K̶","L̶","M̶","N̶","O̶","P̶","Q̶","R̶","S̶","T̶","U̶","V̶","W̶","X̶","Y̶","Z̶","a̶","b̶","c̶","d̶","e̶","f̶","g̶","h̶","i̶","j̶","k̶","l̶","m̶","n̶","o̶","p̶","q̶","r̶","s̶","t̶","u̶","v̶","w̶","x̶","y̶","z̶","1̶","2̶","3̶","4̶","5̶","6̶","7̶","8̶","9̶","0̶"},
            {"[A̲̲̅","̅B̲̲̅","̅C̲̲̅","̅D̲̲̅","̅E̲̲̅","̅F̲̲̅","̅G̲̲̅","̅H̲̲̅","̅I̲̲̅","̅J̲̲̅","̅K̲̲̅","̅L̲̲̅","̅M̲̲̅","̅N̲̲̅","̅O̲̲̅","̅P̲̲̅","̅Q̲̲̅","̅R̲̲̅","̅S̲̲̅","̅T̲̲̅","̅U̲̲̅","̅V̲̲̅","̅W̲̲̅","̅X̲̲̅","̅Y̲̲̅","̅Z̲̲̅","̅a̲̲̅","̅b̲̲̅","̅c̲̲̅","̅d̲̲̅","̅e̲̲̅","̅f̲̲̅","̅g̲̲̅","̅h̲̲̅","̅i̲̲̅","̅j̲̲̅","̅k̲̲̅","̅l̲̲̅","̅m̲̲̅","̅n̲̲̅","̅o̲̲̅","̅p̲̲̅","̅q̲̲̅","̅r̲̲̅","̅s̲̲̅","̅t̲̲̅","̅u̲̲̅","̅v̲̲̅","̅w̲̲̅","̅x̲̲̅","̅y̲̲̅","̅z̲̲̅","̅1̲̲̅","̅2̲̲̅","̅3̲̲̅","̅4̲̲̅","̅5̲̲̅","̅6̲̲̅","̅7̲̲̅","̅8̲̲̅","̅9̲̲̅","̅0̲̲̅","̅]"},
            {"A̷","B̷","C̷","D̷","E̷","F̷","G̷","H̷","I̷","J̷","K̷","L̷","M̷","N̷","O̷","P̷","Q̷","R̷","S̷","T̷","U̷","V̷","W̷","X̷","Y̷","Z̷","a̷","b̷","c̷","d̷","e̷","f̷","g̷","h̷","i̷","j̷","k̷","l̷","m̷","n̷","o̷","p̷","q̷","r̷","s̷","t̷","u̷","v̷","w̷","x̷","y̷","z̷","1̷","2̷","3̷","4̷","5̷","6̷","7̷","8̷","9̷","0̷"},
            {"🅰","🅱","🌜","🌛","🎗","🎏","🌀","♓","🎐","🎷","🎋","👢","〽️","🎵","⚽","🅿️","🍳","🌱","💲","🌴","⛎","✅","🔱","❎","🍸","💤","ᴀ","ʙ","ᴄ","ᴅ","ᴇ","ғ","ɢ","ʜ","ɪ","ᴊ","ᴋ","ʟ","ᴍ","ɴ","ᴏ","ᴘ","ǫ","ʀ","💲","ᴛ","ᴜ","ᴠ","ᴡ","❎","🍸","💤","1","2","3","4","5","6","7","8","9","0"},
            {"λ","B","₡","Ð","E","₣","G","Ҥ","ł","J","K","Ł","M","₦","Ø","P","Q","Ř","Ş","Ŧ","U","V","₩","X","¥","Z","λ","B","₡","Ð","E","₣","G","Ҥ","ł","J","K","Ł","M","₦","Ø","P","Q","Ř","Ş","Ŧ","U","V","₩","X","¥","Z","1","2","3","4","5","6","7","8","9","0"},
            {"Ã̰","B̰̃","C̰̃","D̰̃","Ḛ̃","F̰̃","G̰̃","H̰̃","Ḭ̃","J̰̃","K̰̃","L̰̃","M̰̃","Ñ̰","Õ̰","P̰̃","Q̰̃","R̰̃","S̰̃","T̰̃","Ṵ̃","Ṽ̰","W̰̃","X̰̃","Ỹ̰","Z̰̃","ã̰","b̰̃","c̰̃","d̰̃","ḛ̃","f̰̃","g̰̃","h̰̃","ḭ̃","j̰̃","k̰̃","l̰̃","m̰̃","ñ̰","õ̰","p̰̃","q̰̃","r̰̃","s̰̃","t̰̃","ṵ̃","ṽ̰","w̰̃","x̰̃","ỹ̰","z̰̃","1̰̃","2̰̃","3̰̃","4̰̃","5̰̃","6̰̃","7̰̃","8̰̃","9̰̃","0̰̃"},
            {"ꪖ","ꪉ","ᨶ","ᦔ","ꫀ","ᠻ","ᦋ","ꫝ","ỉ","᧒","ƙ","ꪶ","ꪑ","᭢","ꪮ","ᩏ","ᧁ","ꪹ","క","ᡶ","ꪊ","ꪜ","᭙","᥊","ꪗ","ɀ","ꪖ","ꪉ","ᨶ","ᦔ","ꫀ","ᠻ","ᦋ","ꫝ","ỉ","᧒","ƙ","ꪶ","ꪑ","᭢","ꪮ","ᩏ","ᧁ","ꪹ","క","ᡶ","ꪊ","ꪜ","᭙","᥊","ꪗ","ɀ","౹","੨","੩","੫","Ƽ","Ϭ","Դ","੪","੧","੦"},
            {"ᗩ","ᗷ","ᑕ","ᗪ","ᕮ","ᖴ","G","ᕼ","I","ᒍ","K","ᒪ","ᗰ","ᑎ","O","ᑭ","ᑫ","ᖇ","S","T","ᑌ","ᐯ","ᗯ","᙭","Y","ᘔ","α","в","c","ɗ","є","f","g","н","ι","נ","к","Ɩ","м","η","σ","ρ","q","я","ѕ","т","υ","ν","ω","x","у","z","౹","੨","੩","੫","Ƽ","Ϭ","Դ","੪","੧","੦"},
//            {"ꍏ","♭","☾","ᕲ","€","Ϝ","❡","♄","♗","♪","ϰ","↳","ᗰ","♫","⊙","ρ","ᵠ","☈","∫","†","☋","✓","ω","⌘","☿","☡","ᴀ","ʙ","ᴄ","ᴅ","ᴇ","ғ","ɢ","ʜ","ɪ","ᴊ","ᴋ","ʟ","ᴍ","ɴ","ᴏ","ᴘ","ǫ","ʀ","∫","ᴛ","ᴜ","ᴠ","ᴡ","⌘","☿","☡","➊","➋","➌","➍","➎","➏","➐","➑","➒","⓪"},
            {"Թ","Յ","Շ","Ժ","e","Բ","Գ","ɧ","ɿ","ʝ","k","ʅ","ʍ","Ռ","Ծ","ρ","φ","Ր","Տ","Ե","Մ","ע","ա","Ճ","Վ","Հ","Թ","Յ","Շ","Ժ","e","Բ","Գ","ɧ","ɿ","ʝ","k","ʅ","ʍ","Ռ","Ծ","ρ","φ","Ր","Տ","Ե","Մ","ע","ա","Ճ","Վ","Հ","1","2","3","4","5","6","7","8","9","0"},
            //107
            {"𝔸","𝔹","ℂ","𝔻","𝔼","𝔽","𝔾","ℍ","𝕀","𝕁","𝕂","𝕃","𝕄","ℕ","𝕆","ℙ","ℚ","ℝ","𝕊","𝕋","𝕌","𝕍","𝕎","𝕏","𝕐","ℤ","𝕒","𝕓","𝕔","𝕕","𝕖","𝕗","𝕘","𝕙","𝕚","𝕛","𝕜","𝕝","𝕞","𝕟","𝕠","𝕡","𝕢","𝕣","𝕤","𝕥","𝕦","𝕧","𝕨","𝕩","𝕪","𝕫","1","2","3","4","5","6","7","8","9","0"},
            {"𝒜","ℬ","𝒞","𝒟","ℰ","ℱ","𝒢","ℋ","ℐ","𝒥","𝒦","ℒ","ℳ","𝒩","𝒪","𝒫","𝒬","ℛ","𝒮","𝒯","𝒰","𝒱","𝒲","𝒳","𝒴","𝒵","𝒶","𝒷","𝒸","𝒹","ℯ","𝒻","ℊ","𝒽","𝒾","𝒿","𝓀","𝓁","𝓂","𝓃","ℴ","𝓅","𝓆","𝓇","𝓈","𝓉","𝓊","𝓋","𝓌","𝓍","𝓎","𝓏","1","2","3","4","5","6","7","8","9","0"},
            {"𝓐","𝓑","𝓒","𝓓","𝓔","𝓕","𝓖","𝓗","𝓘","𝓙","𝓚","𝓛","𝓜","𝓝","𝓞","𝓟","𝓠","𝓡","𝓢","𝓣","𝓤","𝓥","𝓦","𝓧","𝓨","𝓩","𝓪","𝓫","𝓬","𝓭","𝓮","𝓯","𝓰","𝓱","𝓲","𝓳","𝓴","𝓵","𝓶","𝓷","𝓸","𝓹","𝓺","𝓻","𝓼","𝓽","𝓾","𝓿","𝔀","𝔁","𝔂","𝔃","1","2","3","4","5","6","7","8","9","0"},
            {"𝔄","𝔅","ℭ","𝔇","𝔈","𝔉","𝔊","ℌ","ℑ","𝔍","𝔎","𝔏","𝔐","𝔑","𝔒","𝔓","𝔔","ℜ","𝔖","𝔗","𝔘","𝔙","𝔚","𝔛","𝔜","ℨ","𝔞","𝔟","𝔠","𝔡","𝔢","𝔣","𝔤","𝔥","𝔦","𝔧","𝔨","𝔩","𝔪","𝔫","𝔬","𝔭","𝔮","𝔯","𝔰","𝔱","𝔲","𝔳","𝔴","𝔵","𝔶","𝔷","1","2","3","4","5","6","7","8","9","0"},
            {"𝕬","𝕭","𝕮","𝕯","𝕰","𝕱","𝕲","𝕳","𝕴","𝕵","𝕶","𝕷","𝕸","𝕹","𝕺","𝕻","𝕼","𝕽","𝕾","𝕿","𝖀","𝖁","𝖂","𝖃","𝖄","𝖅","𝖆","𝖇","𝖈","𝖉","𝖊","𝖋","𝖌","𝖍","𝖎","𝖏","𝖐","𝖑","𝖒","𝖓","𝖔","𝖕","𝖖","𝖗","𝖘","𝖙","𝖚","𝖛","𝖜","𝖝","𝖞","𝖟","1","2","3","4","5","6","7","8","9","0"},

            {"𝘈","𝘉","𝘊","𝘋","𝘌","𝘍","𝘎","𝘏","𝘐","𝘑","𝘒","𝘓","𝘔","𝘕","𝘖","𝘗","𝘘","𝘙","𝘚","𝘛","𝘜","𝘝","𝘞","𝘟","𝘠","𝘡","𝘢","𝘣","𝘤","𝘥","𝘦","𝘧","𝘨","𝘩","𝘪","𝘫","𝘬","𝘭","𝘮","𝘯","𝘰","𝘱","𝘲","𝘳","𝘴","𝘵","𝘶","𝘷","𝘸","𝘹","𝘺","𝘻","1","2","3","4","5","6","7","8","9","0"},
            {"𝗔","𝗕","𝗖","𝗗","𝗘","𝗙","𝗚","𝗛","𝗜","𝗝","𝗞","𝗟","𝗠","𝗡","𝗢","𝗣","𝗤","𝗥","𝗦","𝗧","𝗨","𝗩","𝗪","𝗫","𝗬","𝗭","𝗮","𝗯","𝗰","𝗱","𝗲","𝗳","𝗴","𝗵","𝗶","𝗷","𝗸","𝗹","𝗺","𝗻","𝗼","𝗽","𝗾","𝗿","𝘀","𝘁","𝘂","𝘃","𝘄","𝘅","𝘆","𝘇","1","2","3","4","5","6","7","8","9","0"},
            {"𝘼","𝘽","𝘾","𝘿","𝙀","𝙁","𝙂","𝙃","𝙄","𝙅","𝙆","𝙇","𝙈","𝙉","𝙊","𝙋","𝙌","𝙍","𝙎","𝙏","𝙐","𝙑","𝙒","𝙓","𝙔","𝙕","𝙖","𝙗","𝙘","𝙙","𝙚","𝙛","𝙜","𝙝","𝙞","𝙟","𝙠","𝙡","𝙢","𝙣","𝙤","𝙥","𝙦","𝙧","𝙨","𝙩","𝙪","𝙫","𝙬","𝙭","𝙮","𝙯","1","2","3","4","5","6","7","8","9","0"},
            {"𝙰","𝙱","𝙲","𝙳","𝙴","𝙵","𝙶","𝙷","𝙸","𝙹","𝙺","𝙻","𝙼","𝙽","𝙾","𝙿","𝚀","𝚁","𝚂","𝚃","𝚄","𝚅","𝚆","𝚇","𝚈","𝚉","𝚊","𝚋","𝚌","𝚍","𝚎","𝚏","𝚐","𝚑","𝚒","𝚓","𝚔","𝚕","𝚖","𝚗","𝚘","𝚙","𝚚","𝚛","𝚜","𝚝","𝚞","𝚟","𝚠","𝚡","𝚢","𝚣","1","2","3","4","5","6","7","8","9","0"},

            {"𝐴","𝐵","𝐶","𝐷","𝐸","𝐹","𝐺","𝐻","𝐼","𝐽","𝐾","𝐿","𝑀","𝑁","𝑂","𝑃","𝑄","𝑅","𝑆","𝑇","𝑈","𝑉","𝑊","𝑋","𝑌","𝑍","𝑎","𝑏","𝑐","𝑑","𝑒","𝑓","𝑔","𝒉","𝑖","𝑗","𝑘","𝑙","𝑚","𝑛","𝑜","𝑝","𝑞","𝑟","𝑠","𝑡","𝑢","𝑣","𝑤","𝑥","𝑦","𝑧","1","2","3","4","5","6","7","8","9","0"},
            {"𝐀","𝐁","𝐂","𝐃","𝐄","𝐅","𝐆","𝐇","𝐈","𝐉","𝐊","𝐋","𝐌","𝐍","𝐎","𝐏","𝐐","𝐑","𝐒","𝐓","𝐔","𝐕","𝐖","𝐗","𝐘","𝐙","𝐚","𝐛","𝐜","𝐝","𝐞","𝐟","𝐠","𝐡","𝐢","𝐣","𝐤","𝐥","𝐦","𝐧","𝐨","𝐩","𝐪","𝐫","𝐬","𝐭","𝐮","𝐯","𝐰","𝐱","𝐲","𝐳","1","2","3","4","5","6","7","8","9","0"},
            {"𝑨","𝑩","𝑪","𝑫","𝑬","𝑭","𝑮","𝑯","𝑰","𝑱","𝑲","𝑳","𝑴","𝑵","𝑶","𝑷","𝑸","𝑹","𝑺","𝑻","𝑼","𝑽","𝑾","𝑿","𝒀","𝒁","𝒂","𝒃","𝒄","𝒅","𝒆","𝒇","𝒈","𝒉","𝒊","𝒋","𝒌","𝒍","𝒎","𝒏","𝒐","𝒑","𝒒","𝒓","𝒔","𝒕","𝒖","𝒗","𝒘","𝒙","𝒚","𝒛","1","2","3","4","5","6","7","8","9","0"},

    };


    public String[] customfont( String data, String left, String right,String middel){

        String styly[]=new String[customStyleArr.length];

        if(data.isEmpty()){
            data = "Fancy Style";
        }

        String JayAkshay[]=new String[customStyleArr.length];
        for(int i=0;i<customStyleArr.length;i++) {
            JayAkshay[i]="";
            for(int l=0;l<data.length();l++) {
                char ch = data.charAt(l);
                if (ch == 'A') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][0];
                } else if (ch == 'B') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][1];
                } else if (ch == 'C') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][2];
                } else if (ch == 'D') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][3];
                } else if (ch == 'E') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][4];
                } else if (ch == 'F') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][5];
                } else if (ch == 'G') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][6];
                } else if (ch == 'H') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][7];
                } else if (ch == 'I') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][8];
                } else if (ch == 'J') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][9];
                } else if (ch == 'K') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][10];
                } else if (ch == 'L') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][11];
                } else if (ch == 'M') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][12];
                } else if (ch == 'N') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][13];
                } else if (ch == 'O') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][14];
                } else if (ch == 'P') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][15];
                } else if (ch == 'Q') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][16];
                } else if (ch == 'R') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][17];
                } else if (ch == 'S') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][18];
                } else if (ch == 'T') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][19];
                } else if (ch == 'U') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][20];
                } else if (ch == 'V') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][21];
                } else if (ch == 'W') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][22];
                } else if (ch == 'X') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][23];
                } else if (ch == 'Y') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][24];
                } else if (ch == 'Z') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][25];
                } else if (ch == 'a') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][26];
                } else if (ch == 'b') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][27];
                } else if (ch == 'c') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][28];
                } else if (ch == 'd') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][29];
                } else if (ch == 'e') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][30];
                } else if (ch == 'f') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][31];
                } else if (ch == 'g') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][32];
                } else if (ch == 'h') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][33];
                } else if (ch == 'i') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][34];
                } else if (ch == 'j') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][35];
                } else if (ch == 'k') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][36];
                } else if (ch == 'l') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][37];
                } else if (ch == 'm') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][38];
                } else if (ch == 'n') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][39];
                } else if (ch == 'o') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][40];
                } else if (ch == 'p') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][41];
                } else if (ch == 'q') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][42];
                } else if (ch == 'r') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][43];
                } else if (ch == 's') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][44];
                } else if (ch == 't') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][45];
                } else if (ch == 'u') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][46];
                } else if (ch == 'v') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][47];
                } else if (ch == 'w') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][48];
                } else if (ch == 'x') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][49];
                } else if (ch == 'y') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][50];
                } else if (ch == 'z') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][51];
                } else if (ch == '1') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][52];
                } else if (ch == '2') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][53];
                } else if (ch == '3') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][54];
                } else if (ch == '4') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][55];
                } else if (ch == '5') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][56];
                } else if (ch == '6') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][57];
                } else if (ch == '7') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][58];
                } else if (ch == '8') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][59];
                } else if (ch == '9') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][60];
                } else if (ch == '0') {
                    JayAkshay[i] = JayAkshay[i] + customStyleArr[i][61];
                } else{
                    JayAkshay[i] =  JayAkshay[i] + data.charAt(l);
                }
            }
        }



        if(middel!=null)
        {
            for(int i=0;i<JayAkshay.length;i++)
            {
                JayAkshay[i]=middel+JayAkshay[i]+middel;
            }
        }
        if(left!=null)
        {
            if (!(left.equals("Left"))){
                for(int i=0;i<JayAkshay.length;i++)
                {
                    JayAkshay[i]=left+JayAkshay[i];
                }
            }
        }

        if(right!=null)
        {
            if (!(right.equals("Right"))){
                for(int i=0;i<JayAkshay.length;i++)
                {
                    JayAkshay[i]=JayAkshay[i]+right;
                }
            }
        }




        for(int i=0;i<styly.length;i++)
        {
            styly[i]=JayAkshay[i];
        }




        return styly;

    }







    private void assignId()
    {
        homespinner01=findViewById(R.id.homespinner01);
        homespinner02= findViewById(R.id.homespinner02);
        homespinnermidddle= findViewById(R.id.homespinnermidddle);
        namewithstyle =(RecyclerView) findViewById(R.id.namewithstyle);
        homeentername=  findViewById(R.id.homeentername);
    }
}