package com.example.testeintelij.Persistencia;

import com.example.testeintelij.Dominio.Animal;
import com.example.testeintelij.Dominio.Remedio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RemedioDAO {
    private Conexao con;
    private String INC = "INSERT INTO Remedio(nome, descricao) VALUES (?, ?)";
    private String BUSIDporNOME = "SELECT * FROM Remedio WHERE nome=?";
    private String DEL = "DELETE FROM Remedio WHERE nome = ?";
    private String REL = "SELECT * FROM Remedio";
    private String EDIT = "UPDATE Remedio SET nome=?, descricao=? WHERE id=?";
    private String DELseRefMedicacao = "DELETE FROM Medicacao WHERE id_remedio = (SELECT id FROM Remedio WHERE nome = ?);";

    public RemedioDAO() {
        con = new Conexao("jdbc:postgresql://localhost:5432/ProjPastos", "postgres", "2005");
    }

    public void incluir(Remedio r){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(INC);
            ps.setString(1, r.getNome());
            ps.setString(2, r.getDescricao());
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: " + e.getMessage());
        }
    }

    public Remedio buscarPorNome(String nome) {
        Remedio remedio = null;
        try {
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(BUSIDporNOME);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                remedio = new Remedio(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
            }
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro na busca por nome: " + e.getMessage());
        }
        return remedio;
    }


    public void deletar(String id){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(DEL);
            ps.setString(1, id);
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }

    public void editar(Remedio r) {
        try {
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(EDIT);
            ps.setString(1, r.getNome());
            ps.setString(2, r.getDescricao());
            ps.setInt(3, r.getId());  // Adiciona o ID na cláusula WHERE
            ps.executeUpdate();  // Use executeUpdate para operações de atualização
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro na edição: " + e.getMessage());
        }
    }

    public ArrayList<Remedio> relatorio(){
        Remedio r;
        ArrayList<Remedio> lista = new ArrayList<Remedio>();
        try{
            con.conectar();
            Statement ps = con.getConexao().createStatement();
            ResultSet rs = ps.executeQuery(REL);
            while(rs.next()){
                r = new Remedio(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
                lista.add(r);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao mostrar relatorio " + e.getMessage());
        }
        return lista;
    }
    public void DELseRefMedicacao(String id){
        try{
            con.conectar();
            PreparedStatement ps = con.getConexao().prepareStatement(DELseRefMedicacao);
            ps.setString(1, id);
            ps.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao apagar: " + e.getMessage());
        }
    }
}