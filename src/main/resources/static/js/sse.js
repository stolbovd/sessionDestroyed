function AppModel() {
	app.message = ko.observable("");
	app.send = function () {
		if (app.message().length > 0) {
			$.post("/sse", app.message());
			app.message("");
		}
	};
	app.content = ko.observable("");
	app.source = new EventSource("/sse");
	app.source.onmessage = function(event) {
		app.content(app.content() + " " + event.data);
	};
}


