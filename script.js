const formulario = document.querySelector("form"); 
const Inome = document.querySelector(".nome");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");
const Icel = document.querySelector(".cel");

function cadastrar() {
    
    fetch("http://localhos:8080/cadastrar",
        {
            headers: {
                'Accept': 'aplication/json',
                'Content-Type': 'aplication/json'
            },
            method: "POST",
            body: JSON.stringify({ a: 1, b: 2 })
        })
        .then(function (res) {console.log(res) })
        .catch(function (res) {console.log(res) })
    
}

formulario.addEventListener("submit", function (event) {
    event.preventDefault();

    const dados = {
        nome: Inome.value,
        email: Iemail.value,
        senha: Isenha.value,
        celular: Icel.value
    };

    console.log(dados);

});