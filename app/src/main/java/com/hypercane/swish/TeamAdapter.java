package com.hypercane.swish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TeamAdapter extends ArrayAdapter {

    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private String[] teamName;
    private int[] teamLogos;

    public TeamAdapter(@NonNull Context context, int resource, String[] teamName, int[] teamLogos) {
        super(context, resource, teamName);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.teamName = teamName;
        this.teamLogos = teamLogos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(layoutResource, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.teamName.setText(teamName[position]);
        viewHolder.teamLogo.setImageResource(teamLogos[position]);

        return convertView;
    }

    private class ViewHolder {
        final TextView teamName;
        final ImageView teamLogo;

        ViewHolder(View v) {
            this.teamName = v.findViewById(R.id.teamName);
            this.teamLogo = v.findViewById(R.id.teamLogo);
        }
    }
}

