# Apache CXF Básico

Echar a andar el proyecto con: 

```
./gradlew run
```

Luego, se puede probar con Curl:

```
curl -X POST \
     -H "Content-Type: text/xml; charset=utf-8" \
     -H "SOAPAction: \"\"" \
     --data @request.xml \
     http://localhost:9000/holaMundo
```
