package escambovirtual.model.dao;

import escambovirtual.model.base.BaseDAO;
import escambovirtual.model.entity.Anunciante;
import escambovirtual.model.entity.Mensagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Joao
 */
public class MensagemDAO implements BaseDAO<Mensagem> {

    @Override
    public void create(Connection conn, Mensagem entity) throws Exception {
        String sql = "INSERT INTO mensagem(data_hora_envio, texto, remetente_fk, destinatario_fk, item_fk) VALUES (?, ?, ?, ?, ?) RETURNING id";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int i = 0;
        ps.setTimestamp(++i, new Timestamp(entity.getData_hora_envio().getTime()));
        
        ps.setString(++i, entity.getTexto());
        ps.setLong(++i, entity.getRemetente().getId());
        ps.setLong(++i, entity.getDestinatario().getId());
        ps.setLong(++i, entity.getItem().getId());
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            entity.setId(rs.getLong("id"));
        }
        
        rs.close();
        ps.close();
    }

    @Override
    public Mensagem readById(Connection conn, Long id) throws Exception {
        String sql = "SELECT * FROM mensagem WHERE id=?";
        
        Mensagem mensagem = null;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            mensagem = new Mensagem();
            
            mensagem.setId(rs.getLong("id"));
            mensagem.setTexto(rs.getString("texto"));
            
            mensagem.setDestinatario(new Anunciante(rs.getLong("destinatario_fk")));
            mensagem.setRemetente(new Anunciante(rs.getLong("remetente_fk")));
            
            mensagem.setData_hora_envio(new Date(rs.getTimestamp("data_hora_envio").getTime()));
            mensagem.setData_hora_leitura(new Date(rs.getTimestamp("data_hora_leitura").getTime()));                        
        }
        
        rs.close();
        ps.close();
        
        return mensagem;
    }

    @Override
    public List<Mensagem> readByCriteria(Connection conn, Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Connection conn, Mensagem entity) throws Exception {
        String sql = "UPDATE mensagem SET data_hora_leitura=? WHERE id=?;";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int i = 0;
        ps.setTimestamp(++i, new Timestamp(entity.getData_hora_leitura().getTime()));
        
        ps.setLong(++i, entity.getId());
        
        ps.execute();        
        ps.close();
    }

    @Override
    public void delete(Connection conn, Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long countByCriteria(Connection conn, Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String applyCriteria(Connection conn, Map<Long, Object> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
