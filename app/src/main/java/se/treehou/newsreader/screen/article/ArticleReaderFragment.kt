package se.treehou.newsreader.screen.article

import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
import com.uber.autodispose.autoDisposable
import kotlinx.android.synthetic.main.fragment_article.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import se.treehou.newsreader.R
import se.treehou.newsreader.screen.BaseFragment
import se.treehou.newsreader.screen.article.adapters.ArticleController

/**
 * Fragment used for showing a single article.
 */
class ArticleReaderFragment : BaseFragment() {

    private val viewModel: ArticleReaderViewModel by viewModel { parametersOf(articleId) }
    private lateinit var articleId: String
    private val controller: ArticleController by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arguments = arguments
            ?: throw Exception("Argument must be provided to ${ArticleReaderFragment::class.java.simpleName}")

        articleId = ArticleReaderFragmentArgs.fromBundle(arguments).articleId

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articleView.setControllerAndBuildModels(controller)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_reader, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onResume() {
        super.onResume()

        viewModel.newsArticle
            .autoDisposable(scopeProvider)
            .subscribe {
                controller.article = it
                controller.requestModelBuild()
            }

        viewModel.viewActions
            .autoDisposable(scopeProvider)
            .subscribe{ action ->
                when(action){
                    is ViewActions.ShareArticleAction -> shareArticle(action.title, action.url)
                }
            }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> viewModel.clickedShareArticle()
        }

        return super.onOptionsItemSelected(item)
    }

    /**
     * Fires an intent to share article by linking them to the original news source.
     */
    private fun shareArticle(title: String, url: String) {
        ShareCompat.IntentBuilder
            .from(activity)
            .setType("text/plain")
            .setText("$title - $url")
            .setChooserTitle(R.string.share)
            .startChooser()
    }

    companion object {
        const val ARG_ARTICLE_ID = "article_id"
    }
}
