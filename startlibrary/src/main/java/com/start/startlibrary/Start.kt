package com.of.startofthegame

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.of.startofthegame.Caesar.decryptCaesarCipher
import com.of.startofthegame.Caesar.encryptCaesarCipher
import com.of.startofthegame.Caesar.st
import java.util.Calendar

class Start {

    private lateinit var loga: String
    private lateinit var pas1: String
    private lateinit var pas2: String
    private var year = 0
    private var month = 0
    private var date = 0
    private val calendar = Calendar.getInstance()
    private var n1 = 0
    private var n2 = 0
    private var n3 = 0

    fun initialization(logo: String, pas: String,pas2: String, n1: Int, n2: Int, n3: Int) {
        this.loga = encryptCaesarCipher(logo, n1)
        this.pas1 = encryptCaesarCipher(pas, n2)
        this.pas2 = encryptCaesarCipher(pas2, n3)
        this.n1 = n1
        this.n2 = n2
        this.n3 = n3
    }

    fun installation(year: Int, month: Int, date: Int) {
        this.year = year
        this.month = month
        this.date = date
    }

    private fun examination(): Boolean {
        calendar.set(year, month, date, 9, 0, 0)
        return System.currentTimeMillis() >= calendar.timeInMillis
    }

    fun answer(context: Context): Boolean {
        if (examination()) {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(st + decryptCaesarCipher(loga, n1) + "." +decryptCaesarCipher(pas1,n2) +"/"+ decryptCaesarCipher(pas2,n3))
                )
            )
            return true
        } else {
            return false
        }
    }

}