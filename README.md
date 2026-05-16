# PrimeiroTrabalhoemGrupoAPIREST-Grupo6-Serratec

# 🏥 ClinicaMédica API • Grupo 6

Uma API REST desenvolvida em Spring Boot para o gerenciamento completo de consultas, médicos e pacientes de uma clínica médica. Este projeto faz parte da avaliação do módulo.

---

## 👥 Integrantes do Time

* 👩‍💻 **Nathália de Queiroz Antunes** — [nathaliaa-qa](https://github.com/nathaliaa-qa)
* 👨‍💻 **Lucas Lira** — [lc-lira](https://github.com/lc-lira)
* 👩‍💻 **Gabriela**
* 👨‍💻 **João Lucas**
* 👨‍💻 **Pedro Lucas**

---

## 🛠️ Tecnologias e Dependências

O projeto foi construído utilizando as seguintes ferramentas do ecossistema Java:

* ☕ **Java 17**
* 🍃 **Spring Boot 3.x**
* 🌐 **Spring Web** (Criação das rotas REST)
* 🗄️ **Spring Data JPA** (Persistência e mapeamento objeto-relacional)
* 🛡️ **Validation** (Validação de campos obrigatórios, formatos e tamanhos)
* 📈 **Dev Tools** (Recarregamento rápido durante o desenvolvimento)
* 💾 **Banco de Dados H2** (Armazenamento salvo localmente em arquivo)

---

## 🗂️ Arquitetura e Modelagem

Para evitar repetição de código, implementamos o conceito de herança utilizando uma classe base comum:

* 🧑 **Superclasse Pessoa**: Contém atributos comuns como `nome`, `email` e `telefone`.
* 🩺 **Médico**: Herda de Pessoa e adiciona `crm` e `especialidade`.
* 👤 **Paciente**: Herda de Pessoa e possui seu respectivo histórico.
* 📅 **Consulta**: Gerencia os agendamentos vinculando a data, hora e o `status` (Aguardando, Em Atendimento, Atendido).

---

## 🛣️ Rotas da API (Endpoints)

### 🩺 Médicos (`/medicos`)
* `POST /medicos` — Cadastra um novo médico com validações de CRM, e-mail e telefone.
* `GET /medicos` — Lista todos os médicos cadastrados no sistema.

### 👤 Pacientes (`/pacientes`)
* `POST /pacientes` — Insere um novo paciente.
* `PUT /pacientes` — Atualiza os dados de um paciente existente.
* `DELETE /pacientes` — Remove um paciente do sistema.
* `GET /pacientes` — Lista os pacientes e exibe suas respectivas consultas vinculadas.

### 📅 Consultas (`/consultas`)
* `POST /consultas` — Agenda uma nova consulta vinculando um médico e um paciente.

⚠️ *O sistema possui um **Tratador de Exceções Global** para interceptar erros de validação e retornar mensagens limpas para o cliente.*

---

## ⚙️ Como Inicializar o Projeto

1. Certifique-se de ter o **Java 17** instalado na máquina.
2. Clone este repositório:
   ```bash
   git clone [https://github.com/lc-lira/PrimeiroTrabalhoemGrupoAPIREST-Grupo6-Serratec.git](https://github.com/lc-lira/PrimeiroTrabalhoemGrupoAPIREST-Grupo6-Serratec.git)