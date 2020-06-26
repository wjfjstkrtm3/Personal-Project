var stompClient = null;

function setConnected(connected) {
  $("#connect").prop("disabled", connected);
  $("#disconnect").prop("disabled", !connected);
  if (connected) {
    $("#conversation").show();
  }
  else {
    $("#conversation").hide();
  }
  $("#greetings").html("");
}

function connect() {
  var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  // SockJS와 stomp client를 통해 연결을 시도.
  stompClient.connect({}, function(frame) {
    setConnected(true);
    console.log('Connected: ' + frame);
    
   stompClient.subscribe('/topic/greetings', function (greeting) {
    	console.log("greeting : " + greeting);
    	console.log("greeting.body : " + greeting.body)
      showGreeting(JSON.parse(greeting.body).content);
    });
    
    stompClient.subscribe("/topic/chat", function(data) {
    	showChat(JSON.parse(data.body));
    });
  });
}

function disconnect() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  setConnected(false);
  console.log("Disconnected");
}

function showChat(chat) {
	$("#greetings").append("<tr><td>" + chat.name + " : " + chat.message +"</td></tr>");
}


function sendChat() {
	stompClient.send("/app/chat", {}, JSON.stringify({"name":$("#name").val(), "message":$("#chatMessage").val()}));
}

function sendName() {
  // /app/hello로 JSON 파라미터를 메세지 body로 전송.
  stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
  $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
  $("form").on('submit', function (e) {
    e.preventDefault();
  });
  $( "#connect" ).click(function() { connect(); });
  $( "#disconnect" ).click(function() { disconnect(); });
  $( "#send" ).click(function() { sendName(); });
  $( "#chatSend" ).click(function(){ sendChat();}); // 추가
  
  
  
  
  
  
  
});