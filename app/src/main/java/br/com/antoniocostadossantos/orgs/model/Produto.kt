package br.com.antoniocostadossantos.orgs.model

import java.math.BigDecimal

data class Produto(
    var nomeProduto: String,
    var descricaoProduto: String,
    var precoProduto: BigDecimal,
    var imagemUrl: String? = null
)