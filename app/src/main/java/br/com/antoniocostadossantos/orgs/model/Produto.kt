package br.com.antoniocostadossantos.orgs.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Entity
@Parcelize
data class Produto(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    var nomeProduto: String,
    var descricaoProduto: String,
    var precoProduto: BigDecimal,
    var imagemUrl: String? = null
) : Parcelable