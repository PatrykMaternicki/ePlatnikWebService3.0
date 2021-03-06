# ePlatnikWebService

ePlatnikWebService jest webserwisem do obsługi zasobów ludzkich. Pozwala na dodanie nowych pracowników. Udostępnia UI dla menagera, general menager oraz dla osoby administrującej system.

#### Zastosowane technologie i narzędzia

##### Backend:
- JAVA EE 1.8, maven, hibernate, jasper, mockito, junit.

##### Frontend:
- ECMAScript 6, React.js, SCSS.

##### DB:
- hsqlDb, mysql

#### Komendy:

Ogólna dokumentacja projektowa:
```
mvn site
```
Szczegółowa dokumentacja projektowa:
```
mvn javadoc: javadoc
```

Testy systemu:
```
mvn test
```

Uruchomienie systemu:
```
mvn tomcat7:run
```

Instalowanie pakietów:
```
mvn install
```

Kompilowanie plików SASS
```
npm run sass-compile
```

Odpalanie testowej bazy danych:
```
runServer.bat --database.0 mem:mydb --dbname.0 workdb
```
