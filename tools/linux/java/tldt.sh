#!/bin/sh
################################################################################
#  Copyright hsit. All rights reserved.
################################################################################

. ./setenv.sh

if [ ! -n "$DT_CLASSPATH" ]; then
        echo "DT_CLASSPATH is not set."
        exit 0
fi

$JAVA_HOME/bin/java -ea -classpath $DT_CLASSPATH $DEBUG_OPTIONS -Xms256m -Xmx1024m -DDT_HOME=$DT_HOME com.icsshs.datatransfer.DtServer $*
