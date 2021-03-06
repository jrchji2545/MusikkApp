package com.example.musikkapp


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.musikkapp.fragments.player.PlayerFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser


       Handler().postDelayed({
               if(user != null){
                 val dashboardIntent = Intent(this, MenuAct::class.java)
                   startActivity(dashboardIntent)


               }else{
                   val signInIntent = Intent(this, SignInActivity::class.java)
                   startActivity(signInIntent)
                   finish()
               }
           },2000)

    }





}

