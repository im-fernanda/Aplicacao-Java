package com.example.testeintelij.Dominio;

public class Animal {
    private int id;
    private String nome;
    private String data_nascimento;
    private String sexo;
    private String especie;
    private float peso;
    private String gestante;
    private String status_vida;

    public Animal(int id, String nome, String data_nascimento, String sexo, String especie, float peso, String gestante, String status_vida) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.especie = especie;
        this.peso = peso;
        this.gestante = gestante;
        this.status_vida = status_vida;
    }

    public Animal(String nome, String data_nascimento, String sexo, String especie, float peso, String gestante, String status_vida) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.especie = especie;
        this.peso = peso;
        this.gestante = gestante;
        this.status_vida = status_vida;
    }

    public Animal() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getGestante() {
        return gestante;
    }

    public void setGestante(String gestante) {
        this.gestante = gestante;
    }

    public String getStatus_vida() {
        return status_vida;
    }

    public void setStatus_vida(String status_vida) {
        this.status_vida = status_vida;
    }
}
