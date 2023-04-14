package br.com.antoniocostadossantos.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.antoniocostadossantos.database.converter.Converters
import br.com.antoniocostadossantos.database.dao.ProdutoDao
import br.com.antoniocostadossantos.orgs.model.Produto

@Database(entities = [Produto::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun produtoDao(): ProdutoDao

    companion object {
        fun getDatabaseInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "orgs.db"
            )
                .allowMainThreadQueries()
                .build()

        }
    }

}