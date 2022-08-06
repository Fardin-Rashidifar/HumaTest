package f.r.humatest2.viewModel

import android.content.Context
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import f.r.humatest2.adapter.CardPresenter
import f.r.humatest2.dataClass.Movie
import f.r.humatest2.dataClass.MovieList
import f.r.humatest2.model.ModelMainFragment
import f.r.humatest2.view.MainFragment
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ViewModelMainFragment @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val model: ModelMainFragment
) : ViewModel() {

    fun getMainUiBackgroundUri() = model.getMainUiBackgroundUri()
    fun getAllMovies(): List<Movie> {

        return model.getAllMovies()
    }

    fun loadRows(): ArrayObjectAdapter {

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        viewModelScope.launch {
            val list = getAllMovies()

            val cardPresenter = CardPresenter()

            for (i in 0 until MainFragment.NUM_ROWS) {

                val listRowAdapter = ArrayObjectAdapter(cardPresenter)
                for (j in 0 until MainFragment.NUM_COLS) {
                    listRowAdapter.add(list[j % 5])
                }
                val header = HeaderItem(i.toLong(), MovieList.MOVIE_CATEGORY[i])
                rowsAdapter.add(ListRow(header, listRowAdapter))
            }

        }

        return rowsAdapter
    }

}