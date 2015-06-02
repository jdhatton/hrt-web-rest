{\rtf1\ansi\ansicpg1252\cocoartf1347\cocoasubrtf570
{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset0 AndaleMono;\f2\fnil\fcharset0 LucidaGrande;
}
{\colortbl;\red255\green255\blue255;\red47\green255\blue18;}
\margl1440\margr1440\vieww15520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural

\f0\fs24 \cf0 \
echo STARTING SERVER\
\
nohup 
\f1 \cf2 \cb0 \CocoaLigature0 $JAVA_HOME/bin/java -jar web-rest-dp-0.0.1-SNAPSHOT.jar server hello-world.yml > 
\f2\fs26 \cf0 \cb1 \CocoaLigature1 /opt/logs/hrt-rest.log &\
\
echo SERVER STARTED\
\
\
}