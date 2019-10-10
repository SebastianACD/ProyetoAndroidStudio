package com.example.proyectocatalogo;

import androidx.appcompat.app.AppCompatActivity;
import com.loopj.android.http.*;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List = (ListView) findViewById(R.id.lv_productos);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ObtenerProductos();
    }

    public void ObtenerProductos(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://127.0.0.1:8000/Proyect/IndexP";

        RequestParams parametros = new RequestParams();

        client.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    ObtJson(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }


    public ArrayList<Producto> ObtJson(String response){
        ArrayList<Producto> Listado = new ArrayList<Producto>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            for(int i=0; i < jsonArray.length();i++){
                String nombre = jsonArray.getJSONObject(i).getString("Nombre");
                String imagen = jsonArray.getJSONObject(i).getString("Imagen");
                String descripcion = jsonArray.getJSONObject(i).getString("Descripcion");
                String empresa = jsonArray.getJSONObject(i).getString("Empresa");
                int  precio = jsonArray.getJSONObject(i).getInt("Precio");
                int  stock = jsonArray.getJSONObject(i).getInt("stock");
                Producto p = new Producto(nombre, imagen, descripcion, empresa, precio, stock);
                Listado.add( p);
                List.setAdapter(new ProductosAdapter(this,Listado));
            }

        }catch (Exception e){

        }
        return  Listado;
    }

}
