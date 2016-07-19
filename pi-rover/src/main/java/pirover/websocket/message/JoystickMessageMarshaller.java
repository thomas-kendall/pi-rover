package pirover.websocket.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JoystickMessageMarshaller {

	public static JoystickMessage fromJSON(String json) {
		ObjectMapper mapper = new ObjectMapper();
		JoystickMessage message;
		try {
			message = mapper.readValue(json, JoystickMessage.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return message;
	}

	public static String toJSON(JoystickMessage message) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(message);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException("Exception converting message to JSON.");
		}
		return json;
	}

}
