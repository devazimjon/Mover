package uz.devazimjon.sample.mover.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import uz.devazimjon.sample.mover.ui.theme.MoverTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoverTheme {

            }
        }
    }
}