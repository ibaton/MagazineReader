package se.treehou.newsreader.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider

/**
 * Base class for fragment.
 * Support for autodispose.
 */
abstract class BaseFragment : Fragment() {

    val scopeProvider: AndroidLifecycleScopeProvider by lazy { AndroidLifecycleScopeProvider.from(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = getTitle()
        if (title != null) {
            setTitle(title)
        }
    }

    protected fun setTitle(text: String) {
        val activity = activity
        if (activity is AppCompatActivity) {
            activity.supportActionBar?.title = text
        }
    }

    open fun getTitle(): String? {
        return null
    }
}