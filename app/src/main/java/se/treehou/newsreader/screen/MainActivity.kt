package se.treehou.newsreader.screen

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import se.treehou.newsreader.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }
}
