package se.treehou.newsreader.screen.magazinebrowser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.uber.autodispose.autoDisposable
import kotlinx.android.synthetic.main.fragment_magazine_browser.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import se.treehou.newsreader.R
import se.treehou.newsreader.screen.BaseFragment
import se.treehou.newsreader.screen.magazinebrowser.adapters.MagazineBrowserController

/**
 * Fragment used for browsing magazines.
 */
class MagazineBrowserFragment : BaseFragment() {

    private val viewModel: MagazineBrowserViewModel by viewModel()
    private val controller: MagazineBrowserController by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_magazine_browser, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        magazineList.setControllerAndBuildModels(controller)
    }

    override fun onResume() {
        super.onResume()

        setTitle(getString(R.string.magazines))

        viewModel.magazines
            .autoDisposable(scopeProvider)
            .subscribe {
                controller.magazines = it
                controller.requestModelBuild()
            }

        viewModel.viewActions
            .autoDisposable(scopeProvider)
            .subscribe { action ->
                when (action) {
                    is ViewActions.OpenMagazineAction -> openMagazine(action.magazineId)
                }
            }

        controller.magazineClickListener = { viewModel.magazineClicked(it) }
    }

    /**
     * Open magazine page
     * @param magazineId the id of the magazine to open
     */
    private fun openMagazine(magazineId: String) {
        val direction =
            MagazineBrowserFragmentDirections.actionMagazineListFragmentToReaderFragment(magazineId)

        findNavController().navigate(direction)
    }
}

