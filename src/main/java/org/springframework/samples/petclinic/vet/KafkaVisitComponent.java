package org.springframework.samples.petclinic.vet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.samples.petclinic.owner.VisitDto;
import org.springframework.stereotype.Component;

@Component
public class KafkaVisitComponent {
	public static final Logger logger = LoggerFactory.getLogger(KafkaVisitComponent.class);

	@KafkaListener(topics = "visit", containerFactory = "visitDtoListenerFactory")
	public void consumeVisitDto(VisitDto visitDto) {
		logger.info(visitDto.toString());
	}
}
