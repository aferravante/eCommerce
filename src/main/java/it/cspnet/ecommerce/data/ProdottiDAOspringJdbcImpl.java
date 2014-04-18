package it.cspnet.ecommerce.data;

import it.cspnet.ecommerce.model.Categoria;
import it.cspnet.ecommerce.model.Prodotto;
import it.cspnet.ecommerce.servizi.ProdottoNonEsistenteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ProdottiDAOspringJdbcImpl extends JdbcDaoSupport implements ProdottiDAO{

    @Override
    public void delete(Prodotto prodotto) {
        getJdbcTemplate().update(JdbcUtility.DELETE_PRODOTTO, prodotto.getIdProdotto());
    }

    @Override
    public void find(Prodotto prodotto) throws Exception{
        List<Prodotto> ricerca = getJdbcTemplate().query(JdbcUtility.FIND_PRODOTTO, new RowMapper<Prodotto>() {

            @Override
            public Prodotto mapRow(ResultSet rs, int i) throws SQLException {
                return new Prodotto(rs.getInt("ID_PRODOTTO"),
                                    rs.getString("NOME"),
                                    rs.getString("DESCRIZIONE"),
                                    rs.getFloat("PREZZO"),
                                    rs.getInt("QUANTITA_DISPONIBILE"),
                                    rs.getInt("ID_CATEGORIA"));
            }
        }, prodotto.getIdProdotto());
        if(ricerca.isEmpty())
            throw new ProdottoNonEsistenteException();
        prodotto.setNome(ricerca.get(0).getNome());
        prodotto.setDescrizione(ricerca.get(0).getDescrizione());
        prodotto.setPrezzo(ricerca.get(0).getPrezzo());
        prodotto.setQuantitaDisponibile(ricerca.get(0).getQuantitaDisponibile());
        prodotto.setCategoria(ricerca.get(0).getCategoria());
    }

    @Override
    public void add(Prodotto prodotto){
        getJdbcTemplate().update(JdbcUtility.ADD_PRODOTTO,  prodotto.getNome(),
                                                            prodotto.getDescrizione(),
                                                            prodotto.getPrezzo(),
                                                            prodotto.getQuantitaDisponibile(),
                                                            prodotto.getCategoria().getIdCategoria());
    }

    @Override
    public Collection<Prodotto> findAll(Categoria categoria) {
        return getJdbcTemplate().query(JdbcUtility.FIND_PRODOTTO_IN_CATEGORIA, new RowMapper<Prodotto>() {

            @Override
            public Prodotto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Prodotto(rs.getInt("ID_PRODOTTO"),
                                    rs.getString("NOME"),
                                    rs.getString("DESCRIZIONE"),
                                    rs.getFloat("PREZZO"),
                                    rs.getInt("QUANTITA_DISPONIBILE"),
                                    rs.getInt("ID_CATEGORIA"));
            }
        }, categoria.getIdCategoria());
    }

}
