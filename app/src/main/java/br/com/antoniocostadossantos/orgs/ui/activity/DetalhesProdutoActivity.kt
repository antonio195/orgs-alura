package br.com.antoniocostadossantos.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.antoniocostadossantos.orgs.databinding.ActivityDetalhesProdutoBinding
import br.com.antoniocostadossantos.orgs.extensions.tentaCarregarImagem
import br.com.antoniocostadossantos.orgs.model.Produto

class DetalhesProdutoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesProdutoBinding
    private lateinit var produto: Produto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        produto = intent.getParcelableExtra("CHAVE_PRODUTO")!!

        setupProduto()
    }

    private fun setupProduto() {
        binding.ivImagemProduto.tentaCarregarImagem(produto.imagemUrl)
        binding.etNomeProduto.text = produto.nomeProduto
        binding.etValorProduto.text = produto.precoProduto.toPlainString()
        binding.etDescricaoProduto.text = produto.descricaoProduto
    }
}