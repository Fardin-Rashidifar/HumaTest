package f.r.humatest2.model


import androidx.lifecycle.LiveData
import f.r.humatest2.dataClass.Movie
import f.r.humatest2.dataClass.MovieList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ModelMainFragment @Inject constructor() {

    private val mainUiBackgroundUri = "https://dx35vtwkllhj9.cloudfront.net/universalstudios/ambulance/images/gallery/image1.jpg"

    fun getMainUiBackgroundUri() = mainUiBackgroundUri

    fun getAllMovies(): List<Movie>{

        return MovieList.list
    }

}
