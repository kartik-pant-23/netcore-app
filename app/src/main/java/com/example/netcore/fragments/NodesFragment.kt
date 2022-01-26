package com.example.netcore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netcore.adapter.NodesAdapter
import com.example.netcore.databinding.FragmentNodesBinding
import com.example.netcore.view_models.MainActivityViewModel

class NodesFragment: Fragment() {

    private var binding: FragmentNodesBinding? = null
    private val viewModel by activityViewModels<MainActivityViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNodesBinding.inflate(inflater, container, false)

        val listAdapter = NodesAdapter { itemView, node_id ->
            val action = NodesFragmentDirections.actionNodesFragmentToDetailsFragment(node_id)
            itemView.findNavController().navigate(action)
        }
        binding?.nodesList?.apply {
                adapter = listAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        viewModel.graphResponse.observe(viewLifecycleOwner) {
            binding?.nodesListLoading?.visibility = View.GONE
            listAdapter.submitList(it.nodes)
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}