package com.neosmart.punkapl.Model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.neosmart.punkapl.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Yossune Arvez on 16,mayo,2022
 * <p>
 * Brentec
 */
public class AdapterCompleto extends RecyclerView.Adapter<AdapterCompleto.vHolders> implements View.OnClickListener {

    Bitmap mBitmap;
    ArrayList<Cerveza> data ;
    Context context;
    private View.OnClickListener listener;

    public AdapterCompleto(ArrayList<Cerveza> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public vHolders onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view=  layoutInflater.inflate(R.layout.item_producto,parent,false);
        view.setOnClickListener(this);
        return new vHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull vHolders holder, int position) {
        holder.textoProducto.setText(data.get(position).getName());
        holder.textoDescripcion.setText(data.get(position).getTagline());

        Picasso.with(context)
                .load(data.get(position).getImage_url())
                .fit()
                .centerInside().into(holder.Imagen);


    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnclikListener (View.OnClickListener listener){

        this.listener=listener;
    }
    @Override
    public void onClick(View v) {
            if (listener!=null){
                listener.onClick(v);
            }
    }


    public class vHolders extends RecyclerView.ViewHolder{

        TextView textoProducto;
        TextView textoDescripcion;
        ImageView Imagen;

        public vHolders(@NonNull @NotNull View itemView) {
            super(itemView);
            textoProducto = (TextView) itemView.findViewById(R.id.txtProducto);
            textoDescripcion= (TextView) itemView.findViewById(R.id.txtDescripcion);
            Imagen = (ImageView) itemView.findViewById(R.id.imageViewBeer);

        }
    }
}
