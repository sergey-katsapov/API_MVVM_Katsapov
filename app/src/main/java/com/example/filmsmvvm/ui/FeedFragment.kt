package com.example.filmsmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.filmsmvvm.databinding.FragmentFeedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment() {

    val viewModel: FeedViewModel by viewModels()
    var binding: FragmentFeedBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFeedBinding.inflate(inflater, container, false)
        this.binding = binding

        val adapter = ImagesAdapter()
        binding.hitsRecycler.adapter = adapter

        viewModel.response.observe(viewLifecycleOwner) { response ->
            response.hits?.let {
                adapter.setData(it)
            }
        }

        binding.editQuery.addTextChangedListener { editable ->
            viewModel.search(query = editable.toString())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}