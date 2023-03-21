package br.com.antoniocostadossantos.orgs.dao

import br.com.antoniocostadossantos.orgs.model.Produto
import java.math.BigDecimal

class ProdutosDAO {

    fun adicionarProduto(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>(
            Produto(
                nomeProduto = "Salada de frutas",
                descricaoProduto = "Laranja, uva, banana",
                precoProduto = BigDecimal(19.90)
            )
        )
    }

}