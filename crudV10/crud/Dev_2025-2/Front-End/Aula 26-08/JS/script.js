alert("Olá mundo, novamente!")

function alterarCont() {
    document.getElementById("exemplo").innerHTML = "Alterou conteúdo";
}
//Variaveis//
var nome = "Bruno";
var idade = "19";
var curso = "desenvolvimento de sistemas";
//*iMPRIMINDO MENSAGEM *//
document.writeln("O aluno " + nome + " ,tem a idade de " + idade + " . Está cursando " + curso);


var para = document.querySelector('p');
para.addEventListener('click', atualizarNome);

function atualizarNome() {
    var nome = prompt('Insira seu nome:');
    para.textContent = 'Aluno:' + nome;
}

/*Operadores aritméticos */
//let num = Number(prompt("Informe um número: "))
//let num2 = Number(prompt("informe outro número: "))
let num = Number(80);
let num2 = Number(80);

alert(num + num2);
console.log(num + num2);

var num3 = Math.pow(5, 2);
alert(num3)


//*var idade = prompt("Quantos anos você tem?");

//if(idade >= 18){
// alert("Você já pode ser CLT")
//}else{
// alert("Você ainda não pode ser possuido pelo capitalismo.")
//}

var num4 = Number(prompt("Insira um número:"));
var num5 = Number(prompt("insira um segundo número:"));

if (num4 > num5) {
   alert(+num4 + " É o maior número")

    if (num5 > num4) {
        prompt(num5 + " É maior")
    } else {
        alert("Os dois são iguais")
    }
}
alert("Fim do processo");