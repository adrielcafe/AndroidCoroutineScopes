[![Version](https://jitpack.io/v/adrielcafe/AndroidCoroutineScopes.svg)](https://jitpack.io/#adrielcafe/AndroidCoroutineScopes)
[![Min API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)]()
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-AndroidCoroutineScopes-green.svg?style=flat )]( https://android-arsenal.com/details/1/7139 )

# AndroidCoroutineScopes

Starting from [0.26.0 release](https://github.com/Kotlin/kotlinx.coroutines/releases/tag/0.26.0) we should define a scope for new coroutines ([docs](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.experimental/-coroutine-scope/)).

To avoid this boilerplate code I've created this small library that implements the most common `CoroutineScope`s used in Android apps.

## How to use
Just extend your Activity/Fragment/ViewModel with the corresponding implementation.
```kotlin
// AppCompat scopes
class MyActivity : CoroutineScopedActivity()

class MyFragment : CoroutineScopedFragment()

class MyDialogFragment : CoroutineScopedDialogFragment()

// ViewModel scopes
class MyViewModel : CoroutineScopedViewModel()

class MyAndroidViewModel(app: Application) : CoroutineScopedAndroidViewModel(app)
```

### Example
```kotlin
class MainActivity : CoroutineScopedActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Don't use launch(UI), it's deprecated now
        launch {
            Log.d(TAG, "MAIN THREAD")
            withContext(Dispatchers.Default){
                Log.d(TAG, "OTHER THREAD")
            }
        }
    }

}
```

## Import to your project
```gradle
// Add JitPack to your repositories if needed
repositories {
	maven { url 'https://jitpack.io' }
}

// AppCompat scopes
implementation 'com.github.adrielcafe.androidcoroutinescopes:appcompat:1.0.1'

// ViewModel scopes
implementation 'com.github.adrielcafe.androidcoroutinescopes:viewmodel:1.0.1'
```
