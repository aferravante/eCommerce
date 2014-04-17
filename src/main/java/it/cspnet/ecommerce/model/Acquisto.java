package it.cspnet.ecommerce.model;

import java.util.ArrayList;
import java.util.Collection;

public class Acquisto {
    private int idAcquisto;
    private float costoTotale;
    private Collection<VoceAcquisto> vociAcquisto;

    public Acquisto() {
        this.vociAcquisto = new ArrayList<>();
    }

    public Acquisto(int idAcquisto) {
        this();
        this.idAcquisto = idAcquisto;
    }
    
    public int getIdAcquisto() {
        return idAcquisto;
    }

    public void setIdAcquisto(int idAcquisto) {
        this.idAcquisto = idAcquisto;
    }

    public float getCostoTotale() {
        return costoTotale;
    }

    public void setCostoTotale(float costoTotale) {
        this.costoTotale = costoTotale;
    }

    public Collection<VoceAcquisto> getVociAcquisto() {
        return vociAcquisto;
    }

    public void setVociAcquisto(Collection<VoceAcquisto> vociAcquisto) {
        this.vociAcquisto = vociAcquisto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idAcquisto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Acquisto other = (Acquisto) obj;
        if (this.idAcquisto != other.idAcquisto) {
            return false;
        }
        return true;
    }

    public void acquistaProdotto(Prodotto prodotto, int quantita) {
        VoceAcquisto nuovaVoce = new VoceAcquisto(prodotto, quantita, this);
        this.vociAcquisto.add(nuovaVoce);
        this.costoTotale += nuovaVoce.getCosto();
    }

    @Override
    public String toString() {
        return "Acquisto{" + "idAcquisto=" + idAcquisto + ", costoTotale=" + costoTotale + '}';
    }

    
    
    
}
