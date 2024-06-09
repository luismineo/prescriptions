/* js/script.js */
document.addEventListener('DOMContentLoaded', function() {
    const medicoLoginForm = document.getElementById('loginMedicoForm');
    const farmaciaLoginForm = document.getElementById('loginFarmaciaForm');
    const criarReceitaForm = document.getElementById('criarReceitaForm');
    const visualizarReceitaForm = document.getElementById('visualizarReceitaForm');

    const loginMedicoPadrao = {
        usuario: "medico123",
        senha: "senha123"
    };

    const loginFarmaciaPadrao = {
        cnpj: "12345678000100",
        senha: "senha123"
    };

    if (medicoLoginForm) {
        medicoLoginForm.addEventListener('submit', function(e) {
            e.preventDefault();

            const usuario = document.getElementById('usuario').value;
            const senha = document.getElementById('senha').value;

            if (usuario === loginMedicoPadrao.usuario && senha === loginMedicoPadrao.senha) {
                alert('Login médico bem-sucedido!');
                window.location.href = 'criarReceita.html';
            } else {
                alert('Usuário ou senha inválidos.');
            }
        });
    }

    if (farmaciaLoginForm) {
        farmaciaLoginForm.addEventListener('submit', function(e) {
            e.preventDefault();

            const cnpj = document.getElementById('cnpj').value;
            const senha = document.getElementById('senha').value;

            if (cnpj === loginFarmaciaPadrao.cnpj && senha === loginFarmaciaPadrao.senha) {
                alert('Login farmácia bem-sucedido!');
                window.location.href = 'visualizarReceita.html';
            } else {
                alert('CNPJ ou senha inválidos.');
            }
        });
    }

    if (criarReceitaForm) {
        criarReceitaForm.addEventListener('submit', function(e) {
            e.preventDefault();

            const formData = new FormData(criarReceitaForm);
            const jsonData = {};

            formData.forEach((value, key) => {
                jsonData[key] = value;
            });

            console.log(JSON.stringify(jsonData));

            alert('Receita criada: ' + JSON.stringify(jsonData));
        });
    }

    if (visualizarReceitaForm) {
        visualizarReceitaForm.addEventListener('submit', function(e) {
            e.preventDefault();

            const codigoReceita = document.getElementById('codigoReceita').value;
            // Simulação de busca de receita. Implementar chamada de API aqui se necessário.
            const receitaExemplo = {
                nomePaciente: "João da Silva",
                dataNascimento: "1990-01-01",
                cpf: "123.456.789-00",
                planoDeSaude: "Plano Exemplo",
                nomeMedicamento: "Medicamento Exemplo",
                dosagem: "500mg",
                quantidade: 20,
                viaDeAdministracao: "Oral",
                observacoes: "Tomar após as refeições"
            };

            const detalhesReceitaDiv = document.getElementById('detalhesReceita');
            detalhesReceitaDiv.innerHTML = `
                <h3>Detalhes da Receita</h3>
                <p><strong>Nome do Paciente:</strong> ${receitaExemplo.nomePaciente}</p>
                <p><strong>Data de Nascimento:</strong> ${receitaExemplo.dataNascimento}</p>
                <p><strong>CPF:</strong> ${receitaExemplo.cpf}</p>
                <p><strong>Plano de Saúde:</strong> ${receitaExemplo.planoDeSaude}</p>
                <p><strong>Nome do Medicamento:</strong> ${receitaExemplo.nomeMedicamento}</p>
                <p><strong>Dosagem:</strong> ${receitaExemplo.dosagem}</p>
                <p><strong>Quantidade:</strong> ${receitaExemplo.quantidade}</p>
                <p><strong>Via de Administração:</strong> ${receitaExemplo.viaDeAdministracao}</p>
                <p><strong>Observações:</strong> ${receitaExemplo.observacoes}</p>
            `;
        });
    }
});
