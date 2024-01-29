package com.example.testeintelij.Persistencia;

import com.example.testeintelij.Dominio.Medicacao;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MedicacaoDAO {
    private Conexao con;
    private String INC = "INSERT INTO Medicacao(id_animal, id_remedio, data_aplicacao) VALUES (?, ?, ?)";
    private String REL = "SELECT * FROM Medicacao";
    private String EDIT = "UPDATE Medicacao SET id_animal=?, id_remedio=?, data_aplicacao=? WHERE id=?";

    private String BUSporID = "SELECT * FROM Medicacao WHERE id = ?";
    private String DEL = "DELETE FROM Medicacao WHERE id=?";

    public MedicacaoDAO(){
        con = new Conexao("jdbc:postgresql://localhost:5432/ProjPastos", "postgres", "2005");
    }

    public void incluir(Medicacao m){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(INC);
            ps.setInt(1, m.getId_animal());
            ps.setInt(2, m.getId_remedio());
            ps.setString(3, m.getData_aplicacao());
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão " + e.getMessage());
        }
    }

    public ArrayList<Medicacao> relatorio(){
        ArrayList<Medicacao> m = new ArrayList<Medicacao>();
        Medicacao m1;
        try{
            con.conectar();
            Statement st = con.getConexao().createStatement();
            ResultSet rs = st.executeQuery(REL);
            while(rs.next()){
                m1 = new Medicacao(rs.getInt("id"), rs.getInt("id_animal"), rs.getInt("id_remedio"), rs.getString("data_aplicacao"));
                m.add(m1);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return m;
    }

    public void editar(Medicacao m){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(EDIT);
            ps.setInt(1, m.getId_animal());
            ps.setInt(2, m.getId_remedio());
            ps.setString(3, m.getData_aplicacao());
            ps.setInt(4, m.getId());
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na edição: " + e.getMessage());
        }
    }

    public Medicacao buscarPorId(int id){
        Medicacao m1 = null;
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(BUSporID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                m1 = new Medicacao(rs.getInt("id"),rs.getInt("id_animal"),rs.getInt("id_remedio") , rs.getString("data_aplicacao"));
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return m1;
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

