package br.com.antoniocostadossantos.orgs.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.antoniocostadossantos.orgs.dao.ProdutosDAO
import br.com.antoniocostadossantos.orgs.databinding.ActivityFormularioProdutoBinding
import br.com.antoniocostadossantos.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormularioProdutoBinding
    private val dao = ProdutosDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNovoProduto.setOnClickListener {
            novoProduto()
        }
    }

    private fun novoProduto() {
        val inputNome = binding.etNomeProduto.text.toString()
        val inputDescricao = binding.etDescricaoProduto.text.toString()

        val inputPreco = binding.etPrecoProduto.text.toString()
        val precoValidado = if (inputPreco.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(inputPreco)
        }

        val novoProduto = Produto(
            nomeProduto = inputNome,
            descricaoProduto = inputDescricao,
            precoProduto = precoValidado
        )
        dao.adicionarProduto(novoProduto)
        finish()
    }
}