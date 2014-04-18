package it.cspnet.ecommerce.data;

import it.cspnet.ecommerce.model.Acquisto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class AcquistiDAOspringJdbcImpl extends JdbcDaoSupport implements AcquistiDAO {

    @Override
    public void create(final Acquisto acquisto) {
        KeyHolder key = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                Timestamp timeStamp = new Timestamp(acquisto.getData().getTime());
                PreparedStatement ps = con.prepareStatement(JdbcUtility.ADD_ACQUISTO, Statement.RETURN_GENERATED_KEYS);
                ps.setFloat(1, acquisto.getCostoTotale());
                ps.setTimestamp(2, timeStamp);
                return ps;
            }
        }, key);

        acquisto.setIdAcquisto(key.getKey().intValue());
    }

    @Override
    public void delete(Acquisto acquisto) {
        getJdbcTemplate().update(JdbcUtility.DELETE_ACQUISTO_IN_ACQUISTI, acquisto.getIdAcquisto());
    }

    @Override
    public void deleteAll() {
        getJdbcTemplate().update(JdbcUtility.DELETE_ALL_IN_ACQUISTI);
        getJdbcTemplate().update(JdbcUtility.RESET_AI_ACQUISTI);
    }

}
