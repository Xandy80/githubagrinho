<script>
    document.addEventListener('DOMContentLoaded', function() {
        const form = document.querySelector('form');
        
        form.addEventListener('submit', function(event) {
            const nome = document.getElementById('nome').value.trim();
            const email = document.getElementById('email').value.trim();
            const mensagem = document.getElementById('mensagem').value.trim();
            let valid = true;

            // Limpar mensagens de erro anteriores
            document.querySelectorAll('.error').forEach(e => e.remove());

            // Validacao do nome
            if (nome === '') {
                showError('nome', 'nome por.');
                valid = false;
            }

            // Validacao do email
            if (email === '' || !validateEmail(email)) {
                showError('email', 'Por favor, insira um e-mail valido.');
                valid = false;
            }

            // Validacao da mensagem
            if (mensagem === '') {
                showError('mensagem', 'A mensagem nao pode estar vazia.');
                valid = false;
            }

            if (!valid) {
                event.preventDefault(); // Impede o envio do formulário se houver erros
            }
        });

        function showError(fieldId, message) {
            const field = document.getElementById(fieldId);
            const error = document.createElement('p');
            error.className = 'error';
            error.style.color = 'red';
            error.textContent = message;
            field.insertAdjacentElement('afterend', error);
        }

        function validateEmail(email) {
            const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return re.test(email);
        }
    });
</script>