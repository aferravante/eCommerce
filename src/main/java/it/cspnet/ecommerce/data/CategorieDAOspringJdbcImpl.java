package it.cspnet.ecommerce.data;

import it.cspnet.ecommerce.servizi.CategoriaNonEsistenteException;
import it.cspnet.ecommerce.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class CategorieDAOspringJdbcImpl extends JdbcDaoSupport implements CategorieDAO{

    @Override
    public void create(final Categoria categoria) {
        KeyHolder key = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(JdbcUtility.ADD_CATEGORIA, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, categoria.getNome());
                return ps;
            }
        }, key);
        categoria.setIdCategoria(key.getKey().intValue());
    }

    @Override
    public void find(Categoria categoria) throws Exception{
        List<Categoria> ricerca = getJdbcTemplate().query(JdbcUtility.FIND_CATEGORIA, new RowMapper<Categoria>() {

            @Override
            public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Categoria(rs.getInt("ID_CATEGORIA"), rs.getString("NOME"));
            }
        }, categoria.getIdCategoria());
        if(ricerca.isEmpty())
            throw new CategoriaNonEsistenteException();
        categoria.setNome(ricerca.get(0).getNome());
    }

    @Override
    public Categoria find(int idCategoria) throws Exception{
        Categoria cat = new Categoria(idCategoria);
        find(cat);
        return cat;
    }
    
}
