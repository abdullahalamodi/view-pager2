package com.abdullahalamodi.fragmentwithtabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

const val TABS_NUM = 3;

class MainFragment : Fragment() {

    private val tabLayoutMap = mapOf<String, Int>(
        "first" to R.drawable.one,
        "second" to R.drawable.two,
        "third" to R.drawable.three
    );
    private lateinit var fragmentTabsAdapter: FragmentTabsAdapter
    private lateinit var viewPager: ViewPager2;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tabLayout = view.findViewById(R.id.tab_layout) as TabLayout;
        viewPager = view.findViewById(R.id.pager);
        fragmentTabsAdapter = FragmentTabsAdapter(this)
        viewPager.adapter = fragmentTabsAdapter;
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabLayoutMap.keys.toTypedArray()[position];
            tab.setIcon(tabLayoutMap.values.toTypedArray()[position]);
        }.attach();
    }


    class FragmentTabsAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = TABS_NUM;

        override fun createFragment(position: Int): Fragment {
            val fragmentTitle = arrayOf("first", "second", "third");
            return FirstFragment.newInstance(fragmentTitle[position]);
        }

    }


    companion object {
        fun newInstance(): MainFragment {
            return MainFragment();
        }
    }
}