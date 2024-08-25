// Seleciona os elementos
const formulario = document.querySelector("form"); 
const Inome = document.querySelector(".nome");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");
const Icel = document.querySelector(".cel");
const mostrarSenhaBtn = document.querySelector(".mostrar-senha-btn");

function cadastrar() {
    // Verifica se todos os campos estão preenchidos
    if (Inome.value === "" || Iemail.value === "" || Isenha.value === "" || Icel.value === "") {
        alert("Por favor, preencha todos os campos.");
        return;
    }
    
    // Envia uma requisição para o endpoint com dados do formulario
    fetch("http://localhost:8080/usuarios", {
        headers: {
            'Accept': 'application/json', 
            'Content-Type': 'application/json' 
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inome.value,
            email: Iemail.value,
            senha: Isenha.value,
            celular: Icel.value 
        })
    })
    .then(function (res) {
        // Verificação de rede
        if (res.ok) {
            return res.json(); 
        }
        throw new Error('Resposta da rede não estava ok.');
    })
    .then(function (data) {
        console.log(data);
    })
    .catch(function (error) {
        // Trata erros que podem ocorrer no fetch
        console.error('Houve um problema com a operação de fetch:', error);
    });
}

// Limpar campos do formulario
function limpar() {
    Inome.value = "";
    Iemail.value = "";
    Isenha.value = "";
    Icel.value = "";
}

// Visualizar senha
function toggleSenha() {
    if (Isenha.type === "password") {
        Isenha.type = "text";
        mostrarSenhaBtn.textContent = "❎";
    } else {
        Isenha.type = "password";
        mostrarSenhaBtn.textContent = "✅";
    }
}

// Eventos do formulario
formulario.addEventListener("submit", function (event) {
    event.preventDefault();

    cadastrar();
    limpar();
});

mostrarSenhaBtn.addEventListener("click", toggleSenha);