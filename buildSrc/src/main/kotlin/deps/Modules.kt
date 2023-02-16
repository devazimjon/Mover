object Modules {
    const val core = ":core"

    const val components = ":components"

    object Movie : Group {
        override val groupName = ":movie"
        val datasource = "$groupName:movie-datasource:main"
        val datasourceTest = "$groupName:movie-datasource:test"
        val domain = "$groupName:movie-domain"
        val uiDetail = "$groupName:ui-detail"
        val uiList = "$groupName:ui-list"
    }
}
