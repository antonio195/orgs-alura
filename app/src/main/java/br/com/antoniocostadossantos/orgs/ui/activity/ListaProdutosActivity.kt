package br.com.antoniocostadossantos.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.antoniocostadossantos.orgs.dao.ProdutosDAO
import br.com.antoniocostadossantos.orgs.databinding.ActivityListaProdutosBinding
import br.com.antoniocostadossantos.orgs.ui.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaProdutosBinding
    private val dao = ProdutosDAO()
    private val adapterProdutos = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

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
        adapterProdutos.atualizaProdutos(dao.buscaTodos())
    }

    private fun novoProduto() {
        val intent = Intent(this@ListaProdutosActivity, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun initRecyclerViewProdutos() {
        val recyclerView = binding.rvProdutos
        recyclerView.adapter = adapterProdutos
    }
}