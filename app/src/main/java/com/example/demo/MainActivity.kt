package com.example.demo

import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat
import androidx.core.view.WindowCompat.enableEdgeToEdge
import com.example.demo.koin_di.model.Car
import com.example.demo.koin_di.model.StorageType
import com.example.demo.koin_di.model.StoreInFirebase
import com.example.demo.retrofit.apiService
import com.example.demo.ui.theme.DemoTheme
import io.ktor.http.parameters
import io.ktor.http.parametersOf
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.inject

class MainActivity : ComponentActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val car: Car by inject(Car::class.java)
    val firebase: StoreInFirebase by inject(StoreInFirebase::class.java)
    val storageType: StorageType by inject(StorageType::class.java,qualifier = named("storeInFirebase")){
        org.koin.core.parameter.parametersOf("how.....")
    }
    Button(onClick = {
        /*println(">>>>>>>>>>>>>>>> ${car.running()}")
        println(">>>>>>>>fireabase>>>>>>>> ${firebase.saveData("firbase")}")*/
        storageType.saveThis()
    }){
        Text(text = name)
    }
}

@Composable
fun GreetingPreview() {
    DemoTheme {
        Greeting("feature 5")
    }
}