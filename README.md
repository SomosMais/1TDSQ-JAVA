# Global Solution - Somos+

Esse projeto foi desenvolvido com o objetivo de ajudar pessoas em situações de vulnerabilidade, juntamente de pessoas e empresas que queiram ajudar, oferencendo funcionalidades por parte do usuário de cadastrar um pedido de ajuda, informações sobre ONGs disponíveis, acesso a gráficos sobre informações de níveis de rios, entre outros. E por parte da empresa, poderá aceitar pedidos de ajuda, podendo filtrar dos mais importantes aos menos urgentes. Como forma de planejamento do projeto, utilizamos banco de dados Oracle para integração com Java, nas funcionalidades de cadastro, login, recuperação de senha e localização automaticamente consumindo a API ViaCep. Todas essas funcionalidades foram criadas com a plataforma de microserviços Quarkus, e o restante das funcionalidades, como forma de escalabilidade, optamos por utilizar a linguagem Python. 

---

## PROJETO FINALIZADO (URL VERCEL)
- https://1-tdsq-front-comum-t5ae.vercel.app/

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

---

## 🚀 Como Rodar o Projeto

# Clone o repositório:
- https://github.com/SomosMais/1TDSQ-JAVA.git.
- Abra o repositório clonado na sua IDE (Eclipse ou Intellij) e certifique-se que tenha o plugin "Quarkus Tools" instalado na sua IDE.
- Rode o projeto.

---

## 🛠️ Tecnologias Utilizadas
- Java
- Quarkus
- Maven
- API ViaCEP (para busca de endereços)

---

## 👥 Desenvolvedores

| Nome                | GitHub                                           | LinkedIn                                                  | Função                  |
|---------------------|--------------------------------------------------|-----------------------------------------------------------|-------------------------|
| Pedro Henrique Sena | https://github.com/devpedrosena1                 | https://www.linkedin.com/in/pedro-henrique-sena/          | Desenvolvedor           |
| Matheus Henrique    | https://github.com/MatheusHenriqueNF             | https://www.linkedin.com/in/matheus-henrique-freitas/     | Desenvolvedor           |
| Cleyton de Oliveira | https://github.com/Cleytonrik99                  | https://www.linkedin.com/in/cleyton-enrike-de-oliveira99/ | Desenvolvedor           |

---

## 📫 Contato Geral

Se tiver dúvidas, sugestões ou quiser colaborar, fique à vontade para entrar em contato com qualquer integrante pelo GitHub ou LinkedIn.


---

# &copy; Todos os direitos reservados.
