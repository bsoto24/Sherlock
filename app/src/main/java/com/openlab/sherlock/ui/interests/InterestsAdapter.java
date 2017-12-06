package com.openlab.sherlock.ui.interests;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.openlab.sherlock.R;
import com.openlab.sherlock.data.entity.Interest;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Bryam Soto on 06/12/2017.
 */

public class InterestsAdapter extends RecyclerView.Adapter<InterestsAdapter.InterestVH> {

    private List<Interest> interests;
    private Activity activity;

    public InterestsAdapter(List<Interest> interests, Activity activity) {
        this.interests = interests;
        this.activity = activity;
    }

    @Override
    public InterestVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new InterestVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_interest, parent, false));
    }

    @Override
    public void onBindViewHolder(final InterestVH holder, int position) {
        final Interest interest = interests.get(position);

        holder.tvName.setText(interest.getName());
        Picasso.with(activity).load(interest.getImage()).into(holder.imgInterest);

        if (interest.isSelected()) {
            holder.imgCheck.setVisibility(View.VISIBLE);
            holder.tvName.setBackgroundColor(ContextCompat.getColor(activity, R.color.interest_selected));
        } else {
            holder.imgCheck.setVisibility(View.GONE);
            holder.tvName.setBackgroundColor(ContextCompat.getColor(activity, R.color.interest_unselected));
        }

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interest.isSelected()) {
                    holder.imgCheck.setVisibility(View.GONE);
                    holder.tvName.setBackgroundColor(ContextCompat.getColor(activity, R.color.interest_unselected));
                    interest.setSelected(false);
                } else {
                    holder.imgCheck.setVisibility(View.VISIBLE);
                    holder.tvName.setBackgroundColor(ContextCompat.getColor(activity, R.color.interest_selected));
                    interest.setSelected(true);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return interests.size();
    }

    public static class InterestVH extends RecyclerView.ViewHolder {

        TextView tvName;
        ImageView imgInterest, imgCheck;

        public InterestVH(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            imgInterest = itemView.findViewById(R.id.img_interest);
            imgCheck = itemView.findViewById(R.id.img_check);

        }
    }

}
