# YoutubeJExtractor for Android

YoutubeJExtractor is Android library that allows you to extract youtube video and audio from any youtube video along with some other data such as a video title, description, author, thumbnails and others.

This library was initially created for my android app [Youtube audio player](https://github.com/kotvertolet/youtube-audio-player)
 
## How to install
[![](https://jitpack.io/v/kotvertolet/youtube-jextractor.svg)](https://jitpack.io/#kotvertolet/youtube-jextractor)

## What's new?
In 0.2.4 were added two main things:
1. Possibility to use YoutubeJExtractor with custom `OkHttpClient` instance via the following one argument constructor - `YoutubeJExtractor(OkHttpClient client)`. It could be usefull for region restricted video (via creating `OkHttpClient` instance with proxy).
2. Implemented RequestExecutor class with `executeWithRetry(...)` method - now every http call will be executed up to 3 times before `YoutubeRequestException` throw, it will increase stability.

## How to use

```java
    YoutubeJExtractor youtubeJExtractor = new YoutubeJExtractor();
    YoutubeVideoData videoData;
    try {
        videoData = youtubeJExtractor.extract(videoId);
    }
    catch (ExtractionException e) {
        // Something really bad happened, nothing we can do except just show some error notification to the user 
    }
    catch (YoutubeRequestException e) {
        // Possibly there are some connection problems, ask user to check the internet connection and then retry 
    }
``` 
**YoutubeVideoData** is an object that contains data for the requested 
video split across two main objects: **VideoDetails** and **StreamingData**.

* **VideoDetails** contains various video data such as title, description, author, rating, view count, etc.
* **StreamingData** contains two fields with the lists of streams (video and audio), ***dashManifestUrl*** and ***hlsManifestUrl*** fields which are contains links to the DASH and HLS manifests (if you dealing with a live stream) and ***expiresInSeconds*** which indicates how long links will be alive.
 
To get all the video streams:
```java
    List<VideoStreamItem> videoStreamsList = videoData.getStreamingData().getVideoStreamItems()
``` 

Each StreamItem object contains fields that describe the stream such as
 it's ***extension*** (like mp4, ogg, etc),
 ***codec***, ***bitrate***, ***url*** and many others. 
 Check *VideoStreamItem.class* and *AudioStreamItem.class* for the details.

## Requirements

Tested on API 19+.

## Credits

[Youtube-dl](https://github.com/ytdl-org/youtube-dl) - the idea and implementation were influenced by Youtube-dl
 
## License

 Distributed under the GPL v2 License. See [LICENSE.md](https://github.com/kotvertolet/YoutubeJExtractor/blob/master/LICENSE) for terms and conditions.
