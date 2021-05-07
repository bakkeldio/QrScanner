package com.example.qrscanner.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qrscanner.databinding.ListQrsBinding
import com.example.qrscanner.presentation.adapter.ListQrAdapter
import com.example.qrscanner.presentation.viewModel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListOfQrCodes: Fragment() {

    private val viewModel by viewModels<ListViewModel>()


    private var _binding :ListQrsBinding?=null

    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ListQrsBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.list.observe(viewLifecycleOwner, {
            Log.d("Size of list",it.size.toString())
            val listQrAdapter = ListQrAdapter()
            listQrAdapter.submitList(it)
            binding.recyclerView.adapter = listQrAdapter
            binding.recyclerView.addItemDecoration(DividerItemDecoration(context,
                LinearLayoutManager.VERTICAL))
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null

    }



}