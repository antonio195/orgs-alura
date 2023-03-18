package br.com.antoniocostadossantos.orgs.dao

import br.com.antoniocostadossantos.orgs.model.Produto

class ProdutosDAO {

    fun adicionarProduto(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }

}