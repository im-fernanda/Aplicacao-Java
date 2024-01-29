package com.example.testeintelij.Dominio;

public class FuncionarioTarefa {
    private int id;
    private int id_funcionario;

    private int id_tarefa;
    private String descricao;

    public FuncionarioTarefa(int id, int id_funcionario, int id_tarefa, String descricao) {
        this.id = id;
        this.id_funcionario = id_funcionario;
        this.id_tarefa = id_tarefa;
        this.descricao = descricao;
    }

    public FuncionarioTarefa(int id_funcionario, int id_tarefa, String descricao) {
        this.id_funcionario = id_funcionario;
        this.id_tarefa = id_tarefa;
        this.descricao = descricao;
    }

    public FuncionarioTarefa() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_tarefa() {
        return id_tarefa;
    }

    public void setId_tarefa(int id_tarefa) {
        this.id_tarefa = id_tarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}

