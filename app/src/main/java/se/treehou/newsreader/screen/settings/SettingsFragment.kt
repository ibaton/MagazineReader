package se.treehou.newsreader.screen.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.LibsBuilder
import com.uber.autodispose.autoDisposable
import kotlinx.android.synthetic.main.fragment_settings.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import se.treehou.newsreader.R
import se.treehou.newsreader.screen.BaseFragment
import se.treehou.newsreader.screen.settings.adapters.SettingsController

class SettingsFragment : BaseFragment() {

    private val viewModel: SettingsViewModel by viewModel()
    val controller: SettingsController by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingsList.setControllerAndBuildModels(controller)
    }

    override fun onResume() {
        super.onResume()

        controller.licenseClickedObservable
            .autoDisposable(scopeProvider)
            .subscribe {
                viewModel.licenseClicked()
            }

        viewModel.viewActions
            .autoDisposable(scopeProvider)
            .subscribe { action ->
                when (action) {
                    is ViewActions.OpenLicensePageAction -> openLicensePage()
                }
            }
    }

    /**
     * Opens third-party license page.
     */
    private fun openLicensePage() {
        val context = context ?: return

        LibsBuilder()
            .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
            .start(context)
    }
}