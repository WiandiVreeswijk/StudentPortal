package com.example.studentportal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter<PortalAdapter.ViewHolder> {
    private List<Portal> mPortals;

    static class ViewHolder extends RecyclerView.ViewHolder {

        Button mPortalButton;

        ViewHolder(View v) {
            super(v);

            mPortalButton = v.findViewById(R.id.portalButton);

        }

    }

    public PortalAdapter(List<Portal> mPortals) {

        this.mPortals = mPortals;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mPortalButton.setText(position);
    }

    @Override
    public PortalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.support_simple_spinner_dropdown_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public int getItemCount() {
        return mPortals.size();
    }
}