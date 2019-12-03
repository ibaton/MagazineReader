package se.treehou.newsreader.screen.magazinebrowser

sealed class ViewActions {

    /**
     * A action for open the provided magazine for further reading.
     */
    data class OpenMagazineAction(val magazineId: String) : ViewActions()
}