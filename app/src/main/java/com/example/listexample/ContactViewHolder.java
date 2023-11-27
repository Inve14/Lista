package com.example.listexample;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder{

    private TextView contactNameTextView;
    private String previousText = "";

    private MainActivity mainActivity;
    public ContactViewHolder(@NonNull View itemView, RecyclerViewClickListener rvcl) {
        super(itemView);
        this.mainActivity = mainActivity;
        contactNameTextView = itemView.findViewById(R.id.contactTextView);
        itemView.setOnClickListener(v -> {
            rvcl.onItemClicked(getAdapterPosition());
        }
        );
    }

    public void bind(String contact) {
        previousText = contact;
        contactNameTextView.setText(contact);
    }
}
