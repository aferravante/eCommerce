package it.cspnet.ecommerce.data;

import it.cspnet.ecommerce.model.Acquisto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class AcquistiDAOspringJdbcImpl extends JdbcDaoSupport implements AcquistiDAO{

    @Override
    public void create(final Acquisto acquisto) {
        KeyHolder key = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(JdbcUtility.ADD_ACQUISTO, Statement.RETURN_GENERATED_KEYS);
                ps.setFloat(1, acquisto.getCostoTotale());
                return ps;
            }
        }, key);
        
        acquisto.setIdAcquisto(key.getKey().intValue());
    }
    
}
