package com.metromart.common.ext

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(dest: NavDirections, navigatorExtras: Navigator.Extras? = null){
    if(navigatorExtras != null){
        findNavController()
            .navigate(
                dest,
                navigatorExtras
            )
    }else{
        findNavController().navigate(dest)
    }
}

fun Fragment.navigate(dest: NavDirections, navOptions: NavOptions){
    findNavController()
        .navigate(
            dest,
            navOptions
        )
}

fun Fragment.navigateUp() = findNavController().navigateUp()