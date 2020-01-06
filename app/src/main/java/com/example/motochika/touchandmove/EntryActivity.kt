package com.example.motochika.touchandmove

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_entry.*
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

class EntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)




        val actionBar = supportActionBar

        actionBar!!.hide()

        entry_okame_button.setOnClickListener {


            startActivity(Intent(this,MainActivity::class.java))
        }

        entry_hyottoko_button.setOnClickListener {


            startActivity(Intent(this,SecondFaceActivity::class.java))
        }

        license.setOnClickListener {

            startActivity(Intent(this, OssLicensesMenuActivity::class.java))
        }



    }
}
