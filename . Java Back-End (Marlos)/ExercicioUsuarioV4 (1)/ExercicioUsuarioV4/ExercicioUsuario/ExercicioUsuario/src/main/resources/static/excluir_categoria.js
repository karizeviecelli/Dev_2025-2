// Adicione um ouvinte de eventos aos botões de exclusão
document.querySelectorAll('.excluir').forEach(function(button) {
    button.addEventListener('click',
        function() {
            if (confirm('Confirma a exclusão?')) {

                const row = this.closest('tr'); // Obtém a linha atual da tabela

                const categoriaId = this.dataset.categoriaId;

                // Realize a chamada AJAX para excluir o recurso
                fetch(`/categoria/${categoriaId}`, {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                })
                    .then(response => {
                        if (response.ok) {
                            // A exclusão foi bem-sucedida
                            console.log('Categoria excluída com sucesso.');

                            // Remove a linha da tabela após a exclusão
                            row.remove();
                        } else {
                            // A solicitação DELETE falhou
                            console.error('Erro ao excluir categoria.');
                            alert('Erro ao excluir categoria');
                        }
                    })
                    .catch(error => {
                        // Lidar com erros de rede ou outros erros
                        console.error('Erro de rede:', error);
                        alert('Erro de rede:' + error);
                    });
            }
        });
});
