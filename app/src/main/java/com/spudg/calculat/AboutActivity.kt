package com.spudg.calculat

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spudg.calculat.databinding.ActivityAboutBinding
import com.spudg.calculat.databinding.DialogTermsOfUseBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var bindingAbout: ActivityAboutBinding
    private lateinit var bindingTermsOfUse: DialogTermsOfUseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingAbout = ActivityAboutBinding.inflate(layoutInflater)
        val view = bindingAbout.root
        setContentView(view)

        val version = packageManager.getPackageInfo(packageName, 0).versionName
        bindingAbout.calculatDesc.text = getString(R.string.version_by_ss, version.toString())


        bindingAbout.backToCalcListFromAbout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        bindingAbout.privacyPolicy.setOnClickListener {
            privacyPolicy()
        }

        bindingAbout.termsOfUse.setOnClickListener {
            termsOfUse()
        }

        bindingAbout.rateBtn.setOnClickListener {
            rate()
        }

    }

    private fun privacyPolicy() {
        val url =
            "https://docs.google.com/document/d/1A4TPL2AEzE3EAkpb3mr9iy5pY6ehhVr_gfAwbP8q_a8"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun termsOfUse() {
        val termsOfUseDialog = Dialog(this, R.style.Theme_Dialog)
        termsOfUseDialog.setCancelable(false)
        bindingTermsOfUse = DialogTermsOfUseBinding.inflate(layoutInflater)
        val view = bindingTermsOfUse.root
        termsOfUseDialog.setContentView(view)
        termsOfUseDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        bindingTermsOfUse.tvDoneTU.setOnClickListener {
            termsOfUseDialog.dismiss()
        }

        termsOfUseDialog.show()

    }

    private fun rate() {
        val url =
            "https://play.google.com/store/apps/details?id=com.spudg.calculat"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

}