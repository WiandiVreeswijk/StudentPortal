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

public class PortalAdapter extends RecyclerView.Adapter<PortalAdapter.ViewHolder> {
    private List<Portal> mPortals;
    private MainActivity mMainActivity;
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
        final Portal portalObject = mPortals.get(position);
        holder.mPortalButton.setText(portalObject.getTitle());
        holder.mPortalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "test", Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(PortalAdapter.this, Web_viewer.class);
                intent.putExtra(VIEW_PORTAL, portalObject);
                mMainActivity.startActivityforResult(intent,viewPortalCode);
            }
        });
    }

    @Override
    public PortalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return mPortals.size();
    }
}