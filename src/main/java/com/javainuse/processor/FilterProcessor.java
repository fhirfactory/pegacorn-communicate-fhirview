package net.fhirfactory.pegacorn.fhirview.processor;

import net.fhirfactory.pegacorn.fhirview.model.Root;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FilterProcessor implements Processor {
	private static final Logger LOGGER = LoggerFactory.getLogger(FilterProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		LOGGER.info("I'm here");
		var body = exchange.getIn().getBody();

		if (body instanceof Root) {
			Root root = (Root) body;

			LOGGER.info("my body: {}", root);

			exchange.getMessage().setBody(body);
		}
	}
}

/*
 * [10:08 pm, 07/03/2021] Ani1: import org.apache.camel.Exchange; import
 * org.apache.camel.builder.RouteBuilder; import
 * org.apache.camel.component.jackson.JacksonDataFormat; [10:10 pm, 07/03/2021]
 * Ani1:
 * .to("https://samfhirsdf.azurehealthcareapis.com/Practitioner").process(new
 * FilterProcessor());
 * .to("https://samfhirsdf.azurehealthcareapis.com/Practitioner").process(new
 * FilterProcessor());
 * 
 */