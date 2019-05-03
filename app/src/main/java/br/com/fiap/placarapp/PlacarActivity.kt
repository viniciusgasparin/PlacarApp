package br.com.fiap.placarapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_placar.*

class PlacarActivity : AppCompatActivity() {

    private lateinit var placarViewModel: PlacarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placar)

        placarViewModel = ViewModelProviders.of(this)
                .get(PlacarViewModel::class.java)

        placarViewModel.goalHome.observe(this, Observer{
            tvPlacarCasa.text = "$it"
        })

        placarViewModel.goalAway.observe(this, Observer{
            tvPlacarVisitante.text = "$it"
        })

        tvTimeCasa.text = intent.getStringExtra("TIME_CASA")
        tvTimeVisitante.text = intent.getStringExtra("TIME_VISITANTE")

        tvPlacarCasa.text = "${placarViewModel.goalHome}"
        tvPlacarVisitante.text = "${placarViewModel.goalAway}"

        btGolCasa.setOnClickListener {
            placarViewModel.goalHome()
        }

        btGolVisitante.setOnClickListener {
            placarViewModel.goalAway()
        }

        btRecomecarPartida.setOnClickListener {
            placarViewModel.resetPlacar()
        }

        btShare.setOnClickListener {
            shareWhatsApp()
        }

    }

    private fun shareWhatsApp() {

    }


}
