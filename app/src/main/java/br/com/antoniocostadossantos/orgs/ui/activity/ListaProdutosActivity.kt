package br.com.antoniocostadossantos.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.antoniocostadossantos.database.AppDatabase
import br.com.antoniocostadossantos.orgs.databinding.ActivityListaProdutosBinding
import br.com.antoniocostadossantos.orgs.ui.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaProdutosBinding
    private val database = AppDatabase
    private val adapterProdutos = ListaProdutosAdapter(context = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerViewProdutos()

        binding.btnNovoProduto.setOnClickListener {
            novoProduto()
        }
    }

    override fun onResume() {
        super.onResume()
        val produtoDao = database.getDatabaseInstance(this).produtoDao()
        adapterProdutos.atualizaProdutos(produtoDao.buscaTodos())
    }

    private fun novoProduto() {
        val intent = Intent(this@ListaProdutosActivity, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun initRecyclerViewProdutos() {
        val recyclerView = binding.rvProdutos
        recyclerView.adapter = adapterProdutos

        adapterProdutos.quandoClicaNoItem = {
            val intent = Intent(
                this,
                DetalhesProdutoActivity::class.java
            ).apply {
                putExtra("CHAVE_PRODUTO", it)
            }
            startActivity(intent)
        }
    }
}