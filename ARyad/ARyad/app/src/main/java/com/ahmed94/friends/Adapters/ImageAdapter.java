package com.ahmed94.friends.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmed94.friends.Object.ImageItem;
import com.ahmed94.friends.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ahmed.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context context;
    private List<ImageItem> imageItemList;
    private Typeface hacenAlgeriaHd ;

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView image;

        public ImageViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.item_name);
            image = view.findViewById(R.id.item_image);
        }
    }

    public ImageAdapter(Context context, List<ImageItem> imageItemList) {
        this.context = context;
        this.imageItemList = imageItemList;
        hacenAlgeriaHd = Typeface.createFromAsset(context.getAssets(), "fonts/jokerman_regular.ttf");
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learning_image_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        int pos = position % imageItemList.size();

        ImageItem imageItem = imageItemList.get(pos);
        holder.name.setTypeface(hacenAlgeriaHd);
        holder.name.setText(imageItem.getName());
        Picasso.with(context)
                .load(imageItem.getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}