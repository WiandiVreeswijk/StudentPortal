package com.example.studentportal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PortalViewHolder extends RecyclerView.ViewHolder {
    public TextView portalName;
    public View view;

    public PortalViewHolder(@NonNull View itemView) {
        super(itemView);
        portalName = itemView.findViewById(R.id.portalText);
        view = itemView;
    }
}
