package com.example.demo

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService


class NotifActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            createNotificationChannel(LocalContext.current)
            ShowButton()
        }
    }

}

@Composable
fun ShowButton() {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            showNotification(context)
        }) {
            Text("Show Notification")
        }
    }
}

fun createNotificationChannel(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel =
            NotificationChannel("channel_id", "notif", NotificationManager.IMPORTANCE_DEFAULT)

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

    }
}

@RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
fun showNotification(context: Context){
    val builder = NotificationCompat.Builder(context,"channel_id")
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentText("Testing")
        .setContentTitle("title")

    NotificationManagerCompat.from(context).notify(1001,builder.build())

}