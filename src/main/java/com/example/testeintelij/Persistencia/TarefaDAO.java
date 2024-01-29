package com.example.testeintelij.Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.testeintelij.Dominio.FuncionarioTarefa;
import com.example.testeintelij.Dominio.Tarefa;

public class TarefaDAO {
    private Conexao con;
    private String INC = "INSERT INTO Tarefa DEFAULT VALUES;";
    private String DEL = "DELETE FROM Tarefa WHERE id=?";
    private String DELseRefTarefa = "DELE FROM FuncionarioTarefa WHERE id_tarefa = ?";
    private String UltimoIDTarefa = "SELECT ID FROM Tarefa";

    public TarefaDAO(){
        con = new Conexao("jdbc:postgresql://localhost:5432/ProjPastos", "postgres", "2005");
    }

    public void incluir(FuncionarioTarefa t){
        try{
            con.conectar();
            Statement st = con.getConexao().createStatement();
            st.executeQuery(INC);
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: " + e.getMessage());
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
    public void DELseRefTarefa(int id){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(DELseRefTarefa);
            ps.setInt(1, id);
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao apagar: " + e.getMessage());
        }
    }
    public int UltimoIDTarefa(){
        int id = 0;
        try{
            con.conectar();
            Statement st = con.getConexao().createStatement();
            ResultSet rs = st.executeQuery(UltimoIDTarefa);
            while(rs.next()){
                id = rs.getInt("id");
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return id;
    }
}