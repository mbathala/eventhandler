package com.wf.eh.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.wf.eh.EventhandlerApplication;
import com.wf.avro.model.TennisScore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TennisScoreProducer {

	private static Logger logger = LoggerFactory.getLogger(TennisScoreProducer.class);

	private final KafkaTemplate<String, TennisScore> kafkaTemplate;

	public TennisScoreProducer(KafkaTemplate<String, TennisScore> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void produce(TennisScore tennisScore) {
		logger.info("Produce tennis game score: {}, {}", tennisScore.getPlayerName(), tennisScore.getScore());
		kafkaTemplate.send(EventhandlerApplication.TOPIC_NAME, tennisScore.getPlayerName(), tennisScore);
	}

}
