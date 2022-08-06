package f.r.humatest2.dataClass

object MovieList {
    val MOVIE_CATEGORY = arrayOf(
        "دسته اول",
        "دسته دوم"
    )

    val list: List<Movie> by lazy {
        setupMovies()
    }
    private var count: Long = 0

    private fun setupMovies(): List<Movie> {

        val cardImageUrl = arrayOf(
            "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg",
            "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search/card.jpg",
            "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue/card.jpg",
            "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole/card.jpg",
            "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose/card.jpg"
        )

        val list = cardImageUrl.indices.map {
            buildMovieInfo(

                cardImageUrl[it]
            )
        }

        return list
    }

    private fun buildMovieInfo(
        cardImageUrl: String): Movie {
        val movie = Movie()
        movie.id = count++
        movie.cardImageUrl = cardImageUrl
        return movie
    }
}