# Apache CXF Básico con WS SOAP

Echar a andar el proyecto con: 

```bash
./gradlew run
```

Luego, se puede probar con Curl:

```bash
curl -X POST \
     -H "Content-Type: text/xml; charset=utf-8" \
     -H "SOAPAction: \"\"" \
     --data @soap-request.xml \
     http://localhost:9000/holaMundo
```

Y la respuesta esperada debería ser algo así:

```xml
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

## Dependencias

```gradle
// Requerido para SOAP WS
implementation(libs.apache.cxf.core)
implementation(libs.apache.cxf.jaxws)
implementation(libs.apache.cxf.http)

// Opcional, para ejecutar con Jetty incrustado
implementation(libs.apache.cxf.jetty)

// para logging usando SL4J y Logback
implementation(libs.apache.cxf.logging)
implementation(libs.logback.core)
implementation(libs.logback.classic)
```

## WSDL Generado por el código

```xml
<?xml version='1.0' encoding='UTF-8'?>
<wsdl:definitions
	xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
	xmlns:tns="http://cxf.hcslearning.cl/"
	xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	xmlns:ns1="http://schemas.xmlsoap.org/soap/http" name="HolaMundo" targetNamespace="http://cxf.hcslearning.cl/">
	<wsdl:types>
		<xs:schema
			xmlns:xs="http://www.w3.org/2001/XMLSchema"
			xmlns:tns="http://cxf.hcslearning.cl/" elementFormDefault="unqualified" targetNamespace="http://cxf.hcslearning.cl/" version="1.0">
			<xs:element name="decirHola" type="tns:decirHola"/>
			<xs:element name="decirHolaResponse" type="tns:decirHolaResponse"/>
			<xs:complexType name="decirHola">
				<xs:sequence>
					<xs:element minOccurs="0" name="nombre" type="xs:string"/>
				</xs:sequence>
			</xs:complexType>
			<xs:complexType name="decirHolaResponse">
				<xs:sequence>
					<xs:element minOccurs="0" name="saludo" type="xs:string"/>
				</xs:sequence>
			</xs:complexType>
		</xs:schema>
	</wsdl:types>
	<wsdl:message name="decirHolaResponse">
		<wsdl:part element="tns:decirHolaResponse" name="parameters"></wsdl:part>
	</wsdl:message>
	<wsdl:message name="decirHola">
		<wsdl:part element="tns:decirHola" name="parameters"></wsdl:part>
	</wsdl:message>
	<wsdl:portType name="HolaMundo">
		<wsdl:operation name="decirHola">
			<wsdl:input message="tns:decirHola" name="decirHola"></wsdl:input>
			<wsdl:output message="tns:decirHolaResponse" name="decirHolaResponse"></wsdl:output>
		</wsdl:operation>
	</wsdl:portType>
	<wsdl:binding name="HolaMundoSoapBinding" type="tns:HolaMundo">
		<soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
		<wsdl:operation name="decirHola">
			<soap:operation soapAction="" style="document"/>
			<wsdl:input name="decirHola">
				<soap:body use="literal"/>
			</wsdl:input>
			<wsdl:output name="decirHolaResponse">
				<soap:body use="literal"/>
			</wsdl:output>
		</wsdl:operation>
	</wsdl:binding>
	<wsdl:service name="HolaMundo">
		<wsdl:port binding="tns:HolaMundoSoapBinding" name="HolaMundoImpPort">
			<soap:address location="http://localhost:9000/holaMundo"/>
		</wsdl:port>
	</wsdl:service>
</wsdl:definitions>
```
