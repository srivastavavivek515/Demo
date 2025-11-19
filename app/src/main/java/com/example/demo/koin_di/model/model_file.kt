package com.example.demo.koin_di.model

class Engine(){
    fun started(){
        print("Engine has started")
    }
}

class Wheel{
    fun move(){
        print("Wheel is moving")
    }
}

class Car(val engine: Engine,val wheel: Wheel){
    fun running(){
        engine.started()
        wheel.move()
    }
}

interface StorageService
{
    fun saveData(data:String)
}

class StoreInFirebase: StorageService{
    override fun saveData(data: String) {
        println("Data stored in firebase  $data")
    }

}

class StoreLocal: StorageService{
    override fun saveData(data: String) {
        println("Data stored in locally..... $data")
    }
}

class StorageType(val storageService: StorageService,val data:String){
    fun saveThis(){
        storageService.saveData(data)
    }
}


