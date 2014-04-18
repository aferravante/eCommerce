package it.cspnet.ecommerce.servizi;

import it.cspnet.ecommerce.model.Acquisto;
import it.cspnet.ecommerce.model.Categoria;
import it.cspnet.ecommerce.model.Prodotto;
import it.cspnet.ecommerce.model.VoceAcquisto;
import java.util.Collection;

public interface Servizi {
    public void eliminaProdotto(Prodotto prodotto);
    public void salvaAcquisto(Acquisto acquisto);
    public void acquistaProdotto(Acquisto acquisto, Prodotto prodotto, int quantita);
    public void creaCategoria(String nome, Prodotto ... prodotti);
    public Collection<Prodotto> ottieniProdotti(Categoria categoria);
    public Collection<VoceAcquisto> ottieniProdotti(Acquisto acquisto);
    public void eliminaAcquisto(Acquisto acquisto);
    public void azzeraAcquisti();
}
