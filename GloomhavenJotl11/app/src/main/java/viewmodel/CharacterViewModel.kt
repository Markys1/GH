import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val dao: CharacterDao
) : ViewModel() {

    val characters = dao.getAll()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun add(character: CharacterEntity) {
        viewModelScope.launch {
            dao.insert(character)
        }
    }
}