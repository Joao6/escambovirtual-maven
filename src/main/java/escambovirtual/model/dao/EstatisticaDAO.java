package escambovirtual.model.dao;

import escambovirtual.model.entity.Estado;
import escambovirtual.model.entity.EstatisticaRegiao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joao
 */
public class EstatisticaDAO {
    
    public List<EstatisticaRegiao> infoRegiao(Connection conn) throws Exception{
        String sql = "select estado.id, estado.nome, estado.uf, count(item.id) qtde_item, count(localizacao.usuario_fk) qtde_usuario from estado left join item on item.estado_fk=estado.id left join localizacao on localizacao.estado_fk=estado.id group by estado.id, estado.nome, estado.uf order by estado.nome";
        
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        
        List<EstatisticaRegiao> estatisticaRegiaoList = new ArrayList<>();
        
        while(rs.next()){
            EstatisticaRegiao estatisticaRegiao = new EstatisticaRegiao();
            Estado estado = new Estado();
            estado.setId(rs.getLong("id"));
            estado.setNome(rs.getString("nome"));
            estado.setUf(rs.getString("uf"));
            
            estatisticaRegiao.setEstado(estado);
            
            estatisticaRegiao.setQtdeItem(rs.getLong("qtde_item"));
            estatisticaRegiao.setQtdeUsuario(rs.getLong("qtde_usuario"));
            
            estatisticaRegiaoList.add(estatisticaRegiao);
        }
        rs.close();
        s.close();
        return estatisticaRegiaoList;
    }
    
}
