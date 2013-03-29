package com.convenetech.notification.event.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.convenetech.notification.event.api.common.Metric;
import com.convenetech.notification.event.api.common.Metrics;

public class MetricsDeSerializer extends JsonDeserializer<Metrics> {

	@Override
	public Metrics deserialize(JsonParser jsonParser,
			DeserializationContext deserializationContext) throws IOException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);
		Iterator<Entry<String, JsonNode>> fields = node.getFields();
		List<Metric> metrics = new ArrayList<Metric>();
		while (fields.hasNext()) {
			Entry<String, JsonNode> entryNode = fields.next();
			JsonNode jsonNode = entryNode.getValue();
			metrics.add(new Metric(entryNode.getKey(), jsonNode.get("type")
					.getTextValue(), jsonNode.get("data").toString()));
		}
		return new Metrics(metrics);
	}
}
