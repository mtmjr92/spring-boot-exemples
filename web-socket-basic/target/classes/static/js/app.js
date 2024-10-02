let stompClient;

function connect() {
    const socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Conectado: ' + frame);
        stompClient.subscribe('/topic/messages', function (message) {
            showMessage(JSON.parse(message.body));
        });
    });
}

function sendMessage() {
    const username = document.getElementById('username').value;
    const content = document.getElementById('message').value;
    if (username && content) {
        stompClient.send("/app/send-message", {}, JSON.stringify({ username: username, content: content }));
        document.getElementById('message').value = '';
    } else {
        alert("Preencha todos os campos");
    }
}

function showMessage(message) {
    const messages = document.getElementById('messages');
    const li = document.createElement('li');
    li.appendChild(document.createTextNode(`${message.username}: ${message.content}`));
    messages.appendChild(li);

    const chatMessages = document.getElementById('chat-messages');
    const numberOfMessages = messages.children.length;

    // Adiciona a classe 'scrollable' quando há mais de 10 mensagens
    if (numberOfMessages > 5) {
        chatMessages.classList.add('scrollable');
        chatMessages.scrollTop = chatMessages.scrollHeight;  // Faz o scroll automático para a última mensagem
    }
}

connect();
