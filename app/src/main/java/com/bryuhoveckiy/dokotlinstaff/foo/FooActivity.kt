package com.bryuhoveckiy.dokotlinstaff.foo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bryuhoveckiy.dokotlinstaff.R

class FooActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foo)
    }
}