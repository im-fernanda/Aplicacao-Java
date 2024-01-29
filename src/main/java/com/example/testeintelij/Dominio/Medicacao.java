package com.example.testeintelij.Dominio;

public class Medicacao {
    private int id;
    private int id_animal;
    private int id_remedio;
    private String data_aplicacao;

    public Medicacao(int id, int id_animal, int id_remedio, String data_aplicacao) {
        this.id = id;
        this.id_animal = id_animal;
        this.id_remedio = id_remedio;
        this.data_aplicacao = data_aplicacao;
    }

    public Medicacao(int id_animal, int id_remedio, String data_aplicacao) {
        this.id_animal = id_animal;
        this.id_remedio = id_remedio;
        this.data_aplicacao = data_aplicacao;
    }

    public Medicacao() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public int getId_remedio() {
        return id_remedio;
    }

    public void setId_remedio(int id_remedio) {
        this.id_remedio = id_remedio;
    }

    public String getData_aplicacao() {
        return data_aplicacao;
    }

    public void setData_aplicacao(String data_aplicacao) {
        this.data_aplicacao = data_aplicacao;
    }
}

