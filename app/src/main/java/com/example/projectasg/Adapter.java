package com.example.projectasg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    private ArrayList<Medicine> medicineList = new ArrayList<>();
    Context context;
    Medicine medicine;


    public Adapter(ArrayList<Medicine> medicineList, Context context){
        this.medicineList = medicineList;
        this.context = context;
    }

    public void setMedicineList(ArrayList<Medicine> medicineList){
        this.medicineList = medicineList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_medicine,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder holder, int position) {
        medicine = medicineList.get(position);
        holder.title.setText(medicine.getName());
        holder.manufacturer.setText(medicine.getManu());
        holder.price.setText(medicine.getPrice());
        holder.img.setImageResource(medicine.getImage());

    }


    @Override
    public int getItemCount() {
        return medicineList.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title, manufacturer, price;
        ImageView img;
        private CardView mCardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_medicineName);
            manufacturer = itemView.findViewById(R.id.tv_medicineDesc);
            price = itemView.findViewById(R.id.tv_medicinePrice);
            img = itemView.findViewById(R.id.gambar);
            mCardView = itemView.findViewById(R.id.item_medicine);
            mCardView.setOnClickListener(e->{
                Intent intent = new Intent(context, DetailPage.class);
                intent.putExtra("medi", (Serializable) medicine);
                context.startActivity(intent);
            });

        }
    }
}
