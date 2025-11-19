package com.example.demo.koin_di.module

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
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

@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class MyRoomdatabase: RoomDatabase(){
    abstract val personDao: PersonDao
}

@Dao
interface PersonDao{
    @Query("select * from person_table")
    fun getAllPerson():List<Person>
}

@Entity("person_table")
data class Person(val name:String)