package com.FFLOL.freefirenickname;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.progressindicator.AnimatorDurationScaleProvider;

public class AditionalActivity extends AppCompatActivity {
    private ClipboardManager myClipboard;
    private ClipData myClip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aditional);
        Button copy=findViewById(R.id.copy);
        Button share=findViewById(R.id.share);
//        Button favourite=findViewById(R.id.favourite);   // assignment of id
        EditText stylishtext=(EditText) findViewById(R.id.stylishtext);



        RecyclerView keyboard=(RecyclerView) findViewById(R.id.specialkeyboard);  // recyclerview

       // data to special keyboard
        String keyboarddata[]=
                {

                        "꧁", "꧂", "༒࿐៚", "•♫•♬•", "◦•●◉✿", "°•✮•°", "༺",

                        "☬", "༒", "៚", "⸙", "𓅂", "〆", "々", "⌁", "シ", "ッ", "ツ", "ジ",

                        "▄︻┻═┳一", "︻╦╤─", "︻╦̵̵͇̿̿̿̿══╤─", "︻╦̵̵͇̿̿̿̿☆", "╚»★«╝",

                        "༄ᶦᶰᵈ", "°ᴾᴿᴼ°", "ᴳᵒᵈ", "ᴵᴬᴹ", "ॐ", "ঔৣ", "☠",

                        "彡", "乡","亗", "ꁈ", "☬", "۝", "☣", "֍", "֎", "⊹", "᭄", "° ᭄",

                        "ㄔ", "ム", "么", "メ", "乂", "义", "父", "丈", "卍", "𒆜", "𒁂",  "ᚏ",

                        "♔", "♕", "♖", "♗", "♘", "♙", "♚", "♛", "♜", "♝", "♞", "♟", "♤", "♠", "♧", "♣", "♡", "♢", "♦",

                        "༗", "༫", "❣", "✡", "☆", "★", "⍟", "✪", "⚝", "⛤", "⛦", "⛥", "✩", "✫", "✬", "✭", "✮", "✯", "✰", "✦", "✧", "☼",

                        "⁑", "✣", "✤", "✱", "✲", "✴", "✵", "✸", "✺", "✽", "✼", "✽", "✿", "❀", "❁", "❂", "❃", "❇", "❈", "❉", "❊", "❋", "❆", "❅","⊘",

                        "↯", "⇋", "↽", "↼", "⇁", "⇀","⇝", "⇜", "◥", "◤",

                        "᚜", "᚛", "≺", "≻", "≼", "≽", "⫷", "⫸", "⌜", "⌟", "『", "』",  "〖", "〗", "【", "】", "〘", "〙", "☾", "☽", "｟", "｠", "❲", "❳", "◜", "◞", "❬", "❮", "❰", "❱", "❯", "❭", "«", "»", "❪", "❫", "₍", "₎", "⚞", "⚟",

                        "♬", "♪", "☪", "✞", "࿇", "⧭", "⎊", "⚘", "ꋧ", "ꋊ", "⚒", "⚔", "ｯ", "㋛", "㋡", "⍨", "⑆", "⍩", "⍥", "⍤", "⍣", "✔", "✘", "✓", "✗", "✕", "༝", "↺", "↻",

                        "𖣘", "𖣇", "𖠄", "𖠌", "𖠋", "𖠍", "𖤍", "𖠃", "𖠔", "𖠚", "𖠺", "𖣨", "𖣠", "𖣥", "𖤛", "𖤠", "𖥂", "⛻", "𒈒", "𒈞", "𒀱", "𒅒", "☄", "🕸", "☢", "☯", "ཌ", "ད", "⚕", "☘", "҉", "⏤͟͟͞͞★",

                        "( ͡° ͜ʖ ͡°)", "☁",

                        "░▒▓", "▓▒░", "█▇▆▅▄▃▂▁", "▁▂▃▄▅▆▇█","║▌║▌║█│▌▌│█║▌║▌║",

                        "©", "®", "™",
                };;
        GridLayoutManager layout=new GridLayoutManager(AditionalActivity.this,5);

        keyboard.setLayoutManager(layout);
        stylishtext.setText(getIntent().getStringExtra("text"));
        keyboard.setAdapter(new KeyboardAdapter(AditionalActivity.this,keyboarddata,stylishtext));

        // copy button
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClipboard= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                myClip = ClipData.newPlainText("text", stylishtext.getText());
                myClipboard.setPrimaryClip(myClip);
                Toast.makeText(AditionalActivity.this,stylishtext.getText() + " Copied",Toast.LENGTH_SHORT).show();
            }
        });

        // share button
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,stylishtext.getText().toString());
                startActivity(Intent.createChooser(i,"Share Via"));
            }
        });

        // like button

//        favourite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            Toast.makeText(AditionalActivity.this,stylishtext.getText().toString()+" Added to your Favourite Style",Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
    }
}