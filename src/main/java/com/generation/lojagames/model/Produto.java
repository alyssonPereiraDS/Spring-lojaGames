package com.generation.lojagames.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotBlank(message = "o atributo nome deve ser preenchido")
    @Size(min = 5, max = 20, message = "o atributo nome deve ter no minimo 5 caracteres e no máximo 20 caracteres")
    private String nome;

    @NotBlank(message = "o atributo plataforma deve ser preenchido")
    @Size(min = 2, max = 20, message = "o atributo plataforma deve ter no minimo 2 caracteres e no máximo 20 caracteres")
    private String plataforma;

    @NotNull(message = "o atributo preço não pode ser nulo")
    @PositiveOrZero(message = "o atributo preço deve ser positivo")
    private BigDecimal preco;

    @NotBlank(message = "o atributo desenvolvedora deve ser preenchido")
    @Size(min = 2, max = 20, message = "o atributo desenvolvedora deve ter no minimo 2 caracteres e no máximo 20")
    private String desenvolvedora;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }
}
