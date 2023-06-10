package com.FFLOL.freefirenickname;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.Context.CLIPBOARD_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class KeyboardAdapter extends RecyclerView.Adapter<KeyboardAdapter.ViewHolder> {
    Context context;
    private String keyboarddata[];
    private EditText stylishtext;

    public KeyboardAdapter(@NonNull Context context,String keyboarddata[],EditText stylishtext) {

        this.context=context;
        this.keyboarddata=keyboarddata;
        this.stylishtext=stylishtext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.customkeyboard,parent,false);
        ViewHolder style_view=new ViewHolder(v);    // view creation in which data will bind at runtime
        return style_view;




    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.key.setText(keyboarddata[position]);
        holder.key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    int index=stylishtext.getSelectionStart();
                    stylishtext.getEditableText().insert(index,keyboarddata[position]);

            }
        });

    }



    @Override
    public int getItemCount() {
        return keyboarddata.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public Button key;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            key=itemView.findViewById(R.id.key);




        }

    }
}
