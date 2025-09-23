/*
alert("Olá Mundo!!!");
*/
function alterarCont(){
    document.getElementById("exemplo").innerHTML = "Conteúdo alterado via JavaScript";
}

var nome = "Maria";
var idade = "18";
var curso = "Desenvolvimento Web";

document.write("A aluna " + nome + " tem " + idade + " anos e está matriculado no curso de " + curso + ".");

var para = document.querySelector("p");
para.addEventListener("click", atualizarNome);

function atualizarNome(){
    var nome = prompt("Digite seu nome:");
    para.textContent = "Olá " + nome + ", seja bem vindo(a)!";
}