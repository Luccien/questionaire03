package de.lucien.questionaire03.ui.presentation.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import de.lucien.questionaire03.R


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
            icon = { Icon(Icons.Default.Star, contentDescription = null) },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_one))
            }
        )
        //-----------
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Star, contentDescription = null) },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_two))
            }
        )

        //----------
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Star, contentDescription = null) },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_three))
            }
        )

        //----------
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Star, contentDescription = null) },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_four))
            }
        )

        //----------
    }
}
//--------------------------------------
