package com.indivara.auliariwayanto.memberiddevtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_signin.setOnClickListener {
            setupView()
        }

    }

    fun setupView(){
        if (et_signin.text.isNullOrEmpty() || et_signin.text.equals("")){
            Toast.makeText(this,"email address can't be empty",Toast.LENGTH_LONG).show()
        } else if (!isEmailValid(et_signin.text.toString())){
            Toast.makeText(this,"wrong format email",Toast.LENGTH_LONG).show()
        } else {
            val intent = Intent(this,BerandaActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }

    fun isEmailValid(email: String): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}
