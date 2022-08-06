package f.r.humatest2.dataClass

import java.io.Serializable

/**
 * Movie class represents video entity with title, description, image thumbs and video url.
 */
data class Movie(
    var id: Long = 0,
    var backgroundImageUrl: String? = null,
    var cardImageUrl: String? = null
) {



}