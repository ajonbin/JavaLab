# Class Loading

~~~

$ java classes/com.ajonbin.javalab.classloader.UseClassLoader
Error: Could not find or load main class classes.com.ajonbin.javalab.classloader.UseClassLoader

$  java -cp classes/ classes/com.ajonbin.javalab.classloader.UseClassLoader
Error: Could not find or load main class classes.com.ajonbin.javalab.classloader.UseClassLoader

$  java -cp classes/ com.ajonbin.javalab.classloader.UseClassLoader
Hello from ClassLoaderHelperMsg

$ rm -rf classes/com/ajonbin/javalabhelper/

$ java -cp classes/ com.ajonbin.javalab.classloader.UseClassLoader
Exception in thread "main" java.lang.NoClassDefFoundError: com/ajonbin/javalabhelper/classloaderhelper/ClassLoaderHelperMsg
	at com.ajonbin.javalab.classloader.UseClassLoader.main(UseClassLoader.java:7)
Caused by: java.lang.ClassNotFoundException: com.ajonbin.javalabhelper.classloaderhelper.ClassLoaderHelperMsg
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:335)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	... 1 more
	
$ javac -d classes src/main/java/com/ajonbin/javalabhelper/classloaderhelper/ClassLoaderHelperMsg.java 

$ cd classes/
$ classes haimhuan$ jar -cvf helpermsg.jar com/ajonbin/javalabhelper/classloaderhelper/ClassLoaderHelperMsg.class 
added manifest
adding: com/ajonbin/javalabhelper/classloaderhelper/ClassLoaderHelperMsg.class(in = 372) (out= 255)(deflated 31%)

$ tree
.
├── com
│   └── ajonbin
│       ├── javalab
│       │   └── classloader
│       │       └── UseClassLoader.class
│       └── javalabhelper
│           └── classloaderhelper
│               └── ClassLoaderHelperMsg.class
└── helpermsg.jar

6 directories, 3 files

$ classes haimhuan$ mv helpermsg.jar ../lib/

$ classes haimhuan$ cd ..

$  rm -rf classes/com/ajonbin/javalabhelper/

$  java -cp classes/ com.ajonbin.javalab.classloader.UseClassLoader
Exception in thread "main" java.lang.NoClassDefFoundError: com/ajonbin/javalabhelper/classloaderhelper/ClassLoaderHelperMsg
	at com.ajonbin.javalab.classloader.UseClassLoader.main(UseClassLoader.java:7)
Caused by: java.lang.ClassNotFoundException: com.ajonbin.javalabhelper.classloaderhelper.ClassLoaderHelperMsg
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:335)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	... 1 more
	
$  java -cp classes:lib/helpermsg.jar com.ajonbin.javalab.classloader.UseClassLoader
Hello from ClassLoaderHelperMsg

~~~

# Self-define ClassLoader

~~~
$ cd javalab

$ javac -d iclasses src/main/java/com/ajonbin/javalabhelper/interfaces/IMessager.java

$ javac -cp iclasses/ -d impclasses/ src/main/java/com/ajonbin/javalabhelper/classloaderhelper/MessagerEnglish.java

$ javac -d classes -cp iclasses src/main/java/com/ajonbin/javalab/classloader/StaticMessagerClassLoader.java

$ java -cp classes:iclasses com.ajonbin.javalab.classloader.StaticMessagerClassLoader
Hello From MessagerEnglish!
