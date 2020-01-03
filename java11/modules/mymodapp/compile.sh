echo "JAVA11 ---- PATH:::" $JAVA11_HOME

$JAVA11_HOME/bin/java -version

#Functions
$JAVA11_HOME/bin/javac -d result/appfuncs appsrc/appfuncs/appfuncs/simplefuncs/SimpleMathFuncs.java
$JAVA11_HOME/bin/javac -d result/appfuncs appsrc/appfuncs/module-info.java

#App testing
$JAVA11_HOME/bin/javac --module-path result -d result/appstart appsrc/appstart/module-info.java
$JAVA11_HOME/bin/javac --module-path result -d result/appstart appsrc/appstart/appstart/mymodappdemo/MyModAppDemo.java

#Execute application
$JAVA11_HOME/bin/java --module-path result -m appstart/appstart.mymodappdemo.MyModAppDemo
