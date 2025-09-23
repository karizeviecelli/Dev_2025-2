
const cadastros = JSON.parse(localStorage.getItem('cadastroUsuario')) || [];

const resultado = document.getElementById('resultado');

if (cadastros.length > 0) {
    resultado.innerHTML = cadastros.map(dados => `
        <tr>
            <td>${dados.nome}</td>
            <td>${dados.email}</td>
            <td>${dados.senha}</td>
        </tr>
    `).join('');
} else {
    resultado.innerHTML = `
        <tr>
            <td colspan="3">Nenhum dado encontrado!</td>
        </tr>
    `;
}