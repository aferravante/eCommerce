package it.cspnet.ecommerce.data;

import it.cspnet.ecommerce.model.Acquisto;
import it.cspnet.ecommerce.model.VoceAcquisto;
import java.util.Collection;

public interface VoceAcquistoDAO {

    public void create(VoceAcquisto voce) throws Exception;
    
    public Collection<VoceAcquisto> find(Acquisto acquisto) throws Exception;


}
