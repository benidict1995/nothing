package com.metromart.nothing.global.onboarding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.metromart.common.Constant.PAGE_STEP_1_POSITION
import com.metromart.common.Constant.PAGE_STEP_2_POSITION
import com.metromart.common.Constant.PAGE_STEP_3_POSITION
import com.metromart.common.Constant.PAGE_STEP_4_POSITION
import com.metromart.nothing.R

class OnboardingAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val VIEW_TYPE_STEP_1 = 1
        private const val VIEW_TYPE_STEP_2 = 2
        private const val VIEW_TYPE_STEP_3 = 3
        private const val VIEW_TYPE_STEP_4 = 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType){
            VIEW_TYPE_STEP_1 -> {
                Onboarding1ViewHolder(
                    inflater
                        .inflate(
                            R.layout.item_onboarding_1,
                            parent,
                            false
                        )
                )
            }
            VIEW_TYPE_STEP_2 -> {
                Onboarding2ViewHolder(
                    inflater
                        .inflate(
                            R.layout.item_onboarding_2,
                            parent,
                            false
                        )
                )
            }
            VIEW_TYPE_STEP_3 -> {
                Onboarding3ViewHolder(
                    inflater
                        .inflate(
                            R.layout.item_onboarding_3,
                            parent,
                            false
                        )
                )
            }
            VIEW_TYPE_STEP_4 -> {
                Onboarding4ViewHolder(
                    inflater
                        .inflate(
                            R.layout.item_onboarding_4,
                            parent,
                            false
                        )
                )
            }
            else -> throw IllegalArgumentException("Invalid viewType :$viewType")
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (position){
            PAGE_STEP_1_POSITION -> VIEW_TYPE_STEP_1
            PAGE_STEP_2_POSITION -> VIEW_TYPE_STEP_2
            PAGE_STEP_3_POSITION -> VIEW_TYPE_STEP_3
            PAGE_STEP_4_POSITION -> VIEW_TYPE_STEP_4
            else -> throw IllegalArgumentException("Invalid position :$position")
        }

    override fun getItemCount(): Int = 4

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = Unit

    class Onboarding1ViewHolder(view: View): RecyclerView.ViewHolder(view)

    class Onboarding2ViewHolder(view: View): RecyclerView.ViewHolder(view)

    class Onboarding3ViewHolder(view: View): RecyclerView.ViewHolder(view)

    class Onboarding4ViewHolder(view: View): RecyclerView.ViewHolder(view)

}