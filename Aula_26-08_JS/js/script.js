
/*
function alterarCont() {

    document.getElementById("exemplo").innerHTML = "Alterou conteúdo";

}

var nome = "João";
var idade = 20;
var curso = "Desenvolvimento de Sistemas";


document.writeln(nome + " tem " + idade + " anos de idade. É aluno do curso: " + curso)


var para = document.querySelector('p');

para.addEventListener('click', atualizarNome);

function atualizarNome() {
    var nome = prompt('Insira um novo nome')
    para.textContent = 'Aluno: ' + nome;
}

let num1 = parseInt(prompt("Informe um valor: "))
let num2 = parseInt(prompt("Informe outro valor: "))
alert(num1 + num2);
console.log(num1 + num2);
*/

let idade = parseInt(prompt("Qual a sua idade?"))

if(idade >= 18){
    alert("Você é maior de idade.")
} else{
    alert("Você é menor de idade.")
}

