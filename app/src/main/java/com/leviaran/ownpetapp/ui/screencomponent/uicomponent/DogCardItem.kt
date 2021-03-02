package com.leviaran.ownpetapp.ui.screencomponent.uicomponent

import android.media.Image
import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.Coil
import com.leviaran.ownpetapp.R
import com.leviaran.ownpetapp.data.dto.PetsResponseItem
import dev.chrisbanes.accompanist.coil.CoilImage


@Composable
fun DogCardItem(item: PetsResponseItem, listener: (item: PetsResponseItem) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable(onClick = { listener(item) }),
        elevation = 3.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            CoilImage(
                data = item.image.url?:"",
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp)),
                alignment = Alignment.CenterStart,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {

                Text(
                    text = item.name?:"",
                    modifier = Modifier.padding(0.dp, 0.dp, 15.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = buildString {
                        append(item.origin)
                        append(item.lifeSpan)
                    },
                    modifier = Modifier.padding(0.dp, 0.dp, 15.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                )

                Row(verticalAlignment = Alignment.Bottom) {
                    val location = painterResource(id = R.drawable.ic_places)

                    Icon(
                        painter = location,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp, 16.dp),
                        tint = Color.Red
                    )

                    Text(
                        text = item.origin?:"", modifier = Modifier.padding(8.dp, 12.dp, 12.dp, 0.dp),
                        color = MaterialTheme.colors.surface
                    )
                }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                GenderTag(name = item.breedGroup?:"")
            }
        }
    }
}