// Captura o formulário pelo ID
const form = document.getElementById('formulario');


// Adiciona o evento de submit
form.addEventListener('submit', function (event) {
    event.preventDefault();


    // Cria o objeto com os dados
    const dados = {
        nome: document.getElementById('name').value,
        email: document.getElementById('email').value,
        senha: document.getElementById('senha').value
    };


    
    // Busca lista existente ou cria uma nova
    let lista2 = JSON.parse(localStorage.getItem('cadastroUsuario')) || [];
   


    // Adiciona o novo cadastro
    lista2.push(dados)


    // Salva no localStorage
    localStorage.setItem('cadastroUsuario', JSON.stringify(lista2));


    alert("Cadastro realizado com sucesso!");


    // Redireciona para a página de exibição
    window.location.href = "confirma.html";
});
    
