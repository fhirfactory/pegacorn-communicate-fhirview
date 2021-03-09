package net.fhirfactory.pegacorn.fhirview.route;

import net.fhirfactory.pegacorn.fhirview.model.Root;
import net.fhirfactory.pegacorn.fhirview.processor.FilterProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class PassThroughRouter extends RouteBuilder {
	private final String endPoint = "http://jsonplaceholder.typicode.com/todos/1";

	JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(Root.class);

	@Override
	public void configure() throws Exception {
		from("direct:myService").streamCaching() //
				.setHeader(Exchange.HTTP_METHOD, simple("GET"))
				.setHeader("authority", simple("samfhirsdf.azurehealthcareapis.com")).setHeader("accept", simple("/"))
				.setHeader("authorization", simple(
						"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Im5PbzNaRHJPRFhFSzFqS1doWHNsSFJfS1hFZyIsImtpZCI6Im5PbzNaRHJPRFhFSzFqS1doWHNsSFJfS1hFZyJ9.eyJhdWQiOiJodHRwczovL3NhbWZoaXJzZGYuYXp1cmVoZWFsdGhjYXJlYXBpcy5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC80Y2E1MjI5My02NjlmLTRmYTgtODA3OC1mOGViOGI4MWE0OGQvIiwiaWF0IjoxNjE1MTY4MzkxLCJuYmYiOjE2MTUxNjgzOTEsImV4cCI6MTYxNTE3MjI5MSwiYWNyIjoiMSIsImFpbyI6IkFWUUFxLzhUQUFBQWZWdGRjNCtKeldiKytTRWoyblVRRkZtWkJJQU1saHRZUHdsdjk4dWtSUkhYbmVodEszYTduOVRRTmhndDVYUHNWbFpteDJBVU9YRkhTR1ZPMWlSaE9CYSt4QWdzek02c2VXbEpISkx4TTBFPSIsImFtciI6WyJwd2QiXSwiYXBwaWQiOiJmYjYxMWQ5ZS1mZTk5LTQ1YzEtYmY5Ny1mZWExNmQ1NDU0MjMiLCJhcHBpZGFjciI6IjEiLCJlbWFpbCI6InNhbXJpZGhpczE5ODBAaG90bWFpbC5jb20iLCJmYW1pbHlfbmFtZSI6IlNodSIsImdpdmVuX25hbWUiOiJTYW0iLCJpZHAiOiJsaXZlLmNvbSIsImlwYWRkciI6IjU4LjEwNS4xOTcuODEiLCJuYW1lIjoiU2FtIFNodSIsIm9pZCI6ImIwZmRmZjk3LTJmYjctNGQzNS1iYjhjLTE2MTljNDIzODExMyIsInJoIjoiMC5BV1lBa3lLbFRKOW1xRS1BZVBqcmk0R2tqWjRkWWZ1Wl9zRkZ2NWYtb1cxVVZDTm1BUGcuIiwic2NwIjoidXNlcl9pbXBlcnNvbmF0aW9uIiwic3ViIjoiRm1yWC1pcEg2OEU1Qnd3NURFU1ZHNk9NUW5odUt6X3NNMXZyZU5yMVpqdyIsInRpZCI6IjRjYTUyMjkzLTY2OWYtNGZhOC04MDc4LWY4ZWI4YjgxYTQ4ZCIsInVuaXF1ZV9uYW1lIjoibGl2ZS5jb20jc2FtcmlkaGlzMTk4MEBob3RtYWlsLmNvbSIsInV0aSI6Ik5QdHpjdHlYZFVlVS1pcEtvYXFOQUEiLCJ2ZXIiOiIxLjAifQ.PTIp4oQH4YXkrM8Li3o18ass5aqkuCLTOHoQ18SsaKBjBHYdQ_tz7Ij2gaLqVAXO3Its_9uOFPmFcTxuoVbU-QWV2DbWyI5__YcZ5CamWfZMPIWgx-2cXMsi1ThYQCW2dGB5OZjsnd2h2pcNxFXPZI7iLesaYAWN6xugcDvwoxxl5b7DbOMmnuDJgoLWGZOPRgMu4jwamzWPZmBkn2UCKHBm3_rRPe-FLio8vZT3P81a4wv-R4C3V8gdpvmClDbaLXrw4PFZ-kvULCLX5NPfl7mp0jWeUrZDw2ciWzTQWVKGtExx-ZmX740n7DH4eI6jkmaIVkLGzNC5EGuXDsGJoA\n"))
				.setHeader("user-agent", simple(
						"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Safari/537.36"))
				.setHeader("origin", simple("https://samfhirsdfdash.azurewebsites.net"))
				.setHeader("sec-fetch-site", simple("cross-site")).setHeader("sec-fetch-mode", simple("cors"))
				.setHeader("sec-fetch-dest", simple("empty"))
				.setHeader("referer", simple("https://samfhirsdfdash.azurewebsites.net/"))
				.setHeader("accept-language", simple("en-GB,en-US;q=0.9,en;q=0.8"))
				.toF("https://samfhirsdf.azurehealthcareapis.com/Practitioner" + "?bridgeEndpoint=true")
				.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
				.setHeader(Exchange.HTTP_METHOD, simple("GET")).unmarshal(jacksonDataFormat).process(new MyProcessor())
				.log("Response  ${body}").convertBodyTo(Root.class).end();

		rest().get("/api").route().to("direct:myService").end().marshal(jacksonDataFormat).endRest();
	}

}
