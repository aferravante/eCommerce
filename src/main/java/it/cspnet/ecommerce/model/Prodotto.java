package it.cspnet.ecommerce.model;

public class Prodotto {
    private int idProdotto;
    private String nome;
    private String descrizione;
    private float prezzo;
    private int quantitaDisponibile;
    private Categoria categoria;

    public Prodotto() {
    }

    public Prodotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public Prodotto(String nome, String descrizione, float prezzo, int quantitaDisponibile) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
    }
    
    
    
    public Prodotto(int idProdotto, String nome, String descrizione, float prezzo, int quantitaDisponibile) {
        this.idProdotto = idProdotto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
    }
    

    public Prodotto(int idProdotto, String nome, String descrizione, float prezzo, int quantitaDisponibile, Categoria categoria) {
        this.idProdotto = idProdotto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
        this.categoria = categoria;
    }
    
    public Prodotto(int idProdotto, String nome, String descrizione, float prezzo, int quantitaDisponibile, int idCategoria) {
        this.idProdotto = idProdotto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
        this.categoria = new Categoria(idCategoria);
    }
    
    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public int getQuantitaDisponibile() {
        return quantitaDisponibile;
    }

    public int getIdProdotto() {
        return idProdotto;
    }
    
    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void setQuantitaDisponibile(int quantitaDisponibile) {
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idProdotto;
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
        final Prodotto other = (Prodotto) obj;
        if (this.idProdotto != other.idProdotto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "idProdotto=" + idProdotto + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzo=" + prezzo + '}';
    }
    
    
    
    
}
