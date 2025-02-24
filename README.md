# Avaj-Launcher

From a provided UML class diagram. Must implement it in Java using the Observer, Singleton and Factory patterns.

Default package is forbidden, the code has been writen without IDE and is compiled with basic Java/JavaC commands.

## Usage

java avaj_launcher.main.Main [FILE]

java avaj_launcher.main.Main --help

## Behaviour

This program runs a simulation of aircrafts, weather, and towers.

Aircrafts have a type (Baloon, JetPlane, Helicopter), name and coordinates (Longitude, Latitude, Height).

Each iteration, aircrafts move based on the weather. Weather is coordinate based. The weather is SUN, FOG, RAIN or SNOW.

Aircrafts log a message based on the weather after each interation.

Aircrafts that reach height 0 are considered as grounded, they don't update anymore.

## Input format.

The input is a single text file.

The first line of the text file must be a number representing how many iterations the program will simulate.

Each following line represents an aircraft, and must be formatted this way: TYPE NAME LONGITUDE LATITUDE HEIGHT.
