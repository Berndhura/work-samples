package com.example.guitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.NameViewHolder> {

    private final LinkedList<String> mNameList;
    private LayoutInflater mInflater;

    public PeopleAdapter(Context context, LinkedList<String> nameList) {
        mInflater = LayoutInflater.from(context);
        this.mNameList = nameList;
    }

    @NonNull
    @Override
    public PeopleAdapter.NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element,
                parent, false);
        return new NameViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleAdapter.NameViewHolder holder, int position) {
        String mCurrent = mNameList.get(position);
        holder.name.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mNameList.size();
    }

    class NameViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    final PeopleAdapter mAdapter;

        public NameViewHolder(@NonNull View itemView, PeopleAdapter adapter) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            this.mAdapter = adapter;
        }
    }
}
