# roboZen examples

This repository provides examples which help to get started with the roboZen library.
The examples run out of the box with the Windows operating system.
Users of Unix based operating systems need additional setup, described [here](#unix).

##Getting started

####Windows
Running the examples on Windows is very straight forward. Only three commands are required.

```
git clone git@github.com:devgg/roboZen_examples.git
cd roboZen_examples
gradlew -PmainClass=edu.kit.robozen.example.<REPLACE_WITH_THE_MAIN_CLASS_TO_USE> execute
```

Alternatively you can clone via https: ``git clone https://github.com/devgg/roboZen_examples.git``.  
The main classes that can be used are ``AutomaticSetupMain``, ``ManualSetupMain`` and ``PerPlayModePolicyMain``. Descriptions for these classes can be found [here](#guide).



####Unix
On Unix based operating systems additional setup is required.

1. The binaries of the robocup server and monitor need to be build for your operating system.
2. The server and monitor need to be started manually.
3. The main method can not contain any Windows specific Util methods.

##Guide

Currently three main classes are included in the repository. In the following context manually means that code needs to be included for the action to be performed.

####AutomaticSetupMain
Teams are setup automatically with a basic policy.  
Ball and players get moved manually.  
The game starts automatically.

####ManualSetupMain
Teams are setup manually with a basic policy.  
Ball and players get moved manually.  
The game starts manually.

####PerPlayModePolicyMain
Teams are setup automatically with multiple policies which apply based on the current playmode.  
Ball and players get moved automatically.  
The game starts automatically.

####Methods
The most important methods and classes and their parameters are explained below.

Method or Class | Explanation
------------ | -------------
Util.initLogging | Initializes the log4j logging API.
Util.InitWinConfiguration | **Windows only** - Initializes the server and the monitor. Parameters are the server and monitor binary locations and the working directory for them to run in.
IPolicy | Interface that descirbes a policy. A policy is the central controller of a team i.e. controls the moves the team makes. 
Util.TeamDescription | Class that describes a team. Includes the teams policy, the number of players and the player positions.
Util.TrainerCommand | Interface that is used to execute trainer commands before the game e.g. move the ball or position a player.
Util.executeGameWin | **Windows only** - Executes a game includes the whole setup procedure.
Team | Class representing a team. Includes the pitchside, the number of players and the teams policy.
Team.connectAll | Creates a thread for each player which connects to the server.
Trainer | Class representing the trainer.
Trainer.connect | Creates a thread for the trainer which connects to the server.
Trainer.moveBall | Moves the ball before the game. Can only be used when the trainer is connected to the server.
Trainer.movePlayer | Moves a player before the game. Can only be used when trainer and player are connected to the server.

##License

MIT License

Copyright (c) [year] [fullname]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.



