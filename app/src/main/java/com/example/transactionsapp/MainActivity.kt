package com.example.transactionsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.LocalContext
import com.example.transactionsapp.model.Transaction
import com.example.transactionsapp.ui.DetailScreen
import com.example.transactionsapp.ui.HomeScreen

val transactions = mutableListOf<Transaction>(
    Transaction(1, 100.0, "Deposit", "2023-07-20"),
    Transaction(2, 50.0, "Withdrawal", "2023-07-21"),
    Transaction(3, 200.0, "Deposit", "2023-07-22"),
    Transaction(4, 75.0, "Withdrawal", "2023-07-23"),
    Transaction(5, 300.0, "Deposit", "2023-07-24")
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                val context = LocalContext.current

                HomeScreen(transactions,
                    onTransactionClick = { transaction ->
                        val intent = Intent(
                            context,
                            DetailScreen::class.java
                        )
                        intent.putExtra("transaction_id", transaction.id)
                        intent.putExtra("amount", transaction.amount)
                        intent.putExtra("typve", transaction.type)
                        intent.putExtra("date", transaction.date)
                        context.startActivity(intent)
                    }
                )
            }
        }
        
    }

}