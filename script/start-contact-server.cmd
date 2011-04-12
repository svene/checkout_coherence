#!/bin/sh

# This will start a cache server

# specify the Coherence installation directory

# specify the JVM heap size
MEMORY=512m

if [ -f $JAVA_HOME/bin/java ]; then
  JAVAEXEC=$JAVA_HOME/bin/java
else
  JAVAEXEC=java
fi

JAVA_OPTS="-Xms$MEMORY -Xmx$MEMORY -Dtangosol.coherence.cacheconfig=contacts-cache-config.xml -Dtangosol.pof.config=contacts-pof-config.xml"

$JAVAEXEC -server -showversion $JAVA_OPTS -cp "../0_localrepository/coherence.jar:../build/classes/main" com.tangosol.net.DefaultCacheServer $1
