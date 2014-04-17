/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cspnet.ecommerce.servizi;

import it.cspnet.ecommerce.data.CategorieDAO;
import it.cspnet.ecommerce.data.AcquistiDAO;
import it.cspnet.ecommerce.data.ProdottiDAO;
import it.cspnet.ecommerce.data.VoceAcquistoDAO;
import it.cspnet.ecommerce.model.Acquisto;
import it.cspnet.ecommerce.model.Categoria;
import it.cspnet.ecommerce.model.Prodotto;
import it.cspnet.ecommerce.model.VoceAcquisto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author corsojava
 */
public class ServiziDB implements Servizi {
    private ProdottiDAO prodottiDAO;
    private AcquistiDAO acquistiDAO;
    private VoceAcquistoDAO voceAcquistoDAO;
    private CategorieDAO categoriaDAO;

    public ServiziDB() {
    }

    public ServiziDB(ProdottiDAO prodottiDAO, AcquistiDAO acquistiDAO, VoceAcquistoDAO voceAcquistoDAO, CategorieDAO categoriaDAO) {
        this.prodottiDAO = prodottiDAO;
        this.acquistiDAO = acquistiDAO;
        this.voceAcquistoDAO = voceAcquistoDAO;
        this.categoriaDAO = categoriaDAO;
    }

    

    public void setProdottiDAO(ProdottiDAO prodottiDAO) {
        this.prodottiDAO = prodottiDAO;
    }

    public void setAcquistiDAO(AcquistiDAO serviziDAO) {
        this.acquistiDAO = serviziDAO;
    }

    public void setVoceAcquistoDAO(VoceAcquistoDAO voceAcquistoDAO) {
        this.voceAcquistoDAO = voceAcquistoDAO;
    }

    public void setCategorieDAO(CategorieDAO categorieDAO) {
        this.categoriaDAO = categorieDAO;
    }
    
    
    

    @Override
    public void eliminaProdotto(Prodotto prodotto){
        try {
            prodottiDAO.delete(prodotto);
            System.out.println("Prodotto eliminato");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void salvaAcquisto(Acquisto acquisto) {
        try {
            acquistiDAO.create(acquisto);
            for (VoceAcquisto voce : acquisto.getVociAcquisto()){
                voceAcquistoDAO.create(voce);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void acquistaProdotto(Acquisto acquisto, Prodotto prodotto, int quantita) {
        try {
            prodottiDAO.find(prodotto);
            categoriaDAO.find(prodotto.getCategoria());
            acquisto.acquistaProdotto(prodotto, quantita);
            System.out.println("Acquisto Salvato!");
        } catch (ProdottoNonEsistenteException ex) {
            System.out.println("Il prodotto con codice " + prodotto.getIdProdotto() + " non è nel database!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void creaCategoria(String nome, Prodotto... prodotti) {
        Categoria categoria = new Categoria(nome);
        categoriaDAO.create(categoria);
        for(Prodotto p : prodotti){
            p.setCategoria(categoria);
            try {
                prodottiDAO.add(p);
            } catch (Exception ex) {
                try {
                    prodottiDAO.delete(p);
                    prodottiDAO.add(p);
                } catch (Exception ex1) {
                    System.out.println(ex1);
                }
            }
        }
    }

    @Override
    public Collection<Prodotto> ottieniProdotti(Categoria categoria) {
        try {
            categoriaDAO.find(categoria);
            Collection<Prodotto> listaProdotti = prodottiDAO.findAll(categoria);
            for(Prodotto p : listaProdotti)
                p.setCategoria(categoriaDAO.find(p.getCategoria().getIdCategoria()));
            return listaProdotti;
        } catch (CategoriaNonEsistenteException ex) { 
            System.out.println("Non esiste una categoria con codice " + categoria.getIdCategoria());
            return new ArrayList<>();
        }catch (Exception ex) {
            System.out.println(ex);
            return new ArrayList<>();
        }
    }

    @Override
    public Collection<VoceAcquisto> ottieniProdotti(Acquisto acquisto) {
        try {
            Collection<VoceAcquisto> vociAcquisto = voceAcquistoDAO.find(acquisto);
            for(VoceAcquisto vc : vociAcquisto){
                try {
                    prodottiDAO.find(vc.getProdotto());
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            return vociAcquisto;
        } catch (AcquistoNonEsistenteException ex) {
            System.out.println("L'acquisto con codice " + acquisto.getIdAcquisto() + " non è nel database");
            return new ArrayList<>();
        } catch (Exception ex) {
            System.out.println(ex);
            return new ArrayList<>();
        }
    }
    
    
    
}
