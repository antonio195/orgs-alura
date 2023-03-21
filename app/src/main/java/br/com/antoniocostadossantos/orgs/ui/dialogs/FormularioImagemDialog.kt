package br.com.antoniocostadossantos.orgs.ui.dialogs

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.antoniocostadossantos.orgs.databinding.FormularioImagemBinding
import br.com.antoniocostadossantos.orgs.extensions.tentaCarregarImagem

class FormularioImagemDialog(private val context: Context) {

    fun mostrarImagemDialog(
        urlPadrao: String? = null,
        imagemCarregada: (url: String) -> Unit
    ) {
        val bindingFormImagem =
            FormularioImagemBinding.inflate(LayoutInflater.from(context)).apply {
                urlPadrao.let {
                    etUrl.setText(it)
                    ivImagemProduto.tentaCarregarImagem(it)
                }

                btnCarregarImagem.setOnClickListener {
                    val url = etUrl.text.toString()
                    ivImagemProduto.tentaCarregarImagem(url)
                }
                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Carregar") { _, _ ->
                        val url = etUrl.text.toString()
                        imagemCarregada(url)
                    }
                    .show()
            }
    }

}