const formulario = document.querySelector("form"); 
const Inome = document.querySelector(".nome");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");
const Icel = document.querySelector(".cel");

function cadastrar() {
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
        if (res.ok) {
            return res.json(); 
        }
        throw new Error('Resposta da rede não estava ok.');
    })
    .then(function (data) {
        console.log(data);
    })
    .catch(function (error) {
        console.error('Houve um problema com a operação de fetch:', error);
    });
}

function limpar() {
    Inome.value = "";
    Iemail.value = "";
    Isenha.value = "";
    Icel.value = "";
}

formulario.addEventListener("submit", function (event) {
    event.preventDefault();

    cadastrar();
    limpar();
});
