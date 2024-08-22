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
            body: JSON.stringify({
                nome: Inome.value,
                email: Iemail.value,
                senha: Isenha.value,
                celular: Icel.value
            })
        })
        .then(function (res) {console.log(res) })
        .catch(function (res) {console.log(res) })
    
}

function limpar() {
    Inome.value = "";
    Iemail.value = "";
    Isenha.value = "";
    Icel.value = "";
};

formulario.addEventListener("submit", function (event) {
    event.preventDefault();

    cadastrar();
    limpar();

});