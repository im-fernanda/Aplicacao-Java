package com.example.testeintelij.Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.example.testeintelij.Dominio.Funcionario;

public class FuncionarioDAO {
    private Conexao con;
    //private String BUSnome = "SELECT * FROM Funcionario WHERE nome LIKE ?";
    private String BUSid = "SELECT * FROM Funcionario WHERE id = ?";
    private String BUS = "SELECT * FROM Funcionario";
    private String INC = "INSERT INTO Funcionario(nome, telefone, email) VALUES (?,?,?)";
    private String EDIT = "UPDATE Funcionario SET nome = ?, telefone = ?, email = ? WHERE id = ?";
    private String DEL = "DELETE FROM Funcionario WHERE id=?";
    private String DELseRefFuncionario = "DELETE FROM FuncionarioTarefa WHERE id_funcionario = ?";

    public FuncionarioDAO(){
        con = new Conexao("jdbc:postgresql://localhost:5432/ProjPastos", "postgres", "2005");
    }

    /*public ArrayList<Funcionario> buscarNome(String nome){
        Funcionario f;
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(BUSnome);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                f = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email"));
                lista.add(f);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return lista;
    }*/

    public ArrayList<Funcionario> buscar(){
        Funcionario f;
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        try{
            con.conectar();
            Statement ps = con.getConexao().createStatement();
            ResultSet rs = ps.executeQuery(BUS);
            while(rs.next()){
                f = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email"));
                lista.add(f);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return lista;
    }

    public void incluir(Funcionario f){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(INC);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getTelefone());
            ps.setString(3, f.getEmail());
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: " + e.getMessage());
        }
    }

    public void editar(Funcionario f){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(EDIT);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getTelefone());
            ps.setString(3, f.getEmail());
            ps.setInt(4, f.getId());
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na edição: " + e.getMessage());
        }
    }

    public Funcionario buscarPorId(int id){
        Funcionario f1 = null;
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(BUSid);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                f1 = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email"));
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return f1;
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

    public void DELseRefFuncionario(int id){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(DELseRefFuncionario);
            ps.setInt(1, id);
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao apagar: " + e.getMessage());
        }
    }
}