package com.leviaran.ownpetapp.ui.screencomponent.view


import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.leviaran.ownpetapp.data.dto.PetsResponseItem
import com.leviaran.ownpetapp.ui.screencomponent.uicomponent.DogCardItem
import com.leviaran.ownpetapp.ui.screencomponent.uicomponent.DogCardv2
import com.leviaran.ownpetapp.ui.screencomponent.uicomponent.StaggeredVerticalGrid
import com.leviaran.ownpetapp.ui.screencomponent.uicomponent.TopBar

@Composable
fun Home(navController: NavController, listDog : List<PetsResponseItem>, theme: () -> Unit) {
    LazyColumn{
        item {
            TopBar(onToggle = {theme()})
            Spacer(modifier = Modifier.height(8.dp))

        }

        item {
            StaggeredVerticalGrid(maxColumnWidth = 220.dp, modifier = Modifier.padding(5.dp)) {
                listDog.forEach {
                    DogCardv2(item = it, listener = {pet ->
                        val uri = "details|${pet.image.url?.ifBlank { "NONE" }}|${pet.temperament?.ifBlank { "NONE" }}|${pet.bredFor?.ifBlank { "NONE" }}|${pet.name?.ifBlank { "NONE" }}|${pet.origin?.ifBlank { "NONE" }}|${pet.lifeSpan?.ifBlank { "NONE" }}|${pet.breedGroup?.ifBlank { "NONE" }}"
                        navController.navigate(uri)
                    })
                }
            }
        }

//        items(listDog) {
//            listDog.forEach {
//                DogCardItem(item = it, listener = {pet ->
//                    val uri = "details|${pet.image.url?.ifBlank { "NONE" }}|${pet.temperament?.ifBlank { "NONE" }}|${pet.bredFor?.ifBlank { "NONE" }}|${pet.name?.ifBlank { "NONE" }}|${pet.origin?.ifBlank { "NONE" }}|${pet.lifeSpan?.ifBlank { "NONE" }}|${pet.breedGroup?.ifBlank { "NONE" }}"
//                    navController.navigate(uri)
//                })
//            }
//        }
    }

}