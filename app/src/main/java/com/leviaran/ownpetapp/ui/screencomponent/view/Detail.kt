package com.leviaran.ownpetapp.ui.screencomponent.view

import android.icu.text.CaseMap
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.leviaran.ownpetapp.R
import com.leviaran.ownpetapp.data.dto.Image
import com.leviaran.ownpetapp.data.dto.PetsResponseItem
import com.leviaran.ownpetapp.ui.screencomponent.uicomponent.PetCard
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun Details(navController: NavController, url : String, temp : String,breedFor: String, name: String, origin: String, lifeSpan: String, breedGroup: String) {
    val image = Image(url = url)
    val item = PetsResponseItem(image = image, temperament = temp, bredFor = breedFor, name = name, origin = origin, lifeSpan = lifeSpan, breedGroup = breedGroup)

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Pet Information")},
            backgroundColor = MaterialTheme.colors.background,
            contentColor = colorResource(id = R.color.black),
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp, 24.dp)
                        .clickable {
                            navController.navigateUp()
                        },
                    tint = colorResource(id = R.color.black)
                )
            }
        )
    },
        content = {
            DetailsViews(item)
        }
    )
}

@Composable
fun DetailsViews(item: PetsResponseItem) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
    ) {
        item{
            item.apply {
                
                CoilImage(
                    data = item.image.url?:"",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp),
                    alignment = Alignment.CenterStart,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))
                PetCard(item = item)
            }
        }

        item {
            item.apply {
                Spacer(modifier = Modifier.height(30.dp))
                Title(title = "Temperament")
                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = item.temperament?:"",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 16.dp, 0.dp),
                    color = colorResource(id = R.color.text),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Start
                )
            }
        }

        item {
            item.apply {
                Spacer(modifier = Modifier.height(30.dp))
                Title(title = "Breed For")
                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = item.bredFor?:"",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 16.dp, 0.dp),
                    color = colorResource(id = R.color.text),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Start
                )
            }
        }

        // CTA - Adopt me button
        item {
            Spacer(modifier = Modifier.height(36.dp))
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = colorResource(id = R.color.blue),
                    contentColor = Color.White
                )
            ) {
                Text("Pet Me")
            }
            Spacer(modifier = Modifier.height(24.dp))
        }


    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 0.dp, 0.dp),
        color = colorResource(id = R.color.text),
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )
}