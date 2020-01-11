package com.example.android.footballteam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TeamAdpter extends RecyclerView.Adapter<TeamAdpter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namaTeam.setText(getListTeam().get(position).namaTeam);
        holder.deskripsi.setText(getListTeam().get(position).deskripsiTeam);

        Glide.with(context)
                .load(getListTeam().get(position).logoTeam)
                .into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return getListTeam().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaTeam;
        TextView deskripsi;
        ImageView logo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaTeam = itemView.findViewById(R.id.tvNamaGrup);
            deskripsi = itemView.findViewById(R.id.tvDeskription);
            logo = itemView.findViewById(R.id.imgLogo);
        }
    }
    Context context;

    public TeamAdpter(Context context) {
        this.context = context;
    }

    public ArrayList<Team> getListTeam() {
        return listTeam;
    }

    public void setListTeam(ArrayList<Team> listTeam) {
        this.listTeam = listTeam;
    }

    ArrayList<Team> listTeam;
}
