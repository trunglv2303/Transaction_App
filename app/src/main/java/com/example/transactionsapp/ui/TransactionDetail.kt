package com.example.transactionsapp.ui

import android.os.Bundle
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class DetailScreen : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getIntExtra("transaction_id", -1)
        val amount = intent.getDoubleExtra("amount", 0.0)
        val type = intent.getStringExtra("type") ?: ""
        val date = intent.getStringExtra("date") ?: "" 
        setContent {
            MaterialTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text(text = "Transaction Detail") })
                    },
                ) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
                        Text(text = "Transaction ID: $id")
                        Text(text = "Amount: $amount")
                        Text(text = "Type: $type")
                        Text(text = "Date: $date")
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick={ 
                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Transaction ID: $id\nAmount: $amount\nType: $type\nDate: $date")
                            startActivity(Intent.createChooser(shareIntent, "Share Transaction"))
                        }){
                            Text("Chia sẻ giao dịch")

                        }
                    }
                }
            }
        }
    }
}
