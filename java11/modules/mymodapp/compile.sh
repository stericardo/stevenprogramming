echo "JAVA11 ---- PATH:::" $JAVA11_HOME

$JAVA11_HOME/bin/java -version

#Functions
$JAVA11_HOME/bin/javac -d result/appfuncs appsrc/funciones/appfuncs/simplefuncs/SimpleMathFuncs.java
$JAVA11_HOME/bin/javac -d result/appfuncs appsrc/funciones/module-info.java
echo "Next1"
#App testing
$JAVA11_HOME/bin/javac --module-path result -d result/applications appsrc/applications/module-info.java
$JAVA11_HOME/bin/javac --module-path result -d result/applications appsrc/applications/appstart/mymodappdemo/MyModAppDemo.java
echo "Next2"
#Execute application
$JAVA11_HOME/bin/java --module-path result -m appstart/appstart.mymodappdemo.MyModAppDemo

$JAVA11_HOME/bin/jdeps $JAVA11_HOME/lib/jrt-fs.jar
$JAVA11_HOME/bin/jdeps -profile $JAVA11_HOME/lib/jrt-fs.jar
