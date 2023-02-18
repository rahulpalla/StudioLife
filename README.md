# StudioLife
# Introduction
Kotlin is the leading high-level language used by android developers. Kotlin is also fully interoperable with Java, meaning you can have Java files and Kotlin files in your app seamlessly.

The reason Kotlin is used over Java for app development is because it has better support for Android like having null safety and Android extensions.
Environment
Android Studio Is an IDE used for Android app development and is what we used in this tutorial.
Go to this link to learn more about installing Android Studio: https://developer.android.com/studio/install
With Android Studio you can create AVDs (Android Virtual Devices) so you can test your app on an emulator in the same IDE window.
Before running an app, click on “Device Manager” in the side bar and create your AVD

![alt text](https://drive.google.com/file/d/1wmLSWeCXKlgpo-FVxww0ZHTMNOaYIHbn/view?usp=share_link)

Then you can select your app and the AVD you made and run your app

# Official Android Developer guides
Google has a lot of tutorials and resources about Android App development with Kotlin
This course has all the basics for Kotlin development: https://developer.android.com/courses/android-basics-kotlin/course
Our App 
Studio Life is essentially a game of MASH where the user inputs a bunch of answers to questions like “Where do you want to live?”. Then an option is randomly chosen for each category and then displayed on the final page to the user to reveal their life story.
# Basics

# Xml

XML files are essentially the front end code of your app. All of the designs and stylings of the app and how it looks are here. This includes colors, adding images, view types, etc.
# Activities
This is essentially where the back end code of your app is. All major functions, pulling from databases, creating objects and how the app functions are here.

Usually, for every XML file that outlines the design of the page, there is an Activity that defines the function of the page 

# Navigation (intent, binding)

# RecyclerView
This is what we use on our entry page to repeat the list of questions that the user will provide inputs for, allows for more concise code and reduces code repetition

# Resource Manager (on the left side bar)
Where you can add drawables (images), colors, layout, etc to your app

# Our App Features
Game of MASH essentially
# Quick summary of file content
- QuestionCardAdapter, DataSource, and Question files create our question object and list that we use in our recycler view (more details below)
- activity _main,xml and MainActivity.kt - defines our start page
- Entry_form_full.xml creates our recycler view, entry_form.xml defines what will be repeated inside the recycler view, and EntryFormActivity.kt is what launches our QuestionCardAdapter and our recycler view
You can organize the app in various ways. We decided to split up the code for the app in ways such as  Adapter, Data, Model, Activities, and more
- Data -> DataSource  - created a Question object with a list of questions
Each question contained an image, question string, and three other string inputs that are initialized to null until the user enters those values in
- Model -> Question  - our question object to create a list of
- Adapter - creates the recycler view with our list of questions and also takes in user input

- Every image (or resource in general) has an Id that we defined in the xml file and we use this Id to find resources and assign them to variables
App > src > main > res > entry_form..xml

- The recycler view will “recycle” our entry form layout multiple times for all of our questions that we defined in our DataSource
The adapter also handles setting values to our initially null input fields with user input by using text listeners

			
# Firebase [ code in EndActivity.kt ]
	
Firebase is an example of a backend database that you can use for your apps. It is easy to connect the database to your app. Simply navigate to the tools section and click on Firebase and there are 1-2 steps you need to do to connect it
Once it is connected, you can load in data to the database such as image, and call it from your app, leaving you with a fully connected and functioning full stack application.
#Connecting to Firebase
On android studio, on the top navigation bar click Tools > Firebase and an Assistant will pop up with guides on how to connect to various Firebase services
For this app we pulled an image from Firebase using Cloud Storage (on the Firebase Assistant scroll to ‘Cloud Storage for Firebase’ for a more in depth guide)
#Steps:
- Connect to Firebase
- Add Cloud Storage 
  - The Assistant has these two steps listed and can automatically add the dependencies for you
  - The build.gradle file is where you have all your app dependencies listed
  - When you edit the build.gradle file SYNC YOUR APP for the changes to be reflected 
- Add code to your project to pull the image
  - The code we used to download an image is listed in the EndActivity,kt page
  - We received a reference to the image from Cloud Storage and then created a ByteArray of that image, from the ByteArray we then created a Bitmap that maps all the bytes to colors for our image, and then finally set our image to the Bitmap
  - The Assistant and Firebase documentation has tutorials for various different use cases of Firebase: https://firebase.google.com/docs/build


