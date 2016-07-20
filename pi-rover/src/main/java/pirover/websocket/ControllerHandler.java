package pirover.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import pirover.model.Cartesian;
import pirover.service.RoverService;
import pirover.websocket.message.JoystickMessage;
import pirover.websocket.message.JoystickMessageMarshaller;

public class ControllerHandler extends TextWebSocketHandler {

	@Autowired
	private RoverService roverService;

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("Websocket disconnected.");
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("Websocket connected.");
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
		JoystickMessage message = JoystickMessageMarshaller.fromJSON(textMessage.getPayload());

		// System.out.println(textMessage.getPayload());
		// System.out.println(message);

		Cartesian cartesian = message.toVector().toCartesian();

		if ("left".equals(message.getJoystick())) {
			roverService.setVelocityLeft(cartesian.y);
		} else if ("right".equals(message.getJoystick())) {
			roverService.setVelocityRight(cartesian.y);
		}
	}
}
