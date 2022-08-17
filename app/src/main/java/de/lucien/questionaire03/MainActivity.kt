package de.lucien.questionaire03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import de.lucien.questionaire03.ui.presentation.components.HomeScreen
import de.lucien.questionaire03.ui.presentation.components.QuestionaireBottomNavigation
import de.lucien.questionaire03.ui.theme.Questionaire03Theme


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




@Composable
fun QuestionaireApp(){
    Scaffold(
    bottomBar = {QuestionaireBottomNavigation()}
){ padding ->
    HomeScreen()
}
}







