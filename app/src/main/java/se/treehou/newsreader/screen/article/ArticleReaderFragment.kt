package se.treehou.newsreader.screen.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uber.autodispose.autoDisposable
import kotlinx.android.synthetic.main.fragment_article.*
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import se.treehou.newsreader.R
import se.treehou.newsreader.screen.BaseFragment
import se.treehou.newsreader.screen.article.adapters.ArticleController

class ArticleReaderFragment : BaseFragment() {

    private val viewModel: ArticleReaderViewModel by viewModel { parametersOf(articleId) }
    private lateinit var articleId: String
    private val controller: ArticleController by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arguments = arguments
            ?: throw Exception("Argument must be provided to ${ArticleReaderFragment::class.java.simpleName}")

        articleId = ArticleReaderFragmentArgs.fromBundle(arguments).articleId
        getKoin().setProperty(ARG_ARTICLE_ID, articleId)
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

    override fun onResume() {
        super.onResume()

        viewModel.newsArticle
            .autoDisposable(scopeProvider)
            .subscribe {
                controller.article = it
                controller.requestModelBuild()
            }
    }

    companion object {
        const val ARG_ARTICLE_ID = "article_id"
    }
}
