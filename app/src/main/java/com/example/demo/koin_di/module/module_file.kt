package com.example.demo.koin_di.module

import android.R.attr.data
import androidx.compose.material3.Card
import com.example.demo.koin_di.model.Car
import com.example.demo.koin_di.model.Engine
import com.example.demo.koin_di.model.StorageService
import com.example.demo.koin_di.model.StorageType
import com.example.demo.koin_di.model.StoreInFirebase
import com.example.demo.koin_di.model.StoreLocal
import com.example.demo.koin_di.model.Wheel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val carModule = module {
    factory {
        Engine()
    }
    factory {
        Wheel()
    }
    factory {
        Car(get(),get())
    }

    single {
        StoreInFirebase()
    }
    single {
        StoreLocal()
    }

    single(named("local")) {(data:String)->
        StorageType(get<StoreLocal>(),data)
    }

    single(named("storeInFirebase")) {(data:String)->
        StorageType(get<StoreInFirebase>(),data)
    }


}