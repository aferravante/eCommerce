package it.cspnet.ecommerce.data;

import it.cspnet.ecommerce.model.Acquisto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcquistiDAOjdbcImpl extends DAO implements AcquistiDAO{

    public AcquistiDAOjdbcImpl() {
    }

    public AcquistiDAOjdbcImpl(String dbUserName, String dbPassword, String url) {
        super(dbUserName, dbPassword, url);
    }

    
    @Override
    public void create(Acquisto acquisto) throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(JdbcUtility.ADD_ACQUISTO, Statement.RETURN_GENERATED_KEYS);
//            ps = connection.prepareStatement(ADD_ACQUISTO);
//            ps.setInt(1, acquisto.getIdAcquisto());
//            ps.setFloat(2, acquisto.getCostoTotale());
            ps.setFloat(1, acquisto.getCostoTotale());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs != null && rs.next()){
                acquisto.setIdAcquisto(rs.getInt(1));
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
    
    
    
}
