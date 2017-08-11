package com.example.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by lama on 8/11/2017 AD.
 */

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {
    Context context;
    List<String> mylist ;

    public myAdapter(Context context, List<String> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        myViewHolder viewHolder = new myViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
    holder.bind(mylist.get(position));
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        String s;

         public myViewHolder(View itemView) {
             super(itemView);

             textView = (TextView) itemView.findViewById(R.id.text);

             itemView.setOnClickListener(this);
         }
         public void bind(String s) {
             this.s = s;
            textView.setText(s);
        }

        @Override
        public void onClick(View v) {
                Toast.makeText(v.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            mylist.remove(s);
            notifyDataSetChanged();
        }
    }




    }



