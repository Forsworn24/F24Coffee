package mudinov.ali.f24coffee.presentation.Tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import mudinov.ali.f24coffee.R
import mudinov.ali.f24coffee.databinding.HomeBinding
import mudinov.ali.f24coffee.presentation.Proposal.ProposalAdapter

class Home : Fragment() {

    private var binding: HomeBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.home, container, false)

        binding?.slider?.adapter = ProposalAdapter(context as FragmentActivity)

        val tabLayoutMediator = binding?.tabSlider?.let {
            binding?.slider?.let { it1 ->
                TabLayoutMediator(it,
                    it1,
                    TabLayoutMediator.TabConfigurationStrategy { tab, position -> })
            }
        }
        tabLayoutMediator?.attach()

        return binding?.root
    }


}