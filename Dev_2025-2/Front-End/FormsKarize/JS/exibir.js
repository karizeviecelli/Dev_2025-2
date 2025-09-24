//Recupera os dados do LocalStorage
let lista = JSON.parse(localStorage.getItem('cadastroUsuario'));

const ul = document.getElementById('listarCadastro');

//Lista os dados
lista.forEach((item) => {
    const li = document.createElement('li');
   li.textContent = `${item.name} - ${item.email}`;
    ul.appendChild(li);
});

