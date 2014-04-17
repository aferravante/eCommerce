package it.cspnet.ecommerce.data;

import it.cspnet.ecommerce.model.Categoria;

public interface CategorieDAO {
    public void create(Categoria categoria);

    public void find(Categoria categoria) throws Exception;
    
    public Categoria find(int idCategoria) throws Exception;
}
