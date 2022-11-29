package com.generation.lojagames.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "o atributo nome deve ser preenchido")
    @Size(min = 5, max = 20, message = "o atributo nome deve ter no minimo 5 caracteres e no máximo 20 caracteres")
    private String nome;

    @NotBlank(message = "o atributo descrição deve ser preenchido")
    @Size(min = 10, max = 100, message = "o atributo descrição deve ter no minimo 20 caracteres e no máximo 100 caracteres")
    private String descricao;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
