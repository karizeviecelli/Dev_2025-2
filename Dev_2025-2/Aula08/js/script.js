const form = document.getElementById('formulario');

form.addEventListener('submit', function(event) {
    event.preventDefault();

    // Recupera o array de cadastros ou cria um novo
    let cadastros = JSON.parse(localStorage.getItem('cadastroUsuario')) || [];

    // Se não for array, transforma em array
    if (!Array.isArray(cadastros)) {
        cadastros = [];
    }

    // Cria o novo cadastro
    const dados = {
        nome: document.getElementById('nome').value,
        email: document.getElementById('email').value,
        senha: document.getElementById('senha').value
    };

    // Adiciona o novo cadastro ao array
    cadastros.push(dados);

    // Salva o array atualizado no localStorage
    localStorage.setItem('cadastroUsuario', JSON.stringify(cadastros));

    // Redireciona para a página de exibição
    window.location.href = "comfirmacao.html";
});