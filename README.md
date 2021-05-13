# GpsCoordinates project

## Why this project?
This little Java project has been created to show to students in Seconde SNT that OpenStreetMap is an Open-Data database.
It is consequently possible to use the [API](https://en.wikipedia.org/wiki/API) and a reverse API to get data from the database through a [REST API](https://en.wikipedia.org/wiki/Representational_state_transfer).
It will print on an interface the latitude and the longitude of a place.

## How does it work?
### The programming environment
The working principle of this program is pretty simple. We use an IDE (in my case Intellij IDEA) in order to program in Java language.

### The user interface
We have to build a simple interface thanks to [Swing](https://en.wikipedia.org/wiki/Swing_(Java)) for the UI. We just have to drag and drop elements on the main frame.
We have to create events (listeners) on each element, for example for a button click. We have to put these listeners in the constructor of the [UI Java class](https://github.com/jocelynr24/GpsCoordinates/blob/master/src/net/routin/GpsCoordinatesUI.java).

### Get the data on the OpenStreetMap API
To get the data of the OpenStreetMap API, we have to use a reverse API such as [Nominatim](https://wiki.openstreetmap.org/wiki/Nominatim) that gives us the GPS coordinates (latitude and longitude) by providing a place name.
Then, the API will return a file in a [JSON](https://en.wikipedia.org/wiki/JSON) format, and we now have to translate this specific format to make the code to understand the data.

#### Get the JSON file ([this part](https://github.com/jocelynr24/GpsCoordinates/blob/master/src/net/routin/GpsCoordinates.java#L14-L35))
To get the JSON file, we just have to find a method (a kind of function) that reads the online file. It can be easily found on the Internet.

#### Deserialize (or parse) the JSON file ([this part](https://github.com/jocelynr24/GpsCoordinates/blob/master/src/net/routin/GpsCoordinates.java#L37-L48))
Now, we have to give the URL that returns this JSON file to the previous method. We have to convert the JSON text file into a Java object: we call this process "deserialization" or "parsing". To do that, we use [Google Gson](https://en.wikipedia.org/wiki/Gson), an open-source library created by Google.
To use this library, we need to create a "class", which is a kind of "paper" that describe an "object". So, we will create an object using this class thanks to Gson, that will retreive the latitude, the longitude and the complete display name of the place. ([this part](https://github.com/jocelynr24/GpsCoordinates/blob/master/src/net/routin/Models/Coordinates.java))
Finally, we return the coordinates as a list (a kind of dynamic array).

### Call the methods thanks to the listeners ([this part](https://github.com/jocelynr24/GpsCoordinates/blob/master/src/net/routin/GpsCoordinatesUI.java#L32-L73))
Now, we just have to create listeners in the constructor (a special method which is called when the object is created), which are events attached to the objects of the UI (e.g. the click on a button).
Here, we just have to call the previous methods that we created.

### The main method ([this part](https://github.com/jocelynr24/GpsCoordinates/blob/master/src/net/routin/GpsCoordinatesUI.java#L75-L85))
Finally, we just have to create the frame of our program in the main method that contains all the buttons, inputs, etc.

## Contributors
Thanks to OpenStreetMap Contributors for the reverse API, Google Gson for the JSON parser and Jocelyn Routin for coding this program.
