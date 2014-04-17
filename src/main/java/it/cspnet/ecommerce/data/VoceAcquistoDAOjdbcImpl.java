package it.cspnet.ecommerce.data;

import it.cspnet.ecommerce.model.Acquisto;
import it.cspnet.ecommerce.model.VoceAcquisto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class VoceAcquistoDAOjdbcImpl extends DAO implements VoceAcquistoDAO{

    public VoceAcquistoDAOjdbcImpl() {
    }

    public VoceAcquistoDAOjdbcImpl(String dbUserName, String dbPassword, String url) {
        super(dbUserName, dbPassword, url);
    }

    @Override
    public void create(VoceAcquisto voce) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(JdbcUtility.ADD_VOCE_ACQUISTO);
            ps.setInt(1, voce.getProdotto().getIdProdotto());
            ps.setInt(2, voce.getAcquisto().getIdAcquisto());
            ps.setInt(3, voce.getQuantitaAcquistata());
            ps.executeUpdate();
                        
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
    public Collection<VoceAcquisto> find(Acquisto acquisto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
