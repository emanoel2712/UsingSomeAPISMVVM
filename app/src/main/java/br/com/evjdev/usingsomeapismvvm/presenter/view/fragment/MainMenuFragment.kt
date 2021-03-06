package br.com.evjdev.usingsomeapismvvm.presenter.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.evjdev.usingsomeapismvvm.R
import br.com.evjdev.usingsomeapismvvm.databinding.FragmentMainMenuBinding
import br.com.evjdev.usingsomeapismvvm.presenter.view.adapter.CardAdapter
import br.com.evjdev.usingsomeapismvvm.presenter.viewmodel.GlobalViewModel
import kotlinx.android.synthetic.main.activity_main.view.*

class MainMenuFragment : Fragment() {

    private var binding: FragmentMainMenuBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupUI()
        this.setupCardsRV()
    }

    private fun setupUI() {
//        this.activity?.toolbar?.visibility = View.GONE
    }

    private fun setupCardsRV() {
        val mLayoutManager = GridLayoutManager(context, 2)
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL

        this.binding?.rvCards?.layoutManager = mLayoutManager
        val cardsOpAdapter = this.context?.let {
            CardAdapter(it, GlobalViewModel.sharedInstance.mCardList)
        }

        cardsOpAdapter?.clickInfoCard = {
            GlobalViewModel.sharedInstance.mCardSelected = it
            this.makeNavigation()
        }

        this.binding?.rvCards?.adapter = cardsOpAdapter
        this.binding?.rvCards?.adapter?.notifyDataSetChanged()
    }

    private fun makeNavigation() {

        when (GlobalViewModel.sharedInstance.mCardSelected.cID) {

            1 -> {
                this.findNavController()
                    .navigate(MainMenuFragmentDirections.actionMainMenuToManga())
            }

            2 -> {

            }
        }
    }
}