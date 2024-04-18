package model;

public class Chofer {
    private String dni;
    private String nombre;
    private Categoria categoria;

    public void getSueldo() {
        return categoria.getSueldo();
    }
}
