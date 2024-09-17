package com.example.mad_practical_3_22012011105

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun explicit_intent() {
        val login_button = findViewById<Button>(R.id.button6)
        login_button.setOnClickListener {
            Intent(this, LoginActivity::class.java)
                .putExtra("username", "feefweferw")
                .putExtra("password", "wkccec").also { startActivity(it) }
            //you can create variable of this intent as i = intent and then pass it as : startActivity(i) OR you can simply use also{}
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }


    fun implicitIntent() {
        //browse URL
        findViewById<Button>(R.id.browse_btn).setOnClickListener {
//                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")).also { startActivity(it) }
            Intent(Intent.ACTION_VIEW, Uri.parse("http://khkjn.com")).also { startActivity(it) }
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            val number = findViewById<
                    EditText>(R.id.editTextText).text.toString()
            Intent(Intent.ACTION_DIAL).setData(Uri.parse(number)).also { startActivity(it) }
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
        }

        
        findViewById<Button>(R.id.button3).setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it)
            }

        findViewById<Button>(R.id.button5).setOnClickListener{
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
        }
        }
    }
}
