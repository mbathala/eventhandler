package com.wf.eh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wf.avro.model.TennisScore;
import com.wf.eh.producer.TennisScoreProducer;

@RestController
@RequestMapping("/send/tennis")
public class TennisScoreController {
	
	@Autowired
	TennisScoreProducer tennisScoreProducer;
	
	@RequestMapping(method = RequestMethod.GET, value = "/score")
	public String sendTennisScore() {
		TennisScore tscore = TennisScore.newBuilder()
		.setPlayerName("Sania")
		.setScore(123)
		.build();
		tennisScoreProducer.produce(tscore);
		return "Sending Tennis Score latest......";
	}

}
