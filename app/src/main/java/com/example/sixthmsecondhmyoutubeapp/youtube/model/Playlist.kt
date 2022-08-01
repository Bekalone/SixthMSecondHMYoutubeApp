package com.example.sixthmsecondhmyoutubeapp.youtube.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Playlist(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    var kind: String,
    var etag: String,
    var idChannel: String,
    var snippet: Snippet,
    var status: Status,
    var contentDetails: ContentDetails,
)
/*    "player": {
    "embedHtml": string
},
    "localizations": {
    (key): {
        "title": string,
        "description": string
    }
}*/

class Snippet(
    /*var publishedAt: datetime,*/
    var channelId: String,
    var title: String,
    var description: String,
    var thumbnails: Thumbnails,
    var channelTitle: String,
    var defaultLanguage: String,
    var localized: Localized,
)

class Thumbnails(
/*{
    (key): {*/
    var url: String,

/*}
},*/
)

class Localized(
    var title: String,
    var description: String,
)

class Status(
    var privacyStatus: String,
)

class ContentDetails(
    var itemCount: Int,
)