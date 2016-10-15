package ru.inkontext.sseEmitter;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;

/**
 * Created by stolbovd on 14.10.16.
 */
@RestController
public class SseEmitterRestController {
	private SseEmitter emitter;

	@RequestMapping(value = "/sse", method = RequestMethod.POST)
	public void getMessage(@RequestBody String message) throws IOException, HTTPException {

		if (message == null || message.equals(""))
			throw new RuntimeException("сообщение пустое");

		// Send message to "connected" web page:
		if (emitter != null)
			emitter.send(message);
		else
			throw new RuntimeException("канал закрыт");
	}

	@RequestMapping(value = "/sse", method = RequestMethod.GET)
	public SseEmitter getSseEmitter() {
		emitter = new SseEmitter();
		return emitter;
	}
}
