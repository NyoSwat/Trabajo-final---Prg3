package model;

public class FactoryCategoria {
    
    public Categoria getCategoria(String categoria){
        if(categoria == null)
            return null;
        else if( categoria.compareToIgnoreCase("permanente") ==0)
            return new Permanente();
        else if(categoria.compareToIgnoreCase("temporario")==0)
            return new Temporario();
        else if(categoria.compareToIgnoreCase("contratado")==0)
            return new Contratado();
        else
            return null;
    }
}
