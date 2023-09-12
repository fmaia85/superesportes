package edu.pw2.superesportes.model.atleta;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="atleta")
public class Atleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private Double peso;
    private Double altura;

    public Atleta() {}

    public Atleta(String nome, Integer idade, Double peso, Double altura) {
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

    public void atualizaAtleta(AtletaUpdateDados dados){
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.peso = dados.peso();
        this.altura = dados.altura();
    }

    public Double calcIMC(){
        Double imc = null;
        if(this.peso != null && this.altura != null){
            imc = this.peso/(this.altura*this.altura);
        }
        return imc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Atleta [nome=" + nome + ", idade=" + idade + ", peso=" + peso + ", altura=" + altura + "]";
    }
}
