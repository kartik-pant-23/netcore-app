package com.example.netcore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.netcore.api.entities.Node
import com.example.netcore.data.Graph
import com.example.netcore.databinding.FragmentDetailsBinding
import com.example.netcore.databinding.FragmentNodesBinding
import com.example.netcore.view_models.MainActivityViewModel

class DetailsFragment: Fragment() {

    private var binding: FragmentDetailsBinding? = null
    private val viewModel by activityViewModels<MainActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        arguments?.let {
            val node = viewModel.getNodeFromId(it.getInt("node_id"))
            binding?.apply {
                name.text = node.data.properties.name
                data.text = getNodesDetails(node)
                investedAtData.text = viewModel.getInvestedAt(node.id).toString()
                gotInvestmentFrom.text = viewModel.getInvestmentFrom(node.id).toString()
            }
        }

        binding?.backButton?.setOnClickListener {
            it.findNavController().navigateUp()
        }

        return binding?.root
    }

    private fun getNodesDetails(node: Node): String {
        val category = node.data.categories.toString()
        val properties = node.data.properties
        var data = ""
        data = data.plus("""
            Category - $category
            URL - ${properties.url}
        """.trimIndent())
        if (node.data.categories?.contains(Graph.COMPANY) ?: false) {
            data = data.plus("""
                
                MarketCategory - ${properties.category ?: "Error"}
                FoundedAt - ${properties.foundedAt ?: "Error"}
                HomePageURL - ${properties.homepageUrl ?: "Error"}
                Region - ${properties.region ?: "Error"}
                State - ${properties.state}
                Country - ${properties.country ?: "Error"}
                Status - ${properties.status ?: "Error"}
            """.trimIndent())
        }
        data = data.replace("\n", System.getProperty("line.separator"))
        return data
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}