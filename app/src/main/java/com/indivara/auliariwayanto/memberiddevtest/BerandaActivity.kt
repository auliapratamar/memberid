package com.indivara.auliariwayanto.memberiddevtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.indivara.auliariwayanto.memberiddevtest.adapter.ListRewardAdapter
import com.indivara.auliariwayanto.memberiddevtest.data.Identification
import com.indivara.auliariwayanto.memberiddevtest.data.RewardData
import java.util.ArrayList

class BerandaActivity : AppCompatActivity() {

    private var rvReward: androidx.recyclerview.widget.RecyclerView? = null
    private val list = ArrayList<Identification>()
    private var drawerLayout: androidx.drawerlayout.widget.DrawerLayout? = null
    private var nvDrawerView: NavigationView? = null
    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    private var title = "Award"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        setupDrawer()

        rvReward = findViewById(R.id.rv_reward)
        rvReward!!.setHasFixedSize(true)

        list.addAll(RewardData.listData)
        showRecyclerList()
        setActionBarTitle(title)
    }

    fun setupDrawer(){
        nvDrawerView = findViewById(R.id.nvDrawer)
        drawerLayout = findViewById(R.id.drawer)
        actionBarDrawerToggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout?.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle?.syncState()
        nvDrawerView!!.setNavigationItemSelectedListener { item ->
            val id = item.itemId
            when (id) {
                R.id.home -> closeDrawer()
                R.id.logout -> gotologout()
                else -> return@setNavigationItemSelectedListener true
            }

            true
        }
    }

    fun gotologout(){
        val intent = Intent(this,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

    fun closeDrawer(){
        drawerLayout!!.closeDrawers()
    }

    fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.menu_profile -> {
                val intent = Intent(this,FilterActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        setMode(item!!.itemId)
        if (actionBarDrawerToggle!!.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_profile,menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun showRecyclerList() {
        rvReward!!.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        val listRewardAdapter = ListRewardAdapter(list)
        rvReward!!.adapter = listRewardAdapter

        listRewardAdapter.setOnItemClickCallback(object : ListRewardAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Identification) {
                showSelectedHero(data)
            }
        })

    }

    private fun showSelectedHero(identification: Identification) {
        Toast.makeText(this, "Kamu memilih " + identification.name + "\n "
                + identification.poin , Toast.LENGTH_SHORT).show()
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu)
    }
}
