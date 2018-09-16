package cafe.adriel.androidcoroutinescopes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.Main
import kotlin.coroutines.experimental.CoroutineContext

open class CoroutineScopedAndroidViewModel(app: Application) : AndroidViewModel(app), CoroutineScope {

    protected val coroutineJob = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + coroutineJob

    override fun onCleared() {
        super.onCleared()
        coroutineJob.cancel()
    }

}