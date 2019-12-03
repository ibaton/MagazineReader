package se.treehou.newsreader.koin

import org.koin.core.module.Module
import org.koin.dsl.module
import se.treehou.newsmanager.NewsManager
import se.treehou.newsmanager.StaticNewsManager
import se.treehou.newsreader.thememanager.ThemeManager

val themeManagerModule: Module = module {
    single { ThemeManager(get()) }
}