# Welcome to Kotlin Clean Base!

This project is intended to be used as a template for new projects to come in Android. Currently the project is all set up to start coding in what matters the most. The architecture selected is Clean Architecture.

It has some dependencies ready to go, such as ***Retrofit*** for service calls, ***RxJava***
to handle services data and errors, ***Dagger*** for Dependency Injection, ***Authenticator*** to handle users accounts using *Android's Account Manager.*


# Classes

Some of the important classes are listes below:

## SmartLiveData

The same *MutableLiveData* with a twist. It notifies the view the different states of the data that were on hold when the app went to backgrond. This way, we ensure every data is emitted to the view.

## AccountsManager

Class responsible to manage user's account securely, and without all the pain.

## UserDataManager

An abstraction of *SharedPreferences* to save user preferences effortlesly.

## Delete a file

You can delete the current file by clicking the **Remove** button in the file explorer. The file will be moved into the **Trash** folder and automatically deleted after 7 days of inactivity.

## BaseObserver

An abstraction of *DefaultObserver* from Rx's library, to handle rx flows.
