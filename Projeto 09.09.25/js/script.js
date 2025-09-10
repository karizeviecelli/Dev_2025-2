alert("Bem-vindo!");


// função de cadastro
function cadastroUsuario() {
    // pega o valor do input
    var nome = document.getElementById("nomeUsuario").value;

    // coloca o nome dentro do <p id="nome">
    document.getElementById("nome").innerHTML = "Usuário digitado: " + nome;
}

function somar() {
    let a = Number(document.getElementById("num1").value);
    let b = Number(document.getElementById("num2").value);

    let resultado = a + b;
    document.getElementById("resultado").innerHTML = "Resultado: " + resultado;
    console.log(resultado);
}

function subtrair() {

    let a = Number(document.getElementById("num1").value);
    let b = Number(document.getElementById("num2").value);

    let resultado = a - b;
    document.getElementById("resultado").innerHTML = "Resultado: " + resultado;
    console.log(resultado);


}
function multiplicar() {

    let a = Number(document.getElementById("num1").value);
    let b = Number(document.getElementById("num2").value);

    let resultado = a * b;
    document.getElementById("resultado").innerHTML = "Resultado: " + resultado;
    console.log(resultado);


}
function dividir() {

    let a = Number(document.getElementById("num1").value);
    let b = Number(document.getElementById("num2").value);
    
    
    if(b != 0){
        let resultado = Number (a/b);
        document.getElementById("resultado").innerHTML = "Resultado: " + resultado;
        console.log(resultado);

    }
    else{
        document.getElementById("resultado").innerHTML = "Não é possivel dividir por 0";
        console.log("não possivel dividir por 0")
    }
    
    

}
