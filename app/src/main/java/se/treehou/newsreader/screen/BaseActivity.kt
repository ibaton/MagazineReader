package se.treehou.newsreader.screen

import androidx.appcompat.app.AppCompatActivity
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider

/**
 * Base activity.
 */
abstract class BaseActivity : AppCompatActivity() {
    val scopeProvider: AndroidLifecycleScopeProvider by lazy { AndroidLifecycleScopeProvider.from(this) }
}
