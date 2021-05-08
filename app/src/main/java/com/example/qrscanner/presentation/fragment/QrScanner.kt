package com.example.qrscanner.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.qrscanner.R
import com.example.qrscanner.databinding.QrScannerBinding
import com.example.qrscanner.domain.model.QrModel
import com.example.qrscanner.presentation.activity.MainActivity
import com.example.qrscanner.presentation.viewModel.QrViewModel
import com.google.gson.Gson
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.CaptureActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class QrScanner : Fragment() {

    private val viewModel by activityViewModels<QrViewModel>()

    private var qrScanIntegrator: IntentIntegrator? = null

    private var _binding: QrScannerBinding? = null

    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = QrScannerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        qrScanIntegrator = IntentIntegrator.forSupportFragment(this)
        qrScanIntegrator?.setOrientationLocked(false)
        qrScanIntegrator?.setPrompt(requireContext().getString(R.string.prompt))
        qrScanIntegrator?.captureActivity = CaptureActivity::class.java
        qrScanIntegrator?.setBeepEnabled(false)
        binding.makeScan.setOnClickListener {
            qrScanIntegrator?.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {

            val activity = activity as MainActivity
            val model = Gson().fromJson(result.contents, QrModel::class.java)
            viewModel.sendScannedQr(model)
            viewModel.insertQrToDb(model)
            activity.onBottomClick()

        }else{
            super.onActivityResult(requestCode,resultCode,data)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}