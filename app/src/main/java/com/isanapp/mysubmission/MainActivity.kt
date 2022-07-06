package com.isanapp.mysubmission

import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_DATA
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvGove: RecyclerView
    private val list = ArrayList<government>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvGove = findViewById(R.id.government_id)
        rvGove.setHasFixedSize(true)

        list.addAll(listGovernment)
        showRecyclerList()
    }
    private val listGovernment: ArrayList<government>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val datausername = resources.getStringArray(R.array.data_username)
            val dataPhoto = resources.obtainTypedArray(R.array.data_avatar)
            val datafollower = resources.getStringArray(R.array.data_follower)
            val datafolowing = resources.getStringArray(R.array.data_following)
            val datacompany = resources.getStringArray(R.array.data_company)
            val datalocation = resources.getStringArray(R.array.data_location)
            val listHero = ArrayList<government>()
            for (i in dataName.indices) {
                val hero = government(dataName[i],datausername[i],datafollower[i],datafolowing[i],datacompany[i],datalocation[i], dataPhoto.getResourceId(i, -1))
                listHero.add(hero)
            }
            return listHero
        }
    private fun showRecyclerList() {
        rvGove.layoutManager = LinearLayoutManager(this)
        val listGoveAdapter = ListGoveAdapter(list)
        rvGove.adapter = listGoveAdapter

        listGoveAdapter.setOnItemClickCallback(object : ListGoveAdapter.OnItemClickCallback {
            override fun onItemClicked(data: government) {
                showSelectedHero(data)
                val moveIntent = Intent(this@MainActivity, Detail::class.java)
                moveIntent.putExtra(Detail.EXTRA_DATA, data)
                startActivity(moveIntent)
            }
        })


    }
    private fun showSelectedHero(gove: government) {
        Toast.makeText(this, "Kamu memilih " + gove.name, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }


}

