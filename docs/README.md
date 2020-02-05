## Description

It's a rock, paper, scissors game against the computer.  As the game goes along, the computer learns your "pattern" (programming with statistics at first, but eventually using TensorFlow Lite for machine learning) over the course of a defined match and will output the symbol that will beat you.  So for example, if the match is twenty one games, the goal is that the computer will learn enough to win at least 51% of games to win the overall match everytime.  It will eventually use the camera on your phone to capture your actual hand gestures of rock, paper or scissors.  Can you beat the computer?  Let's play!

## Intended users

* Gamers
* Gamblers
* Anyone who thinks they can beat a computer
* Kids
### [User Stories](user-stories.md)

## External services

* TensorFlow Lite [https://www.tensorflow.org/lite] - "Stretch goal"
    * Will be used eventually for object detection, image classification and machine learning. 
* Andoid.hardware.camera2 API [https://developer.android.com/guide/topics/media/camera] - "Stretch goal"
    * This will be used turn on the camera upon start of gameplay, so that the player can use hand gestures to play.  The app will still be able to function without full-time access to this API because i will also have an option to choose rock, paper or scissors icons that will default if the camera API is not working.
* Android Neural Network API [https://developer.android.com/ndk/guides/neuralnetworks] - "Stretch goal"
    * Will be used along side TensorFlow to build and train the camera object detection and machine learning.
* Google sign in [https://developers.google.com/identity/sign-in/android/sign-in]
    * Used to sign in to the game and will also be used to keep the players historical game data for use in the statistical algorithm that will be used to "predict" the players next move.  

## Design Documentation

### [Wireframe Diagram](wireframe.md)

### [Entity-Relationship Diagram](erd.md)