package cafe.adriel.androidcoroutinescopes.appcompat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.Main
import kotlin.coroutines.experimental.CoroutineContext

open class CoroutineScopedActivity : AppCompatActivity(), CoroutineScope {

    protected lateinit var coroutineJob: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + coroutineJob

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        coroutineJob = Job()
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineJob.cancel()
    }

}