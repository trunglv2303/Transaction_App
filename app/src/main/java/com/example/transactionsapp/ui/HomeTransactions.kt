package com.example.transactionsapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.transactionsapp.model.Transaction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(transactions: List<Transaction>, onTransactionClick: (Transaction) -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home Transactions",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            items(transactions) { transaction ->
                TransactionItem(transaction, onClicks = onTransactionClick)
            }
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction,onClicks: (Transaction) -> Unit = {}) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClicks(transaction) }
    ) {
        Text(text = transaction.id.toString())
        Spacer(modifier = Modifier.width(2.dp))
        Text(text = transaction.type)
        Spacer(modifier = Modifier.width(2.dp))
        Text(text = transaction.amount.toString())
        Spacer(modifier = Modifier.width(2.dp))
        Text(text = transaction.date)
        Spacer(modifier = Modifier.width(2.dp))


    }
}
