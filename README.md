# roboZen examples

This repository provides examples which help to get started with the roboZen library.
The examples run out of the box with the Windows operating system.
Users of Unix based operating systems need additional setup, described [here](#unix).


```
gradlew -PmainClass=<MainClass> execute
```
```
gradlew -PmainClass=edu.kit.robozen.example.AutomaticSetupWinMain execute
gradlew -PmainClass=edu.kit.robozen.example.ManualSetupMain execute
gradlew -PmainClass=edu.kit.robozen.example.PerPlayModePolicyMain execute
```

```java
function fancyAlert(arg) {
  if(arg) {
    $.facebox({div:'#foo'})
  }
}
```

##Unix
On Unix based operating systems additional setup is requiered.

1. The binaries of the robocup server and monitor need to be build for your operating system.
2. The server and monitor need to be started manually.
3. The main method can not contain any Windows specific Util methods.


