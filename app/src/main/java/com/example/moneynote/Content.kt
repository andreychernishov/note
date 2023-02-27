package com.example.moneynote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.moneynote.DataBase.MainDb

class Content : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        val item = intent.getSerializableExtra(CONSTANCE.SERIALIZABLE_KEY) as Information

        val contentNameTv: TextView = findViewById(R.id.content_name_tv)
        val contentSumTv: TextView = findViewById(R.id.content_sum_tv)
        contentNameTv.text = item.bankName
        contentSumTv.text = item.money

    }
}