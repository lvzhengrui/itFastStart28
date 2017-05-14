
@echo off

set LIB_JARS=
cd ..\lib
@rem for %%i in (*) do set LIB_JARS=%LIB_JARS%;..\lib\%%i

for %%i in (*) do call ..\bin\loop.bat %%i

cd ..\bin

echo %LIB_JARS%
@rem echo -Xms64m -Xmx1024m -XX:MaxPermSize=64M 

java -ea -classpath ..\conf;%LIB_JARS% org.lvzr.fast.bi.etl.TestETL 

cd ..\bin 

pause