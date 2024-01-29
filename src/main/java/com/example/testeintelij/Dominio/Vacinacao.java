package com.example.testeintelij.Dominio;

public class Vacinacao {
    private int id;
    private int id_animal;
    private int id_vacina;
    private String data_aplicacao;

    public Vacinacao(int id, int id_animal, int id_vacina, String data_aplicacao) {
        this.id = id;
        this.id_animal = id_animal;
        this.id_vacina = id_vacina;
        this.data_aplicacao = data_aplicacao;
    }

    public Vacinacao(int id_animal, int id_vacina, String data_aplicacao) {
        this.id_animal = id_animal;
        this.id_vacina = id_vacina;
        this.data_aplicacao = data_aplicacao;
    }

    public Vacinacao() {

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

    public int getId_vacina() {
        return id_vacina;
    }

    public void setId_vacina(int id_vacina) {
        this.id_vacina = id_vacina;
    }

    public String getData_aplicacao() {
        return data_aplicacao;
    }

    public void setData_aplicacao(String data_aplicacao) {
        this.data_aplicacao = data_aplicacao;
    }
}

