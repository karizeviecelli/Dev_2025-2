function cadastroUsuario(){
   let nome = document.getElementById("nomeUsuario").value

   document.getElementById("nome").innerHTML =  nome
}

function somar(a,b){
    return a+b;
    
}

let resultado = (somar(12,3))

function resultadoTela(){
document.getElementById("calcula").innerHTML = resultado
}

function calcular(){
    let resultado;
    let numero1 = parseFloat(document.getElementById("num1").value)
    let numero2 = parseFloat(document.getElementById("num2").value)
    let operacao = document.getElementById("operacao").value

    if(operacao == "+"){
        resultado = numero1+numero2
    }else if(operacao == "-"){
        resultado = numero1-numero2
    }else if(operacao == "/"){
        resultado = numero1/numero2
    }else if(operacao == "*"){
        resultado = numero1*numero2
    }
    document.getElementById("resultado").innerHTML = resultado;
}





