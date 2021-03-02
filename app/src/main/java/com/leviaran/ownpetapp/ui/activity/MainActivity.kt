package com.leviaran.ownpetapp.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.leviaran.ownpetapp.R
import com.leviaran.ownpetapp.data.Resources
import com.leviaran.ownpetapp.data.dto.PetsResponse
import com.leviaran.ownpetapp.data.dto.PetsResponseItem
import com.leviaran.ownpetapp.ui.base.BaseActivity
import com.leviaran.ownpetapp.ui.screencomponent.home.HomeViewModel
import com.leviaran.ownpetapp.ui.screencomponent.theme.MyTheme
import com.leviaran.ownpetapp.ui.screencomponent.uicomponent.ShowProgressDialog
import com.leviaran.ownpetapp.ui.screencomponent.view.Home
import com.leviaran.ownpetapp.ui.screencomponent.view.Main
import com.leviaran.ownpetapp.utils.SingleEvent
import com.leviaran.ownpetapp.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    var toogleTheme: (() -> Unit)? = null

    private val homeViewModel: HomeViewModel by viewModels()

    override fun observerViewModel() {

    }

    override fun initViewBinding() {

    }

    private fun showLoading() {
        println("Trigger Loading")
    }

    @Composable
    private fun dataObtain() {
        val item: Resources<PetsResponse> by homeViewModel.petLiveData.observeAsState(
            Resources.Success(
                PetsResponse()
            )
        )
        when (item) {
            is Resources.Loading -> ShowProgressDialog()
            is Resources.Success -> Main(
                listPet = item.data?.petResponse?.toList() ?: listOf(),
                theme = { toogleTheme?.invoke() })
            is Resources.Error -> {
                item.errorCode?.let {
                    homeViewModel.showToastMessage(it)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel.getPet()

        setContent {
            val currentTheme = isSystemInDarkTheme()
            toogleTheme = {
                if (currentTheme) setDayTheme() else setDarkTheme()
            }
            MyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    dataObtain()
                }
            }
        }
    }

    private fun setDayTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun setDarkTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Main(listPet = listOf(), theme = { })
    }
}