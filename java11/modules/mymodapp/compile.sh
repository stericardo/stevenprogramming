../../../../software/jdk-11.0.3/bin/java -version

#Functions
../../../../software/jdk-11.0.3/bin/javac -d result/appfuncs appsrc/appfuncs/appfuncs/simplefuncs/SimpleMathFuncs.java
../../../../software/jdk-11.0.3/bin/javac -d result/appfuncs appsrc/appfuncs/module-info.java

#App testing
../../../../software/jdk-11.0.3/bin/javac --module-path result -d result/appstart appsrc/appstart/module-info.java
../../../../software/jdk-11.0.3/bin/javac --module-path result -d result/appstart appsrc/appstart/appstart/mymodappdemo/MyModAppDemo.java

#Execute application
../../../../software/jdk-11.0.3/bin/java --module-path result -m appstart/appstart.mymodappdemo.MyModAppDemo
