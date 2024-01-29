package com.example.testeintelij.Persistencia;

import com.example.testeintelij.Dominio.Vacina;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VacinaDAO {
    private Conexao con;
    private String INC = "INSERT INTO Vacina(nome, descricao) VALUES (?, ?)";
    private String DEL = "DELETE FROM Vacina WHERE id = ?";
    private String REL = "SELECT * FROM Vacina";
    private String EDIT = "UPDATE Vacina SET nome=?, descricao=? WHERE id=?";
    private String BUSporID = "SELECT * FROM Vacina WHERE id = ?";
    private String DELseRefVacinacao = "DELETE FROM Vacinacao WHERE id_vacina = ?";

    public VacinaDAO() {
        con = new Conexao("jdbc:postgresql://localhost:5432/ProjPastos", "postgres", "2005");
    }

    public void incluir(Vacina v){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(INC);
            ps.setString(1, v.getNome());
            ps.setString(2, v.getDescricao());
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: " + e.getMessage());
        }
    }

    public void deletar(int nome){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(DEL);
            ps.setInt(1, nome);
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }

    public ArrayList<Vacina> relatorio(){
        Vacina v;
        ArrayList<Vacina> lista = new ArrayList<Vacina>();
        try{
            con.conectar();
            Statement ps = con.getConexao().createStatement();
            ResultSet rs = ps.executeQuery(REL);
            while(rs.next()){
                v = new Vacina(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
                lista.add(v);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao mostrar relatorio " + e.getMessage());
        }
        return lista;
    }

    public void editar(Vacina v){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(EDIT);
            ps.setString(1, v.getNome());
            ps.setString(2, v.getDescricao());
            ps.setInt(3, v.getId());
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na edição: " + e.getMessage());
        }
    }

    public Vacina buscarPorId(int id){
        Vacina v = null;
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(BUSporID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                v = new Vacina(rs.getInt("id"),rs.getString("nome"),rs.getString("descricao"));
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return v;
    }
    public void DELseRefVacinacao(int id){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(DELseRefVacinacao);
            ps.setInt(1, id);
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao apagar: " + e.getMessage());
        }
    }
}