package com.leviaran.ownpetapp.ui.screencomponent.uicomponent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leviaran.ownpetapp.R
import com.leviaran.ownpetapp.data.dto.PetsResponseItem
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogCardv2(item: PetsResponseItem, listener: (item: PetsResponseItem) -> Unit) {
    Card( modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp)
        .clip(RoundedCornerShape(20.dp))
        .clickable(onClick = { listener(item) }),
        elevation = 3.dp,
        backgroundColor = MaterialTheme.colors.onSurface) {

        Box(modifier = Modifier
            .padding(3.dp)
            .wrapContentHeight()
            .fillMaxWidth(),
            contentAlignment = Alignment.Center) {

            CoilImage(
                data = item.image.url?:"",
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(20.dp)),
                alignment = Alignment.CenterStart,
                contentScale = ContentScale.Crop,
                fadeIn = true,

            )

            Column(modifier = Modifier
                .align(Alignment.BottomCenter)
                .absolutePadding(top = 10.dp)
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, colorResource(id = R.color.black)),
                        10f,
                        110f
                    )
                )
                .clipToBounds()
            ) {

                Text(
                    text = item.name?:"",
                    modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp),
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp
                )

                Row(modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp)) {
                    val location = painterResource(id = R.drawable.ic_places)
                    Icon(
                        painter = location,
                        contentDescription = null,
                        modifier = Modifier.size(10.dp, 10.dp),
                        tint = Color.Red
                    )

                    Text(
                        text = item.origin?:"", modifier = Modifier.padding(3.dp, 0.dp, 10.dp, 0.dp),
                        color = colorResource(id = R.color.white),
                        fontSize = 9.sp
                    )
                }

            }

        }
    }
}