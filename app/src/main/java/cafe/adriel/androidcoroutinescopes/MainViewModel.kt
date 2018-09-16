package cafe.adriel.androidcoroutinescopes

import android.util.Log
import cafe.adriel.androidcoroutinescopes.viewmodel.CoroutineScopedViewModel
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class MainViewModel : CoroutineScopedViewModel() {

    companion object {
        private val TAG: String = MainViewModel::class.java.simpleName
    }

    fun doSomethingAsync(){
        launch {
            Log.d(TAG, "MAIN THREAD")
            withContext(Dispatchers.Default){
                Log.d(TAG, "OTHER THREAD")
            }
        }
    }
}