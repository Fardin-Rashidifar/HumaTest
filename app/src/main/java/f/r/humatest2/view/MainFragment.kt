package f.r.humatest2

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.leanback.app.BackgroundManager
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import f.r.humatest.MovieList
import org.w3c.dom.Text
import java.util.*

class MainFragment : BrowseSupportFragment() {
    private lateinit var mBackgroundManager: BackgroundManager
    private var mDefaultBackground: Drawable? = null
    private lateinit var mMetrics: DisplayMetrics

    companion object {
        private val NUM_ROWS = 2
        private val NUM_COLS = 15
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        prepareBackgroundManager()
        setupUIElements()
        loadRows()
        setupEventListeners()
    }

    private fun prepareBackgroundManager() {

        mBackgroundManager = BackgroundManager.getInstance(activity)
        mBackgroundManager.attach(requireActivity().window)
        mDefaultBackground = ContextCompat.getDrawable(requireContext(), R.drawable.bg_main_fragment_browser)
        mMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(mMetrics)
        updateBackground("https://dx35vtwkllhj9.cloudfront.net/universalstudios/ambulance/images/gallery/image1.jpg")

    }

    override fun onInflateTitleView(
        inflater: LayoutInflater?,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return super.onInflateTitleView(inflater, parent, savedInstanceState)
    }
    private fun setupUIElements() {
        title = getString(R.string.browse_title)

        //val textView = titleView as TextView

        /*if (textView!= null){        textView.typeface =
            Typeface.createFromAsset(requireActivity().assets, "fonts/iransans_mobile_fa_num_bold.ttf")
        }else{
            Toast.makeText(requireContext(),"sd",Toast.LENGTH_LONG).show()
        }*/

        // over title
        headersState = BrowseSupportFragment.HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true

        // set fastLane (or headers) background color
        brandColor = ContextCompat.getColor(requireContext(), R.color.search_opaque)
        // set search icon color
        searchAffordanceColor = ContextCompat.getColor(requireContext(), R.color.lb_media_background_color)
    }

    private fun setupEventListeners() {
        setOnSearchClickedListener {
            Toast.makeText(requireContext()!!, "Implement your own in-app search", Toast.LENGTH_LONG)
                .show()
        }

    }

    private fun loadRows() {
        val list = MovieList.list

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        val cardPresenter = CardPresenter()

        for (i in 0 until NUM_ROWS) {
            if (i != 0) {
                Collections.shuffle(list)
            }
            val listRowAdapter = ArrayObjectAdapter(cardPresenter)
            for (j in 0 until NUM_COLS) {
                listRowAdapter.add(list[j % 5])
            }
            val header = HeaderItem(i.toLong(), MovieList.MOVIE_CATEGORY[i])
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }


        adapter = rowsAdapter
    }

    private fun updateBackground(uri: String?) {
        val width = mMetrics.widthPixels
        val height = mMetrics.heightPixels
        Glide.with(requireContext())
            .load(uri)
            .centerCrop()
            .error(mDefaultBackground)
            .into<SimpleTarget<Drawable>>(
                object : SimpleTarget<Drawable>(width, height) {
                    override fun onResourceReady(
                        drawable: Drawable,
                        transition: Transition<in Drawable>?
                    ) {
                        mBackgroundManager.drawable = drawable
                    }
                })
    }

}