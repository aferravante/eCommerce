package it.cspnet.ecommerce.data;

import it.cspnet.ecommerce.model.Categoria;
import it.cspnet.ecommerce.model.Prodotto;
import java.util.Collection;

public interface ProdottiDAO {

    public void delete(Prodotto prodotto);

    public void find(Prodotto prodotto) throws Exception;
    
    public void add(Prodotto prodotto);

    public Collection<Prodotto> findAll(Categoria categoria);
    
}
