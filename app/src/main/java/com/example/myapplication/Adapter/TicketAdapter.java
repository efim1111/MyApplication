package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.FilmActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.SetFilm;
import com.example.myapplication.model.Ticket;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {

    Context context;
    List<Ticket> tickets;

    public TicketAdapter(Context context, List<Ticket> tickets) {
        this.context = context;
        this.tickets = tickets;
    }

    @NonNull
    @Override
    public TicketAdapter.TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ticketItem = LayoutInflater.from(context).inflate(R.layout.ticket_item, parent,false);
        return new TicketAdapter.TicketViewHolder(ticketItem);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketAdapter.TicketViewHolder holder, int position) {
        holder.ticketName.setText(tickets.get(position).getName());
        holder.ticketDate.setText(tickets.get(position).getDate());
        holder.ticketNameKinoteatr.setText(tickets.get(position).getNameKinoteatr());

        int imgId = context.getResources().getIdentifier("ic_" + tickets.get(position).getImg(), "drawable", context.getPackageName());
        holder.ticketImg.setImageResource(imgId);
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

    public static final class TicketViewHolder extends RecyclerView.ViewHolder {

        TextView ticketName,ticketDate,ticketNameKinoteatr;
        ImageView ticketImg;

        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            ticketName = itemView.findViewById(R.id.ticketName);
            ticketDate = itemView.findViewById(R.id.ticketDate);
            ticketNameKinoteatr = itemView.findViewById(R.id.ticketNameKinoteatr);
            ticketImg = itemView.findViewById(R.id.ticketImg);
        }
    }


}
