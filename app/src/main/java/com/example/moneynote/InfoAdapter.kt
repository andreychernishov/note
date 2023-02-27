package com.example.moneynote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneynote.DataBase.MainDb
import com.example.moneynote.databinding.ItemBinding

class InfoAdapter(val listener: Listener): RecyclerView.Adapter<InfoAdapter.InfoHolder>() {

   private val infoList = ArrayList<Information>()

    class InfoHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = ItemBinding.bind(item)

        fun bind(information: Information, listener: Listener){
            binding.sumTv.text = information.money
            binding.textView.text = information.bankName
            itemView.setOnClickListener{
                listener.onClick(information)
            }
        }
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): InfoHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item,p0,false)

        return InfoHolder(view)
    }

    override fun onBindViewHolder(p0: InfoHolder, p1: Int) {
        p0.bind(infoList[p1], listener)
    }

    override fun getItemCount(): Int {
        return infoList.size
    }

    fun addInfo(information: Information){
        infoList.add(information)
        notifyDataSetChanged()
    }

    interface Listener{
        fun onClick(information: Information)
    }

}