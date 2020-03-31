# Change Log

## v0.2.5
* Implemented support for muxed streams (streams with both audio and video)

## v0.2.4
* Added possibility to use custom OkHttpClient, it allows to deal with region restricted videos.
* Implemented executeWithRetry() function for network calls, now each request will be executed up to 3 times before ExtractionException throw.
* Added CHANGELOG.md.

## v0.2.3
* Proguard is turned off (fixes #16).

## v0.2.2
* Fixed getVideoInfoForAgeRestrictedVideo() function.
* Implemented HttpLoggingInterceptor to log requests headers.
* Refactoring.

## v0.2.1
* Improved error handling.
* Bumped gradle version.

## v0.2.0

* Library is finally fixed and fully works.
* Minimum SDK version now is 19.

## v0.1.9

* Fixed problem with age restricted videos.
* Improved stability of signature decryption.
* Library size reduced even more.
* Various refactorings.

## v0.1.8

* Fixed an issue where environment variables are escaped in script.

## v0.1.7

* LiquidCore js interpreter swapped with Rhino.
* Improved error handling.
* Minor fixes and refactorings here and there.
* Reduced library size.

## v0.1.6

* Regular expressions for decryption function extraction updated.

## v0.1.5

* Fixed an issue where emulator is killed prematurely.
* Added `-gpu swiftshader_indirect` to default `launch-options`.
* Added support for pinning a specific `emulator-build` - e.g. `6061023` for emulator **v29.3.0.0**.

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

* Implemented Streamitem enums.

## v0.1.1

* Implemented workaround for issue when youtube serves invalid signatures for encrypted videos what leads to 403 Forbidden error.

## v0.1.0

* Initial release.
