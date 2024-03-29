document.getElementById('forms_cadastro').addEventListener('submit', async function (params) {
    params.preventDefault(); 

    var nome = document.getElementById('campo_nome').value;
    var email = document.getElementById('campo_email').value;
    var cpf = document.getElementById('campo_cpf').value;
    var senha = document.getElementById('campo_senha').value;
    var idade = document.getElementById('campo_nasc').value; 
    var telefone = document.getElementById('campo_telefone').value

    try {
        let response = await fetch('http://localhost:8080/users/cadastro', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: nome,
                email: email,
                document: cpf,
                password: senha,
                age: idade,
                phone: telefone
            })
        });

        if (!response.ok) {
            throw new Error('Something went wrong');
        }
    } catch (error) {
        console.error(error);
    }
})