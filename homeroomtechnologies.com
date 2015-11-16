#
#  Example.org (/etc/apache2/sites-available/www.example.org)
#
<VirtualHost *>
	ServerAdmin jdhatton@gmail.com
	ProxyPreserveHost On
  	ServerName homeroomtechnologies.com
  	ProxyPass  /excluded !
  	ProxyPass / http://127.0.0.1:9010/
  	ProxyPassReverse / http://127.0.0.1:9010/ 
	 
	ErrorLog /opt/apps/hrt/logs/error-hrt.log

	# Possible values include: debug, info, notice, warn, error, crit,
	# alert, emerg.
	LogLevel info

	CustomLog /opt/apps/hrt/logs/access-ypg2.log combined
</VirtualHost>