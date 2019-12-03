package se.treehou.newsreader.koin

import org.koin.core.module.Module
import org.koin.dsl.module
import se.treehou.newsmanager.NewsManager
import se.treehou.newsmanager.StaticNewsManager

val newsManagerModule: Module = module {
    single<NewsManager> { StaticNewsManager() }
}