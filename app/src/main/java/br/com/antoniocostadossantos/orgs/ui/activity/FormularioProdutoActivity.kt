package br.com.antoniocostadossantos.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.antoniocostadossantos.orgs.dao.ProdutosDAO
import br.com.antoniocostadossantos.orgs.databinding.ActivityFormularioProdutoBinding
import br.com.antoniocostadossantos.orgs.extensions.tentaCarregarImagem
import br.com.antoniocostadossantos.orgs.model.Produto
import br.com.antoniocostadossantos.orgs.ui.dialogs.FormularioImagemDialog
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormularioProdutoBinding
    private val dao = ProdutosDAO()

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Cadastrar Produto"

        binding = ActivityFormularioProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNovoProduto.setOnClickListener {
            novoProduto()
        }

        binding.ivImagemProduto.setOnClickListener {
            FormularioImagemDialog(this).mostrarImagemDialog(urlPadrao = url) { imagemUrl ->
                url = imagemUrl
                binding.ivImagemProduto.tentaCarregarImagem(url)
            }
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
            precoProduto = precoValidado,
            imagemUrl = url
        )
        dao.adicionarProduto(novoProduto)
        finish()
    }
}