# CazooTask

This is a simple project that loads Vehicle data from remote server and shows them in a list and
also in detail.the app's architecture is MVVM.

### Tools

* Android Studio Arctic Fox | 2020.3.1 Patch 4
* Jdk 11
* Koltin plugin 1.6.10
* Gradle 7.0.2
* Android Gradle Plugin 7.0.4

### Dependencies

* Dagger Hilt: for dependency Injection. it is easy to use instead of dagger and other libraries
* Retrofit: used for remote restApi. it is great for rest api and also works good with coroutin.
* OkHttp: for internet connection as client for retrofit.
* Coroutine: used int for thread handeling. it is easy to understand and use instead of rxjava or
  other ways.
* Navigation Component: for desinging single activity app and also navigation of application and
  pass parmaters between fragments.
* Glide: it is used for loading and downloading images.
* architecture components
    * LiveData
    * ViewModel
    * Lifecycle
* Turbine: for unit testing flows
* Truth: for unit test assertion
* 