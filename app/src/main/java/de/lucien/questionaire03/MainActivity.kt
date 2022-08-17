package de.lucien.questionaire03

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.lucien.questionaire03.ui.theme.Questionaire03Theme
import java.util.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Questionaire03Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Gray
                ) {
                    QuestionaireApp()
                }
            }
        }
    }
}



private val topMenuData = listOf(
    R.drawable.p1food to R.string.food,
    R.drawable.basicincome to R.string.basicIncome,
    R.drawable.p1humanrights to R.string.humanrights,
    R.drawable.p1trees to R.string.Nature,
    R.drawable.p1windpower to R.string.energy
).map{DrawableStringPair(it.first, it.second)}

private val middleMenuData = listOf(
    R.drawable.p1plastic to R.string.Plastic,
    R.drawable.p1climatewarming to R.string.climateWarming,
    R.drawable.p1desertification to R.string.desertification,
    R.drawable.p1recycling to R.string.recycling,
    R.drawable.p1trees to R.string.Trees,
    R.drawable.p1water to R.string.water,
    R.drawable.p1windpower to R.string.windPower
).map{DrawableStringPair(it.first, it.second)}






@Composable
fun QuestionaireApp(){
    Scaffold(
    bottomBar = {QuestionaireBottomNavigation()}
){ padding ->
    HomeScreen()
}
}




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


//--------------------------------------
@Composable
fun QuestionaireBottomNavigation(
    modifier: Modifier = Modifier,
){
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier
    ){
        BottomNavigationItem(
            selected = true,
            onClick = {},
        icon = {Icon(Icons.Default.Star, contentDescription = null)},
            label = {
                Text(stringResource(id = R.string.bottom_navigation_one))
            }
            )
        //-----------
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = {Icon(Icons.Default.Star, contentDescription = null)},
            label = {
                Text(stringResource(id = R.string.bottom_navigation_two))
            }
        )

        //----------
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = {Icon(Icons.Default.Star, contentDescription = null)},
            label = {
                Text(stringResource(id = R.string.bottom_navigation_three))
            }
        )

        //----------
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = {Icon(Icons.Default.Star, contentDescription = null)},
            label = {
                Text(stringResource(id = R.string.bottom_navigation_four))
            }
        )

        //----------
    }
}
//--------------------------------------




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


// TODO cannot type in text...
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
){
    TextField(value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
                      Text(stringResource(id = R.string.placeholder_search))
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth()
    )
}






@Composable
fun TopMenuLazyRow(
    modifier: Modifier = Modifier
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier)
    {
        items(topMenuData){item->
            TopMenuItem(drawable = item.drawable, text = item.text)
        }
    }

}

@Composable
fun TopMenuItem(@DrawableRes drawable: Int,
                @StringRes text: Int,
                modifier: Modifier = Modifier) {
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
        items(middleMenuData){item->
            MiddleMenuItem(drawable = item.drawable, text = item.text)
        }
    }
}


@Composable
fun MiddleMenuItem(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier) {
    Surface(
        shape = MaterialTheme.shapes.small,
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(170.dp)){
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

