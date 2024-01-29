package com.example.testeintelij.Visao;

import com.example.testeintelij.Persistencia.RemedioDAO;
import com.example.testeintelij.Dominio.Remedio;
import com.example.testeintelij.Persistencia.VacinaDAO;
import com.example.testeintelij.Dominio.Vacina;
import java.util.ArrayList;
import com.example.testeintelij.Dominio.Funcionario;
import com.example.testeintelij.Persistencia.FuncionarioDAO;
import com.example.testeintelij.Persistencia.TarefaDAO;
import com.example.testeintelij.Dominio.Tarefa;
import com.example.testeintelij.Persistencia.FuncionarioTarefaDAO;
import com.example.testeintelij.Dominio.FuncionarioTarefa;
import com.example.testeintelij.Persistencia.AnimalDAO;
import com.example.testeintelij.Dominio.Animal;

public class Principal {
    public static void main(String[] args) {
        Remedio r;
        RemedioDAO rDAO = new RemedioDAO();
        ArrayList<Remedio> lista = new ArrayList<Remedio>();
        Vacina v;
        VacinaDAO vDAO = new VacinaDAO();
        ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
        Funcionario f;
        FuncionarioDAO fDAO = new FuncionarioDAO();
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Tarefa t;
        TarefaDAO tDAO = new TarefaDAO();
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
        FuncionarioTarefa ft;
        FuncionarioTarefaDAO ftDAO = new FuncionarioTarefaDAO();
        ArrayList<FuncionarioTarefa> funcionariostarefas = new ArrayList<FuncionarioTarefa>();
        Animal a;
        AnimalDAO aDAO = new AnimalDAO();
        ArrayList<Animal> animais = new ArrayList<Animal>();

        //EXEMPLO ALTERAÇÃO FUNCIONARIO ---------------------------------------------------------
        //f=fDAO.buscarPorId(2); colocando em um novo objeto de funcionario (f) todos os dados de um funcionario especifico a partir do seu id
        //f.setNome("nomeAlterado"); alterando apenas o nome desse objeto f
        //fDAO.editar(f); mandando o f alterado para a função a qual atualizará la no banco
        //---------------------------------------------------------------------------------------

        /*a = new Animal("Marcos", "08/08/08", "M", "Bode", 50, "N/A", "vivo");
        aDAO.incluir(a);
        a = new Animal("Lana", "08/10/19", "F", "Ovelha", 80, "SIM", "vivo");
        aDAO.incluir(a);
        a = new Animal("Pina", "25/11/16", "F", "Cabra", 40, "NÃO", "vivo");
        aDAO.incluir(a);*/

        /*ft=ftDAO.buscarPorId(2);
        ft.setDescricao("descricaoAlteradaa");
        ftDAO.editar(ft);*/

        /*a = aDAO.buscarPorId(2);
        a.setNome("Armandita");
        aDAO.editar(a);*/

        /*animais=aDAO.relatorio();
        for(int i=0;i<animais.size();i++){
            System.out.println("Id: " + animais.get(i).getId() + "\nNome: " + animais.get(i).getNome() + "\nData de nascimento: " + animais.get(i).getData_nascimento() + "\nSexo " + animais.get(i).getSexo() + "\nEspecie " + animais.get(i).getEspecie() + "\nPeso " + animais.get(i).getPeso() + "\nGestante " + animais.get(i).getGestante() + "\nStatus: " + animais.get(i).getStatus_vida());
        }*/

        /*animais=aDAO.buscarEspecie("Bode");
        for(int i=0;i<animais.size();i++){
            System.out.println("Id: " + animais.get(i).getId() + "\nNome: " + animais.get(i).getNome() + "\nData de nascimento: " + animais.get(i).getData_nascimento() + "\nSexo " + animais.get(i).getSexo() + "\nEspecie " + animais.get(i).getEspecie() + "\nPeso " + animais.get(i).getPeso() + "\nGestante " + animais.get(i).getGestante() + "\nStatus: " + animais.get(i).getStatus_vida());
        }*/



        /*t = new Tarefa("nome1");
        tDAO.incluir(t);
        t  = new Tarefa("nome2");
        tDAO.incluir(t);
        t  = new Tarefa("3nome");
        tDAO.incluir(t);*/

        /*ft = new FuncionarioTarefa(1, 2, "Pegar tal coisa");
        ftDAO.incluir(ft);
        ft = new FuncionarioTarefa(2, 1, "Fazer tal coisa");
        ftDAO.incluir(ft);
        ft = new FuncionarioTarefa(3, 3, "Limparr tal coisa");
        ftDAO.incluir(ft);*/

        /*funcionariostarefas=ftDAO.buscar();
        for(int i=0;i<funcionariostarefas.size();i++){
            System.out.println("Id: " + funcionariostarefas.get(i).getId() + "\nId_funcionario: " + funcionariostarefas.get(i).getId_funcionario() + "\nId_tarefa: " + funcionariostarefas.get(i).getId_tarefa() + "\nDescrição: " + funcionariostarefas.get(i).getDescricao());
        }*/

        /*ft = ftDAO.buscarPorIdFuncionario(3);
        System.out.println("Id: " + ft.getId() + "\nId_funcionario: " + ft.getId_funcionario() + "\nId_tarefa: " + ft.getId_tarefa() + "\nDescrição: " + ft.getDescricao());*/

        /*t = tDAO.buscarPorId(2);
        t.setDescricao("descricaoAlterada");
        tDAO.editar(t);*/


        /*f = new Funcionario("nome 1", "84984984", "funcionario1@gmail.com");
        fDAO.incluir(f);
        f = new Funcionario("nome 2", "84984984", "funcionario2@gmail.com");
        fDAO.incluir(f);
        f = new Funcionario("nome 3", "84984984", "funcionario3@gmail.com");
        fDAO.incluir(f);*/

        /*funcionarios=fDAO.buscar();
        for(int i=0;i<funcionarios.size();i++){
            System.out.println("Id: " + funcionarios.get(i).getId() + "\nNome: " + funcionarios.get(i).getNome() + "\nTelefone: " + funcionarios.get(i).getTelefone() + "\nEmail: " + funcionarios.get(i).getEmail());
        }*/

        /*funcionarios=fDAO.buscarNome("nome 1");
        for(int i=0;i<funcionarios.size();i++){
            System.out.println("Id: " + funcionarios.get(i).getId() + "\nNome: " + funcionarios.get(i).getNome() + "\nTelefone: " + funcionarios.get(i).getTelefone() + "\nEmail: " + funcionarios.get(i).getEmail());
        }*/

        /*v = new Vacina("nome1", "descricao1");
        vDAO.incluir(v);
        v = new Vacina("nome2", "descricao2");
        vDAO.incluir(v);
        v = new Vacina("nome3", "descricao3");
        vDAO.incluir(v);*/
        /*rDAO.incluir("nome1", "descricao1");
        rDAO.incluir("nome2", "descricao2");
        rDAO.incluir("nome3", "descricao3");*/

        /*lista = rDAO.relatorio();
        for(int i=0;i<lista.size();i++){
            System.out.println("Id: " + lista.get(i).getId() + "\nNome: " + lista.get(i).getNome() + "\nDescricao: " + lista.get(i).getDescricao());
        }*/

        /*vacinas = vDAO.relatorio();
        for(int i=0;i<vacinas.size();i++){
            System.out.println("Id: " + vacinas.get(i).getId() + "\nNome: " + vacinas.get(i).getNome() + "\nDescricao: " + vacinas.get(i).getDescricao());
        }*/

        //rDAO.deletar("Dipirona");
        //vDAO.deletar("nome2");

       /*r = new Remedio("Dipirona", "Analgésico básico");
        rDAO.incluir(r);
        r = new Remedio("Histamim", "Antialérgico básico");
        rDAO.incluir(r);
        r = new Remedio("Placebo", "Mentira básica");
        rDAO.incluir(r);*/

        //rDAO.deletar(rDAO.buscarIdPorNome("Dipirona"));
    }
}
