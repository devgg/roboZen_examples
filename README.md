# roboZen examples

This repository provides examples which help to get started with the roboZen library.
The examples run out of the box with the Windows operating system.
Users of Unix based operating systems need additional setup, described [here](#unix).

##Examples

Currently the following three main classes are included in the repository.



####AutomaticSetupWinMain
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



##Windows
Running the examples on Windows is very straight forward. Only three commands are requiered.

```
git clone git@github.com:devgg/roboZen_examples.git
cd roboZen_examples
gradlew -PmainClass=edu.kit.robozen.example.<MainClass> execute
```


##Unix
On Unix based operating systems additional setup is requiered.

1. The binaries of the robocup server and monitor need to be build for your operating system.
2. The server and monitor need to be started manually.
3. The main method can not contain any Windows specific Util methods.


