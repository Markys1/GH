import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromClass(value: CharacterClass) = value.name

    @TypeConverter
    fun toClass(value: String) = CharacterClass.valueOf(value)
}