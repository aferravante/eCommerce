package it.cspnet.ecommerce.data;

public class JdbcUtility {
    static final String FIND_PRODOTTO = "SELECT * FROM PRODOTTI WHERE PRODOTTI.ID_PRODOTTO = ?";
    static final String DELETE_PRODOTTO = "DELETE FROM PRODOTTI WHERE PRODOTTI.ID_PRODOTTO = ?";
    static final String ADD_ACQUISTO = "INSERT INTO ACQUISTI (COSTO_TOTALE) VALUES (?)";
    static final String ADD_VOCE_ACQUISTO = "INSERT INTO ACQUISTI_PRODOTTI (ID_PRODOTTO,ID_ACQUISTO,QUANTITA) VALUES (?,?,?)";
    static final String ADD_CATEGORIA = "INSERT INTO CATEGORIE (NOME) VALUES (?)";
    static final String FIND_CATEGORIA = "SELECT * FROM CATEGORIE WHERE CATEGORIE.ID_CATEGORIA = ?";
    static final String ADD_PRODOTTO = "INSERT INTO PRODOTTI "
                                     + "(NOME,DESCRIZIONE,PREZZO,QUANTITA_DISPONIBILE,ID_CATEGORIA) VALUES (?,?,?,?,?)";
    static final String FIND_PRODOTTO_IN_CATEGORIA = "SELECT * FROM PRODOTTI WHERE PRODOTTI.ID_CATEGORIA = ?";
    static final String FIND_PRODOTTI_ACQUISTO = "SELECT * FROM ACQUISTI_PRODOTTI "
                                               + "WHERE ACQUISTI_PRODOTTI.ID_ACQUISTO = ?";
    
}
