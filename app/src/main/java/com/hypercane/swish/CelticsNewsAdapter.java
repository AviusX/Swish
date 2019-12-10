package com.hypercane.swish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CelticsNewsAdapter extends ArrayAdapter {

    LayoutInflater layoutInflater;
    private final int layoutResource;
    private List<NewsFeed> newsArticles;

    public CelticsNewsAdapter(@NonNull Context context, int resource, List<NewsFeed> newsArticles) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.newsArticles = newsArticles;
    }

    public int getCount() {
        return newsArticles.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layoutResource, parent, false);
            viewHolder = new CelticsNewsAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        NewsFeed currentArticle = newsArticles.get(position);

        viewHolder.headlineTextView.setText(currentArticle.getTitle());
        viewHolder.descriptionTextView.setText("Click for more information.");
        viewHolder.authorTextView.setText(currentArticle.getAuthor());
        viewHolder.linkTextView.setText((currentArticle.getLink()));

        return convertView;
    }

    private class ViewHolder {
        TextView headlineTextView;
        TextView descriptionTextView;
        TextView authorTextView;
        TextView linkTextView;

        ViewHolder(View v) {
            this.headlineTextView = v.findViewById(R.id.headlineTextView);
            this.descriptionTextView = v.findViewById(R.id.descriptionTextView);
            this.authorTextView = v.findViewById(R.id.authorTextView);
            this.linkTextView = v.findViewById(R.id.linkTextView);
        }
    }
}
