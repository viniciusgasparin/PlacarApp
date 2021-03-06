package br.com.fiap.placarapp

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class PlacarViewModel: ViewModel() {

    var goalHome: MutableLiveData<Int> = MutableLiveData()
    var goalAway: MutableLiveData<Int> = MutableLiveData()

    init {
        startGame()
    }

    fun startGame() {
        goalAway.value = 0
        goalHome.value = 0
    }

    fun goalAway() {
        goalAway.value = goalAway.value?.plus(+1)
    }

    fun goalHome() {
        goalHome.value = goalHome.value?.plus(+1)
    }

    fun resetPlacar() {
        startGame()
    }
}