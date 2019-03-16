package com.example.studentportal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.List;

import static com.example.studentportal.MainActivity.VIEW_PORTAL;

public class PortalAdapter extends RecyclerView.Adapter<PortalViewHolder> {
    private List<Portal> mPortals;

    public PortalAdapter(List<Portal> mPortals) {
        this.mPortals = mPortals;
    }

    @NonNull
    @Override
    public PortalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_cell,viewGroup,false);
        return new PortalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PortalViewHolder portalViewHolder, int i) {
        Portal portal = mPortals.get(i);
        portalViewHolder.portalName.setText(portal.getTitle());
    }

    @Override
    public int getItemCount() {
        return mPortals.size();
    }
}