package kz.alemtime.alem.support.navigation

interface RouterProvider {
    fun provideRouter(): ApplicationRouter
    fun provideTabTopNavRouter(): ApplicationRouter
}
