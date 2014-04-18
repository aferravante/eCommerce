package it.cspnet.ecommerce.data;

import it.cspnet.ecommerce.model.Acquisto;

public interface AcquistiDAO {

    public void create(Acquisto acquisto);

    public void delete(Acquisto acquisto);

    public void deleteAll();
    
}
