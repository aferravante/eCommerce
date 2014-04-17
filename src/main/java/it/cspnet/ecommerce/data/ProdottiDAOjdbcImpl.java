package it.cspnet.ecommerce.data;

import it.cspnet.ecommerce.model.Categoria;
import it.cspnet.ecommerce.servizi.ProdottoNonEsistenteException;
import it.cspnet.ecommerce.model.Prodotto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class ProdottiDAOjdbcImpl extends DAO implements ProdottiDAO{

    public ProdottiDAOjdbcImpl() {
    }

    public ProdottiDAOjdbcImpl(String dbUserName, String dbPassword, String url) {
        super(dbUserName, dbPassword, url);
    }
    
    
    
    @Override
    public void delete(Prodotto prodotto) throws Exception{
        Connection connection = getConnection();
        PreparedStatement st = connection.prepareStatement(JdbcUtility.DELETE_PRODOTTO);
        st.setInt(1, prodotto.getIdProdotto());
        int i = st.executeUpdate();
        st.close();
        connection.close();

        if(i == 0)
            throw new ProdottoNonEsistenteException();
    }

    @Override
    public void find(Prodotto prodotto) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(JdbcUtility.FIND_PRODOTTO);
            ps.setInt(1, prodotto.getIdProdotto());
            rs = ps.executeQuery();
            if (rs.next()) {
                prodotto.setNome(rs.getString("NOME"));
                prodotto.setDescrizione(rs.getString("DESCRIZIONE"));
                prodotto.setPrezzo(rs.getFloat("PREZZO"));
                prodotto.setQuantitaDisponibile(rs.getInt("QUANTITA_DISPONIBILE"));
            } else {
                throw new ProdottoNonEsistenteException();
            }
        } catch (SQLException ex) {
            throw ex;

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void add(Prodotto prodotto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Prodotto> findAll(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
