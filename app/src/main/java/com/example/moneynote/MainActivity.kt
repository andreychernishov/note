package com.example.moneynote


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moneynote.DataBase.MainDb
import com.example.moneynote.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), InfoAdapter.Listener {

    lateinit var binding: ActivityMainBinding
    private val adapter = InfoAdapter(this)
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = MainDb.getDb(this)
        init()
        editLauncher()

    }

    private fun editLauncher(){
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                adapter.addInfo(it.data?.getSerializableExtra(CONSTANCE.SERIALIZABLE_KEY) as Information)
            }
        }
    }

    private fun init(){
        binding.apply {

            mainRc.layoutManager = GridLayoutManager(this@MainActivity,1)
            mainRc.adapter = adapter
            addBtn.setOnClickListener {
                editLauncher?.launch(Intent(this@MainActivity, EditInfo::class.java))
            }
        }
    }

    override fun onClick(information: Information) {
        startActivity(Intent(this, Content::class.java).apply {
            putExtra(CONSTANCE.SERIALIZABLE_KEY, information)

        })
    }


}