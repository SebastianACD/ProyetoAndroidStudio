package com.example.proyectocatalogo;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductosAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Producto> listItem;

    public ProductosAdapter(Context context1, ArrayList<Producto> listItem1){
        this.context = context1;
        this.listItem = listItem1;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Producto p = (Producto) getItem(i);

        view = LayoutInflater.from(context).inflate(R.layout.lista_productos, null);
        ImageView Imagen = view.findViewById(R.id.iv_Productos);
        TextView Nombre = view.findViewById(R.id.tv_titulo);
        TextView Empresa = view.findViewById(R.id.tv_empresa);
        TextView Descripcion = view.findViewById(R.id.tv_descripcion);
        TextView Precio = view.findViewById(R.id.tv_precio);
        TextView Stock = view.findViewById(R.id.tv_stock);

        Picasso.get().load(p.getImagen()).into(Imagen);
        Nombre.setText(p.getNombre());
        Empresa.setText(p.getEmpresa());
        Descripcion.setText(p.getDescripcion());
        Precio.setText(p.getPrecio());
        Stock.setText(p.getStock());

        return view;
    }
}
