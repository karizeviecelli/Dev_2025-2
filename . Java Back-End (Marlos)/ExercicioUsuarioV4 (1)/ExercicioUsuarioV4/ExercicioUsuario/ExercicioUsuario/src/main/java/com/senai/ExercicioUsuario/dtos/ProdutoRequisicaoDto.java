    package com.senai.ExercicioUsuario.dtos;

    public class ProdutoRequisicaoDto {
        private Long id;
        private String nome;
        private Double preco;
        private Long categoriaId;

        public ProdutoRequisicaoDto() {
        }

        public ProdutoRequisicaoDto(Long id, String nome, Double preco, Long categoriaId) {
            this.id = id;
            this.nome = nome;
            this.preco = preco;
            this.categoriaId = categoriaId;
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

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }

        public Long getCategoriaId() {
            return categoriaId;
        }

        public void setCategoriaId(Long categoriaId) {
            this.categoriaId = categoriaId;
        }
    }
