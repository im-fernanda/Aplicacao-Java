package com.example.testeintelij.Dominio;

public class Tarefa {
    private int id;

    public Tarefa(int id, String nome) {
        this.id = id;
    }

    public Tarefa() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
