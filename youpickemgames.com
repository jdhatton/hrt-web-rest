 

<VirtualHost *>
	ServerAdmin jdhatton@gmail.com
	ProxyPreserveHost On
  	ServerName youpickemgames.com
  	ProxyPass  /excluded !
  	ProxyPass / http://127.0.0.1:9000/
  	ProxyPassReverse / http://127.0.0.1:9000/ 
	 
	ErrorLog /opt/apps/ypg2/logs/error-ypg2.log

	# Possible values include: debug, info, notice, warn, error, crit,
	# alert, emerg.
	LogLevel info

	CustomLog /opt/apps/ypg2/logs/access-ypg2.log combined
</VirtualHost>
