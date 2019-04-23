SET JDK_HOME=C:\Program Files\Java\jdk1.8.0_131
SET JAVA_HOME=%JDK_HOME%
SET GRADLE_HOME=C:\Java_development\Build_tools\gradle-4.10.2
SET PATH=%JAVA_HOME%\bin;%GRADLE_HOME%\bin;%PATH%

CD ..
GRADLE tasks
