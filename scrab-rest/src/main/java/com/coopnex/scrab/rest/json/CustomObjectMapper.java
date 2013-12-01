package com.coopnex.scrab.rest.json;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomObjectMapper extends ObjectMapper {
	private static Logger log = LoggerFactory
			.getLogger(CustomObjectMapper.class);

	public CustomObjectMapper() {
		super();
		getSerializationConfig().disable(Feature.WRITE_DATES_AS_TIMESTAMPS);
		getSerializationConfig().setDateFormat(
				new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
		getDeserializationConfig()
				.disable(
						org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		getDeserializationConfig().setDateFormat(
				new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
	}

}
