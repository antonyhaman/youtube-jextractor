# YoutubeJExtractor for Android

YoutubeJExtractor allows you to extract youtube video and audio streams 
from any youtube video along with some other data such as a video title,
 description, author, thumbnails and others.
 
## Current status

WIP, library is partially functional but not well tested and documented

## How to install
[![](https://jitpack.io/v/kotvertolet/YoutubeJExtractor.svg)](https://jitpack.io/#kotvertolet/YoutubeJExtractor)


## How to use

```java
    YoutubeJExtractor = new YoutubeJExtractor();
    YoutubeVideoData videoData = youtubeJExtractor.extract(videoId);
``` 
**YoutubeVideoData** is an object that contains information for the requested 
video that split across two main objects: **VideoDetails** and **StreamingData**.

* **VideoDetails** contains video title, description, author, rating, view count, etc.
* **StreamingData** contains list of streams (both video and audio) and ***expiresInSeconds***
field which indicated how long links will be alive.
 
To extract all the streams:
```java
    List<StreamItem> streamItems = videoData.getStreamingData().getStreamItems()
``` 

Each StreamItem object contains fields that describe the stream such as
 it's ***type*** (video or audio),  ***extension*** (like mp4, ogg, etc),
 ***codec***, ***bitrate***, ***url*** (guess what it is) and many others. 
 Check *StreamItem.class* for the details.

## Requirements

The minimum SDK level is limited to 16 due to a third-party library limitation

## Credits

[Youtube-dl](https://github.com/ytdl-org/youtube-dl) - the idea and a part
 of implementation were influenced by this project
 
## License

 Distributed under the GPL v2 License. See [LICENSE.md](https://github.com/kotvertolet/YoutubeJExtractor/blob/master/LICENSE) for terms and conditions.