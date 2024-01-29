package com.example.testeintelij.Persistencia;

import com.example.testeintelij.Dominio.Animal;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnimalDAO {
    private Conexao con;
    private String INC = "INSERT INTO Animal(nome, data_nascimento, sexo, especie, peso, gestante, status_vida) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private String REL = "SELECT * FROM Animal";
    private String BUSporID = "SELECT * FROM Animal WHERE  id = ?";
    private String EDIT = "UPDATE Animal SET nome=?, data_nascimento=?, sexo=?, especie=?, peso=?, gestante=?, status_vida=? WHERE id=?";
    private String BUSporESPECIE = "SELECT * FROM Animal WHERE especie = ?";
    private String DELseRefMedicacao = "DELETE FROM Medicacao WHERE id_animal = ?";
    private String DELseRefVacinacao = "DELETE FROM Vacinacao WHERE id_animal = ?";

    public AnimalDAO() {
        con = new Conexao("jdbc:postgresql://localhost:5432/ProjPastos", "postgres", "2005");
    }

    private String DEL = "DELETE FROM Animal WHERE id=?";

    public void incluir(Animal a) {
        try {
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(INC);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getData_nascimento());
            ps.setString(3, a.getSexo());
            ps.setString(4, a.getEspecie());
            ps.setFloat(5, a.getPeso());
            ps.setString(6, a.getGestante());
            ps.setString(7, a.getStatus_vida());
            ps.execute();
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro na inclusão: " + e.getMessage());
        }
    }

    public ArrayList<Animal> relatorio() {
        ArrayList<Animal> animais = new ArrayList<Animal>();
        Animal a;
        try {
            con.conectar();
            Statement st = con.getConexao().createStatement();
            ResultSet rs = st.executeQuery(REL);
            while (rs.next()) {
                a = new Animal(rs.getInt("id"), rs.getString("nome"), rs.getString("data_nascimento"), rs.getString("sexo"), rs.getString("especie"), rs.getFloat("peso"), rs.getString("gestante"), rs.getString("status_vida"));
                animais.add(a);
            }
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return animais;
    }

    public Animal buscarPorId(int id) {
        Animal a1 = null;
        try {
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(BUSporID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a1 = new Animal(rs.getInt("id"), rs.getString("nome"), rs.getString("data_nascimento"), rs.getString("sexo"), rs.getString("especie"), rs.getFloat("peso"), rs.getString("gestante"), rs.getString("status_vida"));
            }
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return a1;
    }

    public void editar(Animal a) {
        try {
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(EDIT);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getData_nascimento());
            ps.setString(3, a.getSexo());
            ps.setString(4, a.getEspecie());
            ps.setFloat(5, a.getPeso());
            ps.setString(6, a.getGestante());
            ps.setString(7, a.getStatus_vida());
            ps.setInt(8, a.getId());
            ps.execute();
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro na edição: " + e.getMessage());
        }
    }

    public ArrayList<Animal> buscarEspecie(String especie) {
        Animal a;
        ArrayList<Animal> destaEspecie = new ArrayList<Animal>();
        try {
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(BUSporESPECIE);
            ps.setString(1, especie);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = new Animal(rs.getInt("id"), rs.getString("nome"), rs.getString("data_nascimento"), rs.getString("sexo"), rs.getString("especie"), rs.getFloat("peso"), rs.getString("gestante"), rs.getString("status_vida"));
                destaEspecie.add(a);
            }
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return destaEspecie;
    }

    public void deletar(int id) {
        try {
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(DEL);
            ps.setInt(1, id);
            ps.execute();
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
    public void DELseRefMedicacao(int id){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(DELseRefMedicacao);
            ps.setInt(1, id);
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao apagar: " + e.getMessage());
        }
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