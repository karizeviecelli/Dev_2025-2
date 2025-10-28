document.querySelectorAll('.excluir').forEach(function(button) {
    button.addEventListener('click', function() {
        if (confirm('Confirma a exclusão?')) {
            const row = this.closest('tr');
            const contatoId = this.dataset.contatoId;

            fetch(`/contato/${contatoId}`, {
                method: 'DELETE',
                headers: { 'Content-Type': 'application/json' },
            })
                .then(response => {
                    if (response.ok) {
                        row.remove();
                    } else {
                        alert('Erro ao excluir contato');
                    }
                })
                .catch(error => {
                    alert('Erro de rede:' + error);
                });
        }
    });
});
