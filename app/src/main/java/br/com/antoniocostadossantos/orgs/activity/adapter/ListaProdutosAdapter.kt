package br.com.antoniocostadossantos.orgs.activity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.antoniocostadossantos.orgs.databinding.ProdutoItemBinding
import br.com.antoniocostadossantos.orgs.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>
) :
    RecyclerView.Adapter<ListaProdutosAdapter.ProdutosViewHolder>() {

    private val produtos = produtos.toMutableList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProdutosViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProdutosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        holder.bind(produtos[position])
    }

    override fun getItemCount() = produtos.size

    class ProdutosViewHolder(val binding: ProdutoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(produto: Produto) {
            val nome = binding.tvNomeProduto
            val descricao = binding.tvDescricaoProduto
            val preco = binding.tvPrecoProduto

            nome.text = produto.nomeProduto
            descricao.text = produto.descricaoProduto
            preco.text = produto.precoProduto.toPlainString()
        }

    }

    fun atualizaProdutos(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }


}
