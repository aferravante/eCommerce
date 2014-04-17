package it.cspnet.ecommerce.data;

import it.cspnet.ecommerce.servizi.AcquistoNonEsistenteException;
import it.cspnet.ecommerce.model.Acquisto;
import it.cspnet.ecommerce.model.Prodotto;
import it.cspnet.ecommerce.model.VoceAcquisto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class VoceAcquistoDAOspringJdbcImpl extends JdbcDaoSupport implements VoceAcquistoDAO{

    @Override
    public void create(VoceAcquisto voce) {
        getJdbcTemplate().update(JdbcUtility.ADD_VOCE_ACQUISTO, 
                                                                voce.getProdotto().getIdProdotto(),
                                                                voce.getAcquisto().getIdAcquisto(),
                                                                voce.getQuantitaAcquistata());
    }

    @Override
    public Collection<VoceAcquisto> find(final Acquisto acquisto) throws Exception{
        Collection<VoceAcquisto> result = getJdbcTemplate().query(JdbcUtility.FIND_PRODOTTI_ACQUISTO, new RowMapper<VoceAcquisto>() {

            @Override
            public VoceAcquisto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new VoceAcquisto(new Prodotto(rs.getInt("ID_PRODOTTO")),
                                                     rs.getInt("QUANTITA"),
                                                     acquisto);
            }
        }, acquisto.getIdAcquisto());
        if(result.isEmpty())
            throw new AcquistoNonEsistenteException();
        else
            return result;
    }


    
}
