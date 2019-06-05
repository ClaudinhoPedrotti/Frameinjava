package projetojavagui;
import java.sql.*;
import java.util.*;
import projetojavagui.Conexao;
import projetojavagui.EmpresaBean;
import projetojavagui.EmpresaDao;


public class TesteEmpresa {
    
    public static void main(String[] args) {
        
        Connection con = Conexao.abrirConexao();
        EmpresaBean eb = new EmpresaBean();
        EmpresaDao ed = new EmpresaDao(con);  
        
        
        eb.setId("1");
        eb.setNome("Marquinhos");
        eb.setEmail("Marco@etec.com");
        eb.setCpf("364.945.488-22");
        eb.setCargo("Futebol");
        eb.setNasc("05/05/2019");
        
        
        System.out.println(ed.alterar(eb));
     
}
    
}
