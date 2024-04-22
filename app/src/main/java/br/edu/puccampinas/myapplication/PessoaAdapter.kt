package br.edu.puccampinas.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PessoaAdapter:
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    //adapter
    private var items: List<Pessoa> = ArrayList()

    class PessoaViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        private val name = itemView.findViewById<TextView>(R.id.tvName)
        private val age = itemView.findViewById<TextView>(R.id.tvAge)

        fun bind(pessoa: Pessoa){
            name.text = pessoa.name
            age.text = pessoa.age
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PessoaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.main_rv, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PessoaViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    fun setData(pessoa: List<Pessoa>){
        items = pessoa
    }

}