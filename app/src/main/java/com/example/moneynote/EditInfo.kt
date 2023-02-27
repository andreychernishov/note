package com.example.moneynote

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.example.moneynote.DataBase.BaseItem
import com.example.moneynote.DataBase.MainDb
import com.example.moneynote.databinding.ActivityEditInfoBinding

class EditInfo : AppCompatActivity() {

    lateinit var binding: ActivityEditInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtons()

    }

    private fun initButtons() = with(binding){
        doneBtn.setOnClickListener {
            val info = Information(bankNameEd.text.toString(), sumEd.text.toString())

            val item = BaseItem(null, bankNameEd.text.toString(),sumEd.text.toString())
            val db = MainDb.getDb(this@EditInfo)
            db.getDao().getAllItem().asLiveData().observe(this@EditInfo){

            }

            Thread{
                db.getDao().insertItem(item)
            }.start()

            val editIntent = Intent().apply {
                putExtra(CONSTANCE.SERIALIZABLE_KEY, info)
            }

            setResult(RESULT_OK,editIntent)
            finish()
        }
    }
}