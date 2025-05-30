# Global Solution - Somos+

Esse projeto foi desenvolvido com o objetivo de ajudar pessoas em situações de vulnerabilidade, juntamente de pessoas e empresas que queiram ajudar, oferencendo funcionalidades por parte do usuário de cadastrar um pedido de ajuda, informações sobre ONGs disponíveis, acesso a gráficos sobre informações de níveis de rios, entre outros. E por parte da empresa, poderá aceitar pedidos de ajuda, podendo filtrar dos mais importantes aos menos urgentes. Como forma de planejamento do projeto, utilizamos banco de dados Oracle para integração com Java, nas funcionalidades de cadastro, login, recuperação de senha e localização automaticamente consumindo a API ViaCep. Todas essas funcionalidades foram criadas com a plataforma de microserviços Quarkus, e o restante das funcionalidades, como forma de escalabilidade, optamos por utilizar a linguagem Python. 

---

## Funcionalidades (Usuário)
- Cadastro de pedido de ajuda;
- Visualizar ONGs disponíveis;
- Visualizar status pedido (pendente, em andamento, concluído);
- Histórico de pedidos;
- Cancelar ou atualizar pedidos;
- Gráficos sobre níveis de rios.

## Funcionalidades (Empresa)
- Aceitar pedido de ajuda;
- Visualizar pedidos;
- Gráficos e estatísticas por tipo de pedidos;

---

## Tabela de endpoints Java

| Método | Endpoint                                   | Funcionalidade                                                   |
|--------|--------------------------------------------|------------------------------------------------------------------|
| POST   | `/usuario/cadastrar`                       | Cadastra um novo usuário.                                       |
| POST   | `/usuario/login`                           | Faz login de um usuário a partir de e-mail e senha.             |
| POST   | `/empresa/cadastrar`                       | Cadastra uma nova empresa.                                      |
| POST   | `/empresa/login`                           | Faz login de uma empresa a partir de e-mail e senha.            |
| PUT    | `/usuario/atualizar-senha`                 | Atualiza a senha de um usuário a partir do e-mail.              |
| PUT    | `/empresa/atualizar-senha`                 | Atualiza a senha de uma empresa a partir do e-mail.             |
| GET    | `/endereco/buscar/{cep}`                   | Busca o endereço a partir do CEP informado pelo usuário.        |
