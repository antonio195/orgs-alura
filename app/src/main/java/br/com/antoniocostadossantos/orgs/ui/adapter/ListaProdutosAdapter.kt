package br.com.antoniocostadossantos.orgs.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.antoniocostadossantos.orgs.databinding.ProdutoItemBinding
import br.com.antoniocostadossantos.orgs.extensions.tentaCarregarImagem
import br.com.antoniocostadossantos.orgs.model.Produto
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

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
            val imagem = binding.ivImagemProduto

            val moedaFormatada: String = valorParaBrl(produto.precoProduto)

            nome.text = produto.nomeProduto
            descricao.text = produto.descricaoProduto
            preco.text = moedaFormatada

            imagem.tentaCarregarImagem(produto.imagemUrl)
        }

        private fun valorParaBrl(valor: BigDecimal): String {
            val formatador: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            val moedaFormatada: String = formatador.format(valor)
            return moedaFormatada
        }

    }

    fun atualizaProdutos(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }


}
