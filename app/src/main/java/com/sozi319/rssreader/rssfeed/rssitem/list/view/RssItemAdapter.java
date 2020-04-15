package com.sozi319.rssreader.rssfeed.rssitem.list.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sozi319.rssreader.R;
import com.sozi319.rssreader.rssfeed.rssitem.list.presentation.RssItemUIModel;
import java.util.ArrayList;
import java.util.List;

public class RssItemAdapter extends RecyclerView.Adapter<RssItemAdapter.UserViewHolder> {
    private ArrayList<RssItemUIModel> userList = new ArrayList<>();
    private OnClickRssItem onClickRssItem = userUIModel -> {

    };

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rssitem, parent, false)
        );
    }

    public void setOnClickUserListener(OnClickRssItem onClickRssItem) {
        this.onClickRssItem = onClickRssItem;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        RssItemUIModel rssItem = userList.get(position);
        holder.title.setText(rssItem.getTitle());
        holder.description.setText(rssItem.getDescription());
        holder.itemView.setOnClickListener(view -> onClickRssItem.onClick(userList.get(position)));
        Glide.with(holder.itemView.getContext())
                .load(rssItem.getPhotoUrl())
                .apply(RequestOptions.circleCropTransform()
                        .placeholder(R.drawable.photo_placeholder)
                        .error(R.drawable.photo_placeholder))
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void addUsers(List<RssItemUIModel> rssItem) {
        int lastPosition = getItemCount();
        userList.addAll(rssItem);
        notifyItemRangeInserted(lastPosition, rssItem.size());
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView description;
        ImageView photo;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_textview);
            description = itemView.findViewById(R.id.description_textview);
            photo = itemView.findViewById(R.id.photo_imageview);
        }
    }
}