package com.aleksandrbelous.coroutinetry.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.aleksandrbelous.coroutinetry.databinding.HomeFragmentBinding
import com.aleksandrbelous.coroutinetry.network.MovieItem

/**
 * @author Aleksandr Belous
 * @since 7/9/20.
 */
class HomeFragment : Fragment() {

    private lateinit var viewBinding: HomeFragmentBinding
    private val viewModel = HomeViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.result.observe(this) {
            setList(it)
        }

        viewModel.loadList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = HomeFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.list.layoutManager = LinearLayoutManager(context, VERTICAL, false)

    }

    private fun setList(items: List<MovieItem>) {
        val adapter = HomeListAdapter(items)
        viewBinding.list.adapter = adapter

    }
}