package com.example.filmsmvvm.presentation.fragments.fragments

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.filmsmvvm.databinding.FragmentFeedBinding
import com.example.filmsmvvm.presentation.fragments.adapters.HitsAdapter
import com.example.filmsmvvm.presentation.service.MusicService
import com.example.filmsmvvm.presentation.view_models.HitsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment() {

    private val viewModel: HitsViewModel by viewModels()
    var binding: FragmentFeedBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFeedBinding.inflate(inflater, container, false)
        this.binding = binding

        val adapter = HitsAdapter()
        binding.hitsRecycler.adapter = adapter

        viewModel.hitsList.observe(viewLifecycleOwner) { response ->
            response.hits?.let {
                adapter.setData(images = it)
            }
        }

        binding.apply {
            editQuery.addTextChangedListener { editable ->
                viewModel.search(query = editable.toString())
            }

            serviceButton.setOnClickListener {
                startOrStopService()
            }
        }

        return binding.root
    }

    private fun startOrStopService() {
        if (isMusicServiceRunning()) {
            //TODO remove after test
            Toast.makeText(this.context, "Stop Service", Toast.LENGTH_SHORT).show()
            this.context?.stopService(Intent(this.context, MusicService::class.java))
        } else {
            //TODO remove after test
            Toast.makeText(this.context, "Start Service", Toast.LENGTH_SHORT).show()
            this.context?.startService(Intent(this.context, MusicService::class.java))
        }
    }

    //TODO refactor
    private fun isMusicServiceRunning(): Boolean {
        val manager: ActivityManager =
            this.context?.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        for (service: ActivityManager.RunningServiceInfo in manager.getRunningServices(Integer.MAX_VALUE)) {
            if (MusicService::class.java.name.equals(service.service.className)) {
                return true
            }
        }
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}