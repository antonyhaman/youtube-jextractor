# Change Log

## v0.2.4

* Added possibility to use custom OkHtppClient which allows to deal with region restricted video.
* Implemented executeWithRetry() function for network calls, each request will be executed up to 3 times before YoutubeRequestException throw. 
* Added changelog.md.

## v0.2.3

* Proguard is turned off, fixes #16.

## v0.2.2

* Fixed getVideoInfoForAgeRestrictedVideo() function.
* Improved logging.
* Little code cleanup.

## v0.2.1

* Improved logging.
* Implemented OkHttpClient interceptor to log requests headers.
* Gradle version bumped.

## v0.2.0

* Various fixes to match latest youtube changes.
* Library is finally works.

## v0.1.9

* Fixed problem with age restricted video.
* Improved stability of signature decryption.
* Library size reduced even more.
* Various refactorings.

## v0.1.8

* LiquidCore js interpreter swapped with Rhino.
* Improved error handling.
* Minor fixes and refactorings here and there.
* Reduced library size.

## v0.1.7

* Added support for DASH and HLS streams by extracting manifests for live streams.

## v0.1.6

* Added new regular expressions for decryption function extraction.

## v0.1.5

* Documentation improvement.

## v0.1.4

* Added support for videos with restricted embedding.
* Added support for age restricted videos.
* All unchecked exceptions changed to custom checked exceptions.
* Improved stability of network calls.
* Slightly changed API with splitted streams into two objects (VideoStreamItem and AudioStreamItem) instead of a single StreamItem class for all streams.
* Various refactorings.

## v0.1.3

* This release is made to overlap previous 0.1.2 which was broken.

## v0.1.2

* Implemented StreamItems enum for convinience.

## v0.1.1

* Implemented workaround for issue when youtube serves invalid signatures for encrypted videos what leads to 403 Forbidden error.

## v0.1.0

Initial release.
