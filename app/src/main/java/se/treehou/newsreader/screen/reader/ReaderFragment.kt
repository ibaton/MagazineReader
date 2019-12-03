package se.treehou.newsreader.screen.reader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uber.autodispose.autoDisposable
import kotlinx.android.synthetic.main.fragment_reader.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import se.treehou.newsreader.R
import se.treehou.newsreader.screen.BaseFragment

/**
 * Fragment used for showing a collection articles.
 */
class ReaderFragment : BaseFragment() {

    private val viewModel: ReaderViewModel by viewModel()
    private lateinit var articleAdapter: ArticlePager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reader, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentManager = fragmentManager ?: return

        articleAdapter = ArticlePager(fragmentManager)
        articlePager.adapter = articleAdapter
    }

    override fun onResume() {
        super.onResume()

        viewModel.newsArticles
            .autoDisposable(scopeProvider)
            .subscribe {
                articleAdapter.articles = it
                articleAdapter.notifyDataSetChanged()
            }
    }
}

