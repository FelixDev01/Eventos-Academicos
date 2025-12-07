package com.eventos.academicos.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_atividades")
public class Atividade {
    /// MANY TO ONE (* - 1)

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Atividade() {
    }

    public Atividade(Double preco, String descricao, String nome, Integer id) {
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}