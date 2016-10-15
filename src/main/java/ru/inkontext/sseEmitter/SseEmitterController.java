package ru.inkontext.sseEmitter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;

/**
 * Created by stolbovd on 14.10.16.
 */
@Controller
public class SseEmitterController {
	@RequestMapping
	public String getPage() throws IOException, HTTPException {
		return "sse";
	}
}
