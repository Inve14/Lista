package com.example.listexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactViewHolder>{

    private MainActivityViewModel viewModel;
    private LayoutInflater mInflater;

    RecyclerViewClickListener rvcl;
    public ContactsAdapter(Context context, MainActivityViewModel viewModel, RecyclerViewClickListener rvcl) {
        this.viewModel = viewModel;
        this.mInflater = LayoutInflater.from(context);
        this.rvcl = rvcl;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("CapiamoMeglio", "onCreateViewHolder");
        View view = mInflater.inflate(R.layout.single_row, parent, false);
        return new ContactViewHolder(view, rvcl);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Log.d("CapiamoMeglio", "onBindViewHolder");
        holder.bind(viewModel.getContact(position));

    }

    @Override
    public int getItemCount() {
        return viewModel.getContactsCount();
    }
}
