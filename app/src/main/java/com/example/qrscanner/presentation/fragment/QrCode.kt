package com.example.qrscanner.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.qrscanner.R
import com.example.qrscanner.databinding.QrCodeBinding
import com.example.qrscanner.presentation.viewModel.QrViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class QrCode: Fragment() {

    private val viewModel by activityViewModels<QrViewModel>()
    private var _binding: QrCodeBinding?= null
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = QrCodeBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.info.observe(viewLifecycleOwner,{
            binding.message.visibility =View.GONE
            binding.group.visibility = View.VISIBLE
            binding.age.text = it.age.toString()
            binding.email.text = it.email
            binding.name.text = it.name
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}