package br.edu.puccampinas.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var pessoaAdapter: PessoaAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list = ArrayList<Pessoa>()

        list.add(
            (Pessoa("Vinícius", "19") )
        )
        list.add(
            Pessoa("Celso", "45")
        )

        initRecyclerView()
        addDate(list)
    }

    private fun initRecyclerView(){
        pessoaAdapter = PessoaAdapter()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = pessoaAdapter
    }

    private fun addDate(list: ArrayList<Pessoa>){
        pessoaAdapter.setData(list)
    }
}