package com.neosmart.punkapl.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.neosmart.punkapl.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Created by Yossune Arvez on 15,mayo,2022
 * <p>
 * Brentec
 */
public class Adapter extends RecyclerView.Adapter<Adapter.vHolder> {

ArrayList<String> data ;
Context context;

    public Adapter(ArrayList<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public vHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
      View view=  layoutInflater.inflate(R.layout.item_producto,parent,false);
        return new vHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull vHolder holder, int position) {
            holder.textoProducto.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class vHolder extends RecyclerView.ViewHolder{

        TextView textoProducto;
        public vHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textoProducto = (TextView) itemView.findViewById(R.id.txtProducto);
        }
    }


}
