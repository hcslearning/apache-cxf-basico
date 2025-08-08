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
     --data @soap-request.xml \
     http://localhost:9000/holaMundo
```

Y la respuesta esperada debería ser algo así:

```
<soap:Envelope
	xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
	<soap:Body>
		<ns2:decirHolaResponse
			xmlns:ns2="http://cxf.hcslearning.cl/">
			<saludo>Hola Juan</saludo>
		</ns2:decirHolaResponse>
	</soap:Body>
</soap:Envelope>
```
