package com.charlezz.interfacestudy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public static final String TAG = MyAdapter.class.getSimpleName();

    private MyItemClickListner listener;

    public void setOnItemClickListener(MyItemClickListner listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);
        final MyViewHolder holder = new MyViewHolder(view);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    listener.onItemClick(holder.getAdapterPosition());
                }
            }
        });

        holder.clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    listener.onClickMeClick(holder.getAdapterPosition());
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(String.format("%d번째 아이템", i));
        myViewHolder.rootView.setBackgroundResource(i%2==0?R.color.bg01:R.color.bg02);

    }

    @Override
    public int getItemCount() {
        return 100;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        Button clickMe;
        TextView textView;
        View rootView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rootView = itemView;
            clickMe = itemView.findViewById(R.id.click_me);
            textView = itemView.findViewById(R.id.text_view);
        }
    }

}
