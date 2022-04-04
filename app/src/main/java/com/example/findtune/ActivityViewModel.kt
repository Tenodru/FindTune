package com.example.findtune

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {
    val albumName = MutableLiveData<String>()
    val albumArtist = MutableLiveData<String>()
}