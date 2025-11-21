package com.example.demo.koin_di.module

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(get(), MyRoomdatabase::class.java,"myroom").build()
    }
    single {
        get<MyRoomdatabase>().personDao
    }
}

@Database(entities = [Person1::class], version = 1, exportSchema = false)
abstract class MyRoomdatabase: RoomDatabase(){
    abstract val personDao: PersonDao
}

@Dao
interface PersonDao{
    @Query("select * from person_table")
    fun getAllPerson():List<Person1>
}

@Entity("person_table")
data class Person1(val name:String,@PrimaryKey(autoGenerate = true) val id:Int)