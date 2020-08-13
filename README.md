 # YoutubeJExtractor for Android! ![Android CI](https://github.com/kotvertolet/youtube-jextractor/workflows/Android%20CI/badge.svg)

YoutubeJExtractor is Android extractor library that allows you to extract video and audio from any youtube video along with some other data such as a video title, description, author, thumbnails and others.

This library was initially created for my android app [Youtube audio player](https://github.com/kotvertolet/youtube-audio-player)
## Features
1. Extracts video and audio streams from Youtube videos. Supports both adaptive and muxed streams.
2. Extracts various video data like title, description, view count, channel id, etc.
3. Supports age restricted videos.
4. Supports videos with restricted embedding.
5. Supports regon restricted videos (through a proxy).
6. Supports HLS and DASH live streams.
7. Supports subtitles extraction 
 
## How to install
[![](https://jitpack.io/v/kotvertolet/youtube-jextractor.svg)](https://jitpack.io/#kotvertolet/youtube-jextractor)

## What's new?
### v0.3.2
Subtitles extraction implemented

### v0.3.1
Bug fixes

### v0.3.0
1. Fixed NPE #28, thanks @niteshfel for reporting
2. Implemented new overloaded extract method that takes callback as parameter:
```java
     youtubeJExtractor.extract(videoId, new JExtractorCallback() {
            @Override
            public void onSuccess(YoutubeVideoData videoData) {
                // use extracted data
            }

            @Override
            public void onNetworkException(YoutubeRequestException e) {
                // may be a connection problem, ask user to check his internet connection
            }

            @Override
            public void onError(Exception exception) {
                // some serious problem occured, just show some error message
            }
        });
```
<details>
  <summary>Older versions</summary>
 
### v0.2.9
Minor changes, increased stability and logging is slightly improved

### v0.2.8
1. Code updated to match latest youtube changes
2. Improved age restricted videos detection

### v0.2.5:
Muxed streams are now supported! Thanks to @comptoost for enchancement request 

### v0.2.4:
1. Possibility to use YoutubeJExtractor with custom `OkHttpClient` instance via the following one argument constructor - `YoutubeJExtractor(OkHttpClient client)`. It could be usefull for region restricted video (via creating `OkHttpClient` instance with proxy).
2. Implemented RequestExecutor class with `executeWithRetry(...)` method - now every http call will be executed up to 3 times before `YoutubeRequestException` throw, it will increase stability.
</details>

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
* **StreamingData** contains two fields with the lists of adaptive streams (video and audio), ***muxedStreams** contains as the name implies muxed streams (streams that contain both audio and video) ***dashManifestUrl*** and ***hlsManifestUrl*** fields which are contains links to the DASH and HLS manifests (if you dealing with a live stream) and ***expiresInSeconds*** which indicates how long links will be alive.
 
To get all the video streams:
```java
    List<AdaptiveVideoStream> videoStreamsList = videoData.getStreamingData().getAdaptiveVideoStreams()
``` 

Each StreamItem object contains fields that describe the stream such as:
* it's ***extension*** (like mp4, ogg, etc),
* ***codec***, ***bitrate***, ***url*** and many others. 

 Check `AdaptiveVideoStream.class` and `AdaptiveAudioStream.class` for the details.
 
 ### Live streams
 
Live streams are also supported by ***YoutubeJextractor***, but you have to treat them differently than the regular videos, to play live content you have to use ***DASH*** or ***HLS*** manifests. Your code will look like this:
```java
YoutubeVideoData videoData = youtubeJExtractor.extract("stream_video_id");
if (videoData.getVideoDetails().isLiveContent()) {
    String dashManifest = videoData.getStreamingData().getDashManifestUrl();
   // or use HLS manifest via getHlsManifestUrl() method
}
else {
...
}
```
Then you have to decide how to deal with manifest url, it depends on how you're gonna play media content, for instance, if you are using [ExoPlayer](https://exoplayer.dev/), please refer to the [DASH](https://exoplayer.dev/dash.html) and [HLS](https://exoplayer.dev/hls.html) guides.

 ### Subtitles
Subtitles extraction is very simple:
 ```java
 youtubeJExtractor.extractSubtitles(videoId)
 ```
This line will return a map where key is language and value is a list of subtitle lines with time codes. **Note that autogenerated subtitles are not currently supported.

## FAQ
### Q: What is a muxed stream?
[Muxed](https://wiki.videolan.org/Muxing/) stream is a stream that contains video and audio at the same time. My library extracts muxed streams along with [demuxed](https://wiki.videolan.org/Demuxing/) that contain only video or audio.

### Q: I need to play both video and audio at the same time, but your library gives me no muxed streams (or they have lower quality), is it a bug of the library?
No, it's not, my library extracts *everything* what youtube provides for the specific video, but for some youtube's internal reasons they have different set of streams available for each video, sometimes there are muxed streams sometimes there aren't. But it's not a problem because you can take separately audio and video stream and then combine them into a single, muxed stream, with any quality you want! 
 #### How to do that?
Depends on how you're gonna play your streams, for instance if you're using ExoPlayer (what I personally recommend for media playback in andoird) you need to take a look at [MergingMediaSource.class](https://exoplayer.dev/doc/reference/com/google/android/exoplayer2/source/MergingMediaSource.html):

``` java

MediaSource videoSource = new ProgressiveMediaSource.Factory(...)
    .createMediaSource(videoUri);
MediaSource audioSource = new ProgressiveMediaSource.Factory(...)
    .createMediaSource(audioUri);

MergingMediaSource mergedSource = new MergingMediaSource(videoSource, audioSource);
```

## Requirements

Works on API 19+.

## Credits

[Youtube-dl](https://github.com/ytdl-org/youtube-dl) - the idea and implementation were influenced by Youtube-dl
 
## License

 Distributed under the GPL v2 License. See [LICENSE.md](https://github.com/kotvertolet/YoutubeJExtractor/blob/master/LICENSE) for terms and conditions.
