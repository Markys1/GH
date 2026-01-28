import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val characterClass: CharacterClass,
    val level: Int = 1,
    val experience: Int = 0,
    val gold: Int = 0
)