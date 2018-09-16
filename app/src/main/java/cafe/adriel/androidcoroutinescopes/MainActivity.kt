package cafe.adriel.androidcoroutinescopes

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import cafe.adriel.androidcoroutinescopes.appcompat.CoroutineScopedActivity
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class MainActivity : CoroutineScopedActivity() {

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        // Activity Coroutine
        launch {
            Log.d(TAG, "MAIN THREAD")
            withContext(Dispatchers.Default){
                Log.d(TAG, "OTHER THREAD")
            }
        }

        // ViewModel Coroutine
        viewModel.doSomethingAsync()
    }
}
