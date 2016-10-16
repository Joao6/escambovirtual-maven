package escambovirtual.model.dao;

import escambovirtual.model.base.BaseDAO;
import escambovirtual.model.entity.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class LogDAO implements BaseDAO<Log> {

    @Override
    public void create(Connection conn, Log entity) throws Exception {
        String sql = "INSERT INTO log(evento, data_hora, id_evento, descricao, usuario_fk) VALUES (?, 'now', ?, ?, ?) RETURNING id;";

        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;

        ps.setString(++i, entity.getEvento());
//        ps.setTimestamp(++i, new Timestamp(entity.getDataHora().getTime()));
        ps.setLong(++i, entity.getIdEvento());
        ps.setString(++i, entity.getDescricao());
        ps.setLong(++i, entity.getIdUsuario());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }

        rs.close();
        ps.close();
    }

    @Override
    public void update(Connection conn, Log entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Connection conn, Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long countByCriteria(Connection conn, Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        Long count = null;
        String sql = "SELECT count(*) count FROM log WHERE 1=1";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            count = rs.getLong("count");
        }
        return count;
    }

    @Override
    public String applyCriteria(Connection conn, Map<Long, Object> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Log readById(Connection conn, Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Log> readByCriteria(Connection conn, Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        String sql = "SELECT id, evento, data_hora, id_evento, descricao, usuario_fk FROM log WHERE 1=1";

        if (limit != null && limit > 0) {
            sql += " limit " + limit;
        }
        if (offset != null && offset >= 0) {
            sql += " offset " + offset;
        }

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<Log> logList = new ArrayList<>();
        while (rs.next()) {
            Log log = new Log();
            log.setId(rs.getLong("id"));
            log.setEvento(rs.getString("evento"));
            log.setDescricao(rs.getString("descricao"));

//            String data[] = rs.getString("data_hora").split("-");
//            String data2 = data[2] + "/" + data[1] + "/" + data[0];
//            log.setDataHora(data2);
//            log.setDataHora(new Date(rs.getTimestamp("data_hora").getTime()));
            String teste1[] = rs.getString("data_hora").split(" ");

            String teste2[] = teste1[0].split("-");

            String teste3 = teste2[2] + "/" + teste2[1] + "/" + teste2[0];

            String teste4[] = teste1[1].split(":");

            String teste5 = teste4[0] + ":" + teste4[1];

            String teste6 = teste3 + " " + teste5;

            log.setDataHora(teste6);
            
            
//            log.setDataHora(rs.getDate("data_hora"));
            log.setIdEvento(rs.getLong("id_evento"));
            log.setIdUsuario(rs.getLong("usuario_fk"));

            logList.add(log);
        }

        return logList;
    }

}
