package it.cspnet.ecommerce;

import it.cspnet.ecommerce.model.Acquisto;
import it.cspnet.ecommerce.model.Categoria;
import it.cspnet.ecommerce.model.Prodotto;
import it.cspnet.ecommerce.model.VoceAcquisto;
import it.cspnet.ecommerce.servizi.ServiziDB;
import java.util.Collection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programma {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJdbc.xml");
        ServiziDB servizi = (ServiziDB) applicationContext.getBean("serviziDB");
        
        servizi.eliminaProdotto(new Prodotto(4));
//        servizi.creaCategoria("Tablet",   new Prodotto("iPad", "Tablet Apple", 600, 20),
//                                            new Prodotto("Galaxy Note", "Tablet Samsung", 500, 30),
//                                            new Prodotto("Kindle Fire HD", "Tablet Kindle", 200, 50)
//        );
        
//        servizi.creaCategoria("Cellulari",  new Prodotto("iPhone", "Smartphone Apple", 700, 20),
//                                            new Prodotto("Samsung Galaxy", "Smartphone Samsung", 500, 30)
//        );
        
//        servizi.azzeraAcquisti();
        
        
        Acquisto acquisto = new Acquisto();
        servizi.acquistaProdotto(acquisto, new Prodotto(3), 2);
        servizi.acquistaProdotto(acquisto, new Prodotto(1), 1);
        servizi.acquistaProdotto(acquisto, new Prodotto(2), 5);
        servizi.acquistaProdotto(acquisto, new Prodotto(6), 1);
        System.out.println("Costo totale acquisto = " + acquisto.getCostoTotale());
        servizi.salvaAcquisto(acquisto);
//        
//        Collection<Prodotto> prodotti = servizi.ottieniProdotti(new Categoria(5));
//        for(Prodotto p : prodotti)
//            System.out.println(p);
        
//        Collection<VoceAcquisto> vociAcquisto = servizi.ottieniProdotti(new Acquisto(3));
//        for(VoceAcquisto vc : vociAcquisto)
//            System.out.println(vc);
        
//        servizi.eliminaAcquisto(new Acquisto(9));
        
    }

}
