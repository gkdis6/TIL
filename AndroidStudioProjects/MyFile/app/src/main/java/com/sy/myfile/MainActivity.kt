package com.sy.myfile

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.preference.PreferenceManager
import com.sy.myfile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val a = FileUtil()

        a.writeTextFile("$filesDir", "filename.txt", "글의 내용")
        var content = ""
        var contents = ""

        val shared = getSharedPreferences("이름", Context.MODE_PRIVATE) //context를 가진 모든 컴포넌트에서 접근 및 호출 가능
        var preference = getPreferences(Context.MODE_PRIVATE) //액티비티 하나만 사용하는 앱일 경우
        val editor = shared.edit()
        editor.putString("키", "값")
        editor.apply() //apply를 해야 저장이 됨
        shared.getString("키", "기본값")

        val shared2 = PreferenceManager.getDefaultSharedPreferences(this)

        val checkboxValue = shared2.getBoolean("key_add_shortcut", false)
        val switchValue = shared2.getBoolean("key_switch_on", false)
        val nameValue = shared2.getString("key_edit_name", "")
        val selected = shared2.getString("key_set_item", "")

        Log.d("shared", checkboxValue.toString())
        Log.d("shared", switchValue.toString())
        Log.d("shared", nameValue?:"")
        Log.d("shared", selected?:"")
    }
}