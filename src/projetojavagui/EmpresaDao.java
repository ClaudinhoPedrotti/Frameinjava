
package projetojavagui;

import java.sql.*;
import java.util.*;

public class EmpresaDao {
    
    private Connection con;
    
    public EmpresaDao(Connection con){
        setCon(con);
    }
    
    public Connection getCon(){
        return con;
    }
    
    public void setCon(Connection con){
        this.con = con;
    }
    
    public String inserir(EmpresaBean funcionarios) {
        String sql = "insert into funcionarios(nome, cpf, email, cargo, nasc, id)values(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, funcionarios.getNome());
            ps.setString(2, funcionarios.getCpf());
            ps.setString(3, funcionarios.getEmail());
            ps.setString(4, funcionarios.getCargo());
            ps.setString(5, funcionarios.getNasc());
            ps.setString(6, funcionarios.getId());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public String alterar(EmpresaBean funcionarios) {
        
           
        String sql = "update funcionarios set nome=?,email=?,cpf=?,cargo=?,nasc=? where id = ?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, funcionarios.getId());
            ps.setString(2, funcionarios.getNome());
            ps.setString(3, funcionarios.getEmail());
            ps.setString(4, funcionarios.getCpf());
            ps.setString(5, funcionarios.getCargo());
            ps.setString(6, funcionarios.getNasc());
            

            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso.";
            } else {
                return "Erro ao alterar";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public String Excluir(EmpresaBean funcionarios){
        String sql = "delete from funcionarios where id = ?";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, funcionarios.getId());
            
            if (ps.executeUpdate() > 0){
                return "Excluido com sucesso!";
            
            } else {
                return "Erro ao excluir";
            }
        } catch(SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<EmpresaBean> listarTodos() {
        String sql = "select * from funcionarios";
        
        List<EmpresaBean> listaFuncionario = new ArrayList<EmpresaBean>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs != null) {
                while (rs.next()){
                    EmpresaBean eb = new EmpresaBean();
                    eb.setNome(rs.getString(1));
                    eb.setCpf(rs.getString(2));
                    eb.setEmail(rs.getString(3));
                    eb.setNasc(rs.getString(4));
                    eb.setCargo(rs.getString(5));
                    listaFuncionario.add(eb);
                }
                return listaFuncionario;
            } else {
                return null;
            }
        } catch(SQLException e) {
            return null;
        }
    }
    
    
    
}