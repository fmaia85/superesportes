package edu.pw2.superesportes.model;

public class Atleta {
    private String nome;
    private int idade;
    private double peso;
    private double altura;

    public Atleta() {}

    public Atleta(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public Atleta(AtletaDados dados){
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.peso = dados.peso();
        this.altura = dados.altura();
    }

    public double calcIMC(){
        double imc = this.peso/(this.altura*this.altura);
        return imc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Atleta [nome=" + nome + ", idade=" + idade + ", peso=" + peso + ", altura=" + altura + "]";
    }
}
