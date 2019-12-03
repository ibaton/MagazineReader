package se.treehou.newsreader.screen.magazine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uber.autodispose.autoDisposable
import kotlinx.android.synthetic.main.fragment_magazine.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import se.treehou.newsreader.R
import se.treehou.newsreader.screen.BaseFragment

/**
 * Fragment used for showing a collection articles.
 */
class MagazineFragment : BaseFragment() {

    private val viewModel: MagazineViewModel by viewModel { parametersOf(magazineId) }
    private lateinit var magazineId: String

    private var articleAdapter: ArticlePager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arguments = arguments
            ?: throw Exception("Argument must be provided to ${MagazineFragment::class.java.simpleName}")

        magazineId = MagazineFragmentArgs.fromBundle(arguments).magazineId
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_magazine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articleAdapter = ArticlePager(childFragmentManager)
        articlePager.adapter = articleAdapter
    }


    override fun onResume() {
        super.onResume()

        viewModel.newsArticles
            .autoDisposable(scopeProvider)
            .subscribe { magazine ->
                articleAdapter?.articleIds = magazine.articleIds
                articleAdapter?.notifyDataSetChanged()

                setTitle(magazine.title)
            }
    }
}

