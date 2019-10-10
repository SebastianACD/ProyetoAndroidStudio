package com.example.proyectocatalogo;

public class Producto {
    private String Nombre;
    private String Imagen;
    private String Descripcion;
    private String Empresa;
    private int Precio,Stock;

    public Producto(String nombre, String imagen, String descripcion, String empresa, int precio, int stock){
        Nombre = nombre;
        Imagen = imagen;
        Descripcion = descripcion;
        Empresa = empresa;
        Precio = precio;
        this.Stock = stock;
    }
    public String getImagen() {return Imagen;}
    public String getNombre() {return Nombre;}
    public String getDescripcion() {return Descripcion;}
    public String getEmpresa() {return Empresa;}
    public int getPrecio() {return Precio;}
    public int getStock() {return Stock;}
}
