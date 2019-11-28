package com.example.myclub.Utils;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myclub.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView subtitle;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        this.subtitle = itemView.findViewById(R.id.tv_subtitle);
    }
}
