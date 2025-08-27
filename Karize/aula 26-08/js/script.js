function alterarCont(){
    document.getElementById("exemplo").innerHTML = "ESPANCA OTAKU INTERPLANETÁRIO - SLOWED";
}

function alterarCont2(){
    document.getElementById("exemplo2").innerHTML = "ESPANCA OTAKU INTERPLANETÁRIO";
}

//variaveis
/*
var nome = "Matheus";
var idade = 18+1;
var curso = "Análise e Desenvolvimento de sistemas";

//agora vamos imprimir//
document.writeln();
document.writeln("O aluno(a) " + nome + ", tem a idade de " + idade + ". Está cursando: " + curso);
*/

var para = document.querySelector('p');

para.addEventListener('click', atualizarNome);

function atualizarNome() {
    let nome = prompt('Insira um nvo nome:');
    para.textContent = 'Aluno: ' + nome;
}



//Operacões aritméticos 
//ATT 2
let num1 = Number(prompt("Informe um número: "));
let num2 = Number(prompt("Informe o segundo número: "));
let resultado = num1+num2;
console.log('Resultado da soma: ' + resultado);

if(num1>num2){
    console.log(num1 + " é maior que " + num2)
} if(num2>num1){
    console.log(num2 + " é maior que " + num1)
} if(num1==num2) {
    console.log(num1 + " e " + " são iguais")
    }
/*
let sqrt = Math.sqrt(resultado);
console.log("Raiz de "+resultado+":\n"+sqrt);
//ATT1
//Exemplo de condicional com if

let idade = prompt("Informe a sua idade: ");
if(idade >= 18) {
    console.log("Você é maior de idade! Já pode votar.");
} else {
    console.log("Você é menor de idade, não pode votar.")
}
*/

let nota1 = parseFloat(prompt('Informe a primeira nota: '))
let nota2 = parseFloat(prompt('Informe a segunda nota: '))
let media = (nota1+nota2) / 2

if(media>= 6) {
    console.log('Você foi aprovada, com a média: ' + media)
} else {
    console.log('Você não foi aprovada, pois sua média foi: ' + media)
}

function nome_funcao(){
    alert('login ou senha incorreto')
}

function somar(a, b){
    var total = a + b
    alert('O valor da soma é: ' + total)
}

function desconto(a, b){
    var totalDesc = a-b;
    document.writeln('Valor final com desconto: '+ totalDesc)
    return totalDesc
}

let resultadoTotalDesc = desconto(7,5)

document.writeln('Valor final com desconto fora: ' + resultadoTotalDesc)