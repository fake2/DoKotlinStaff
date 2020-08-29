package com.bryuhoveckiy.dokotlinstaff.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(private val state: SavedStateHandle) : ViewModel() {
    fun saveName(name: String) {
        state.set("Name", name)
    }

    fun getName(): String? {
        return state.get<String>("Name")
    }
}