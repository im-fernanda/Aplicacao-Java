package com.example.testeintelij.Persistencia;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.example.testeintelij.Dominio.FuncionarioTarefa;
public class FuncionarioTarefaDAO {
    private Conexao con;
    private String INC = "INSERT INTO FuncionarioTarefa(id_funcionario, id_tarefa, descricao) VALUES (?,?,?)";
    private String BUS = "SELECT * FROM FuncionarioTarefa";
    private String BUSporIDFuncionario = "SELECT * FROM FuncionarioTarefa WHERE id_funcionario = ?";
    private String BUSporID = "SELECT * FROM FuncionarioTarefa WHERE id = ?";
    private String EDIT = "UPDATE FuncionarioTarefa SET id_funcionario = ?, id_tarefa = ?, descricao = ? WHERE id = ?";
    private String DEL = "DELETE FROM FuncionarioTarefa WHERE id=?";

    public FuncionarioTarefaDAO(){
        con = new Conexao("jdbc:postgresql://localhost:5432/ProjPastos", "postgres", "2005");
    }

    public void incluir(FuncionarioTarefa ft){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(INC);
            ps.setInt(1, ft.getId_funcionario());
            ps.setInt(2, ft.getId_tarefa());
            ps.setString(3, ft.getDescricao());
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na adição: " + e.getMessage());
        }
    }

    public ArrayList<FuncionarioTarefa> buscar(){
        FuncionarioTarefa ft;
        ArrayList<FuncionarioTarefa> lista = new ArrayList<FuncionarioTarefa>();
        try{
            con.conectar();
            Statement st = con.getConexao().createStatement();
            ResultSet rs = st.executeQuery(BUS);
            while(rs.next()){
                ft = new FuncionarioTarefa(rs.getInt("id"), rs.getInt("id_funcionario"), rs.getInt("id_tarefa"), rs.getString("descricao"));
                lista.add(ft);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return lista;
    }
    public FuncionarioTarefa buscarPorIdFuncionario(int idFuncionario){
        FuncionarioTarefa ft = null;
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(BUSporIDFuncionario);
            ps.setInt(1, idFuncionario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ft = new FuncionarioTarefa(rs.getInt("id"), rs.getInt("id_funcionario"), rs.getInt("id_tarefa"), rs.getString("descricao"));
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return ft;
    }

    public FuncionarioTarefa buscarPorId(int id){
        FuncionarioTarefa ft = null;
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(BUSporID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ft = new FuncionarioTarefa(rs.getInt("id"), rs.getInt("id_funcionario"), rs.getInt("id_tarefa"), rs.getString("descricao"));
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return ft;
    }

    public void editar(FuncionarioTarefa ft){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(EDIT);
            ps.setInt(1, ft.getId_funcionario());
            ps.setInt(2, ft.getId_tarefa());
            ps.setString(3, ft.getDescricao());
            ps.setInt(4, ft.getId());
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na edição: " + e.getMessage());
        }
    }

    public void deletar(int id){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(DEL);
            ps.setInt(1, id);
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}

