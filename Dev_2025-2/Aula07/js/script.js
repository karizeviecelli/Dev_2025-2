function saudacao() {
    console.log("Olá, seja bem vindo(a)!");
    alert("Olá, seja bem vindo(a)!");
    
    
}
saudacao();

function mudarMensagem(){
document.getElementById("mensagem").innerHTML = "Você clicou no botão!";
}

function soma(a, b){
    return a + b;
}
console.log(soma(5, 3));

const somarArrow = (x, y) => x + y;
console.log("Soma Arrow "+somarArrow(10, 20));

