package com.example.testeintelij.Persistencia;

import com.example.testeintelij.Dominio.Vacinacao;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VacinacaoDAO {
    private Conexao con;
    private String INC = "INSERT INTO Vacinacao(id_animal, id_vacina, data_aplicacao) VALUES (?, ?, ?)";
    private String REL = "SELECT * FROM Vacinacao";
    private String EDIT = "UPDATE Vacinacao SET id_animal=?, id_vacina=?, data_aplicacao=? WHERE id=?";
    private String BUSporID = "SELECT * FROM Vacinacao WHERE id = ?";
    private String DEL = "DELETE FROM Vacinacao WHERE id=?";


    public VacinacaoDAO(){
        con = new Conexao("jdbc:postgresql://localhost:5432/ProjPastos", "postgres", "2005");
    }

    public void incluir(Vacinacao v){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(INC);
            ps.setInt(1, v.getId_animal());
            ps.setInt(2, v.getId_vacina());
            ps.setString(3, v.getData_aplicacao());
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão " + e.getMessage());
        }
    }

    public ArrayList<Vacinacao> relatorio(){
        Vacinacao v;
        ArrayList<Vacinacao> lista = new ArrayList<Vacinacao>();
        try{
            con.conectar();
            Statement ps = con.getConexao().createStatement();
            ResultSet rs = ps.executeQuery(REL);
            while(rs.next()){
                v = new Vacinacao(rs.getInt("id"), rs.getInt("id_animal"), rs.getInt("id_vacina"), rs.getString("data_aplicacao"));
                lista.add(v);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao mostrar relatorio " + e.getMessage());
        }
        return lista;
    }

    public void editar(Vacinacao v){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(EDIT);
            ps.setInt(1, v.getId_animal());
            ps.setInt(2, v.getId_vacina());
            ps.setString(3, v.getData_aplicacao());
            ps.setInt(4, v.getId());
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na edição: " + e.getMessage());
        }
    }

    public Vacinacao buscarPorId(int id){
        Vacinacao v = null;
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(BUSporID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                v = new Vacinacao(rs.getInt("id"), rs.getInt("id_animal"), rs.getInt("id_vacina"), rs.getString("data_aplicacao"));
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return v;
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
}

