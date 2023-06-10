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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.Context.CLIPBOARD_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class recycleradapter extends RecyclerView.Adapter<recycleradapter.ViewHolder> {
     Context context;
    private ClipboardManager myClipboard;
    private ClipData myClip;
    private ArrayList<String> styles_text=new ArrayList<String>();

    public recycleradapter(@NonNull Context context,ArrayList<String> styles_text) {

        this.context=context;
        this.styles_text=styles_text;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.body,parent,false);
        ViewHolder style_view=new ViewHolder(v);    // view creation in which data will bind at runtime
        return style_view;




    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    holder.stylish_name.setText(styles_text.get(position));
    holder.number.setText(position+1+"");
    holder.linear.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(context,AditionalActivity.class);
            i.putExtra("text",holder.stylish_name.getText().toString());
            context.startActivity(i);
        }
    });
    holder.copy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            myClipboard= (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
            myClip = ClipData.newPlainText("text", holder.stylish_name.getText());
            myClipboard.setPrimaryClip(myClip);
            Toast.makeText(context,holder.stylish_name.getText() + " Copied",Toast.LENGTH_SHORT).show();

        }
    });

    }



    @Override
    public int getItemCount() {
        return styles_text.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public Button copy;
        public TextView stylish_name,number;
        public LinearLayout linear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            copy=itemView.findViewById(R.id.copy);
            number=itemView.findViewById(R.id.number);
            stylish_name=itemView.findViewById(R.id.style);            // assign where to bind
            linear=itemView.findViewById(R.id.linear);



        }

    }
}
