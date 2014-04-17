package it.cspnet.ecommerce.model;

public class Categoria {
    private int idCategoria;
    private String nome;

    public Categoria() {
    }
    
    
    public Categoria(String nome) {
        this();
        this.nome = nome;
    }

    public Categoria(int idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
    }
    
    public Categoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
