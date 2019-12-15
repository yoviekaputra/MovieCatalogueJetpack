package yovi.putra.moviecatalogue.repository

import android.content.Context
import android.content.res.TypedArray
import yovi.putra.moviecatalogue.R
import yovi.putra.moviecatalogue.model.Movie

object DataRepository {

    fun getMovies(ctx: Context): MutableList<Movie>? {
        val movieIcon: TypedArray = ctx.resources.obtainTypedArray(R.array.movies_icon)
        val movieTitle: Array<String> =
            ctx.resources.getStringArray(R.array.movies_title)
        val movieDescription: Array<String> =
            ctx.resources.getStringArray(R.array.movies_description)
        val movieYear: Array<String> =
            ctx.resources.getStringArray(R.array.movies_year)

        val movies = mutableListOf<Movie>()
        for (i in movieTitle.indices) {
            movies.add(
                Movie(
                    movieIcon.getResourceId(i, 0),
                    movieTitle[i],
                    movieDescription[i],
                    movieYear[i],
                    "5"
                )
            )
        }
        movieIcon.recycle()
        return movies
    }

}