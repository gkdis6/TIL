package com.sy.anew

import android.media.audiofx.DynamicsProcessing
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.sy.anew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}

class Solution {
    fun solution(record: Array<String>): Array<String> {
        val names = mutableMapOf<String, String>()
        for (r in record){
            val s = r.split(' ')
            if (s[0]=="Enter" || s[0]=="Change"){
                names[s[1]] = s[2]
            }
        }
        var answer = mutableListOf<String>()
        for(r in record){
            val s = r.split(' ')
            when(s[0]){
                "Enter"-> answer.add("${names[s[1]]}님이 들어왔습니다.")
                "Leave"-> answer.add("${names[s[1]]}님이 나갔습니다.")
            }
        }
        return answer.toTypedArray()
    }
}
class Stage(var level:Int, var pass:Int, var fail:Int){
    val failRate:Float
    get() = if (fail+pass == 0) 0.0f else (fail.toFloat()) / (pass+fail)
}

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var s = stages.size
        val list = mutableListOf<Int>()
        var stageInfo = Array(N, {Stage(it + 1, 0, 0) })

        for(i in 1 .. N+1) {
            var count = stages.count(i)
            var r = count/s
            list[i] = r

        }
        var answer = intArrayOf()
        return list.toIntArray()
    }
}

