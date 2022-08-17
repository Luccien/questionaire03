package de.lucien.questionaire03.ui.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.lucien.questionaire03.R
import java.util.*

//--------------------------------------
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
){
    Column(
        modifier
            .verticalScroll(rememberScrollState())

    ){
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.topCategorie) {
            TopMenuLazyRow()
        }
        Spacer(Modifier.height(16.dp))
        HomeSection(title = R.string.choosenCategory){
            MiddleMenuLazyRow()
        }
        Spacer(Modifier.height(16.dp))

    }

}





@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable ()-> Unit
){
    Column(modifier){
        Text( stringResource(id = title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 8.dp
                )
                .padding(horizontal = 16.dp)
        )
        content()
    }

}
//--------------------------------------








@Composable
fun TopMenuLazyRow(
    modifier: Modifier = Modifier
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier)
    {
        items(topMenuData){ item->
            TopMenuItem(drawable = item.drawable, text = item.text)
        }
    }

}

@Composable
fun TopMenuItem(@DrawableRes drawable: Int,
                @StringRes text: Int,
                modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        )
    {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            stringResource(id = text),
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}



@Composable
fun MiddleMenuLazyRow(
    modifier: Modifier = Modifier
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier)
    {
        items(middleMenuData){ item->
            MiddleMenuItem(drawable = item.drawable, text = item.text)
        }
    }
}


@Composable
fun MiddleMenuItem(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(170.dp)
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
            )
            Text(
                stringResource(id = text),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

    }
}
