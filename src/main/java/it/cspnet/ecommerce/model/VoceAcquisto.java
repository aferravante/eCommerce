package it.cspnet.ecommerce.model;

public class VoceAcquisto {
    private Prodotto prodotto;
    private int quantitaAcquistata;
    private Acquisto acquisto;

    public VoceAcquisto() {
    }

    public VoceAcquisto(Prodotto prodotto, int quantitaAcquistata, Acquisto acquisto) {
        this.prodotto = prodotto;
        this.quantitaAcquistata = quantitaAcquistata;
        this.acquisto = acquisto;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public int getQuantitaAcquistata() {
        return quantitaAcquistata;
    }

    public void setQuantitaAcquistata(int quantitaAcquistata) {
        this.quantitaAcquistata = quantitaAcquistata;
    }

    public Acquisto getAcquisto() {
        return acquisto;
    }

    public void setAcquisto(Acquisto acquisto) {
        this.acquisto = acquisto;
    }
    
    public float getCosto(){
        return prodotto.getPrezzo() * this.quantitaAcquistata;
    }

    @Override
    public String toString() {
        return "VoceAcquisto{" + "prodotto=" + prodotto + ", quantitaAcquistata=" + quantitaAcquistata + ", codice acquisto=" + acquisto.getIdAcquisto() + '}';
    }
    
    
}
