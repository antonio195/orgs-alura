package br.com.antoniocostadossantos.orgs.extensions

import android.widget.ImageView
import br.com.antoniocostadossantos.orgs.R
import coil.load

fun ImageView.tentaCarregarImagem(url: String? = null) {
    load(url) {
        fallback(R.drawable.erro)
        error(R.drawable.erro)
    }
}