package cafe.adriel.androidcoroutinescopes.appcompat

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class CoroutineScopedDialogFragment : DialogFragment(), CoroutineScope {

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