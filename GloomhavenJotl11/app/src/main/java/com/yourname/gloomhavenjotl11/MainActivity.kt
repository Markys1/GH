import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.room.Room

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "gloomhaven.db"
        ).build()

        val viewModel = CharacterViewModel(db.dao())

        setContent {
            val list by viewModel.characters.collectAsState()

            Column(Modifier.padding(16.dp)) {

                Button(onClick = {
                    viewModel.add(
                        CharacterEntity(
                            name = "Алый гвардеец",
                            characterClass = CharacterClass.RED_GUARD
                        )
                    )
                }) {
                    Text("Добавить персонажа")
                }

                list.forEach {
                    Text("${it.name} – золото: ${it.gold}")
                }
            }
        }
    }
}