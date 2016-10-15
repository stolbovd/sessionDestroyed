function AppModel() {
	var app = this;
	app.message = ko.observable("");
	app.send = function () {
		if (app.message().length > 0) {
			$.ajax("/sse", {type: "POST", data: app.message(), contentType: "text/plain; charset=UTF-8"}).fail(function (error) {
				console.log(error);
			});
			app.message("");
		}
	};
	app.content = ko.observable("");
	app.source = new EventSource("/sse");
	app.source.onmessage = function(event) {
		app.content(app.content() + " " + event.data);
	};
}


