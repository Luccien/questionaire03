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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toDrawable
import de.lucien.questionaire03.ui.theme.Questionaire03Theme
import java.util.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Questionaire03Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Gray//MaterialTheme.colors.col
                ) {
                    //StartScreen()
                    //HomeScreen()
                    QuestionaireApp()
                }
            }
        }
    }
}

/*
//@Preview(showBackground = true)
@Composable // TODO  delete this .........
fun StartScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    )
    {
        SearchBar()
        TopMenuLazyRow()
        MiddleMenuLazyGridRow()// TODO 45 minutes on video
        //TopMenu(drawable = R.drawable.p1food, text = R.string.windPower)
        //MiddleMenu(drawable = R.drawable.p1plastic, text = R.string.windPower)
    }
}
*/
// -----------------------
@Composable
fun QuestionaireApp(){
Scaffold(
    bottomBar = {QuestionaireBottomNavigation()}

){ padding-> // TODO ??
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
            //.padding(vertical = 16.dp) // spacer instead TEST BOTH TODO
            .verticalScroll(rememberScrollState())

        ){
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.firstSection) {
            TopMenuLazyRow()
        }
        HomeSection(title = R.string.secondSection){
            MiddleMenuLazyGridRow()
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
        icon = {Icon(Icons.Default.Spa, contentDescription = null)},
            label = {
                Text(stringResource(id = R.string.bottom_navigation_home))
            }
            )
        //-----------
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = {Icon(Icons.Default.Spa222, contentDescription = null)},
            label = {
                Text(stringResource(id = R.string.bottom_navigation_home222))
            }
        )

        //----------
    }
}



//-------------------------------------- TODO romove later
@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable ()-> Unit
){
    Column(modifier){
        Text( stringResource(id = title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h2,
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





private val topMenuData = listOf(
    R.drawable.p1plastic to R.string.Plastic,
    R.drawable.p1food to R.string.food,
    //R.drawable.basicincome to R.string.basicIncome,
    R.drawable.p1climatewarming to R.string.climateWarming,
    R.drawable.p1humanrights to R.string.humanrights,
    R.drawable.p1desertification to R.string.desertification,
    R.drawable.p1recycling to R.string.recycling,
    R.drawable.p1trees to R.string.Trees,
    R.drawable.p1water to R.string.water,
    R.drawable.p1windpower to R.string.windPower
).map{DrawableStringPair(it.first, it.second)}

private val middleMenuData = listOf(
    R.drawable.p1plastic to R.string.Plastic,
    R.drawable.p1food to R.string.food,
    //R.drawable.basicincome to R.string.basicIncome,
    R.drawable.p1climatewarming to R.string.climateWarming,
    R.drawable.p1humanrights to R.string.humanrights,
    R.drawable.p1desertification to R.string.desertification,
    R.drawable.p1recycling to R.string.recycling,
    R.drawable.p1trees to R.string.Trees,
    R.drawable.p1water to R.string.water,
    R.drawable.p1windpower to R.string.windPower
).map{DrawableStringPair(it.first, it.second)}





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
        //modifier = modifier.fillMaxSize() // this will cause error with following elements
    )
    {
        Image(
            painter = painterResource(id = drawable),//R.drawable.p1food ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            stringResource(id = text),//R.string.windPower),
            //style = MaterialTheme.typography.h3,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}



@Composable
fun MiddleMenuLazyGridRow(
    modifier: Modifier = Modifier
){
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(120.dp)
    ){
        items(middleMenuData){ item->
            MiddleMenuItem(
                drawable = item.drawable,
                text = item.text
            )
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
        //modifier = Modifier.fillMaxSize() othervise all surface after that will be white
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(170.dp)){
            Image(
                painter = painterResource(id = drawable),//R.drawable.p1plastic),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
            )
            Text(
                stringResource(id = text),//R.string.windPower),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

    }
    //}
}

