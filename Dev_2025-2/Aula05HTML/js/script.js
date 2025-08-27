var num = 0;
function alterarCont() {
    if (num >= 50) {
        num = 0
    }
    num++
    document.getElementById("exemplo").innerHTML = num;
}

var nome = "Maria";
var curso = "Desenvolvimento de Sistemas";
var idade = "18 ";

document.writeln("O aluno(a) " + nome + ",tem a idade de: " + idade + " anos. Está Cursando: " + curso);


var para = document.querySelector('p');
  para.addEventListener('click', atualizarNome);

function atualizarNome() {
    var nome = prompt('insira um nome');
    para.textContent = 'aluno: ' + nome

}

let num1 = parseInt(prompt("Informe um número: "))
let num2 = parseInt( prompt("Informe outro número: "))

//let calc = prompt("Informe o calculo que deseja realizar (+,-,/,*)")

// if(calc == "+"){
// console.log(num1+num2)
// }else if(calc == "-"){
//     console.log(num1-num2)
// }else if(calc == "/"){
//     console.log(num1/num2)
// }else if (calc == "*"){
//       console.log(num1*num2)
// } else{
//     console.log("Calculo não encontrado")
// }
if(num1==num2){
    console.log("Os dois números são iguais")
}
else if(num1>num2){
    console.log("Maior: "+num1)
}else{
    console.log("maior: "+num2)
}

let votar = parseInt(prompt("Informe sua idade"))

if(votar < 16){
    console.log("Você não pode votar ainda")
}else{
    console.log("Você já pode votar")
}

let nota1 = parseInt(prompt("Informe uma nota: "))
let nota2 = parseInt( prompt("Informe outra nota: "))

let media = parseInt((nota1+nota2)/2)

if(media>=6){
    console.log("Aprovado")
}else{
    console.log("Reprovado")
}


