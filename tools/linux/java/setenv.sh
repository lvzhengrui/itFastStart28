#!/bin/sh
################################################################################
#  Copyright 2004-2005 jManage.org. All rights reserved.
################################################################################

if [ ! -n "$JAVA_HOME" ]; then
        echo "Please set JAVA_HOME environment variable. JAVA_HOME must point to a JDK 1.5 installation directory."
    exit 0
fi

if [ ! -n "$DT_HOME" ]; then
    echo "DT_HOME has not set"
    DT_HOME=..
fi

#if [ ! -f "$DT_HOME/lib/tldt*.jar" ]; then
#    echo "Please set DT_HOME environment variable pointing to datatransfer installation directory."
#    exit 0
#fi

##############################
# Determine is this cygwin env
##############################
case "`uname`" in
    CYGWIN*)    DT_PATH_SEP=";"  ;;
    *)          DT_PATH_SEP=":" ;;
esac

DT_CLASSPATH=

for i in $DT_HOME/lib/*.jar
do
    DT_CLASSPATH="$i$DT_PATH_SEP$DT_CLASSPATH"
done

DT_CLASSPATH="$DT_HOME/conf$DT_PATH_SEP$DT_CLASSPATH"

if [ ! -n "$CLASSPATH" ]; then
    DT_CLASSPATH="$DT_CLASSPATH$CLASSPATH"
fi

#echo classpath=$DT_CLASSPATH
