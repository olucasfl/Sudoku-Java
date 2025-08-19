# Sudoku Console 🧩

Bem-vindo ao **Sudoku Console**, um jogo de Sudoku interativo para console, desenvolvido em Java!  

Este projeto demonstra habilidades em **programação orientada a objetos**, **estruturas de dados**, **controle de fluxo**, **validação de entradas**, **interface de console interativa** e **organização de projetos Java**.

---

## 🚀 Sobre o Projeto

Este projeto consiste em:

- **Tabuleiro gerado aleatoriamente:** Cada partida é única, com células fixas e editáveis.  
- **Controle de jogadas:** O jogador tem 3 vidas; cada erro diminui uma vida.  
- **Validação lógica:** O programa verifica se o número inserido é válido na linha, coluna e subquadrante 3x3.  
- **Interface de console limpa:** Mostra o tabuleiro, vidas restantes e permite reiniciar o jogo sem reiniciar o programa.  
- **Numerador de linhas e colunas:** Utiliza caracteres em **superscript** para diferenciar números do tabuleiro das coordenadas.  

O projeto está organizado em pacotes:

- `sdk.model` – contém a lógica do jogo e classes principais:
  - **`Celula.java`** – representa cada célula do tabuleiro, com valor, posição e se é fixa ou editável.
  - **`Tabuleiro.java`** – controla a criação do tabuleiro, valida jogadas, imprime o estado atual e gerencia vidas.
- `sdk.view` – contém a interface de interação com o usuário:
  - **`TabuleiroConsole.java`** – captura entradas, atualiza o tabuleiro e exibe mensagens de status.
- `sdk.controller` – contém o controle para possíveis:
  - **`PerdeuExcepcion`** – extende de RuntimeException e ultiliza um serialVersionUID = 1, para definir os erros.

---

## 🛠 Tecnologias e Conceitos Utilizados

Este projeto evidencia várias habilidades e conceitos importantes:

- **Java Puro:** Programação orientada a objetos, encapsulamento, métodos, atributos privados e finais.  
- **Coleções e Utilitários:** Uso de `ArrayList`, `Collections.shuffle` para gerar números aleatórios no tabuleiro.  
- **Controle de fluxo:** Loops, condicionais e recursão para preencher o tabuleiro (backtracking simplificado).  
- **Validação de dados:** Garantia de que cada jogada respeita as regras do Sudoku.  
- **Interação com o usuário:** Leitura de entradas via `Scanner` e tratamento de exceções para entradas inválidas.  
- **Design organizado:** Separação entre lógica (`model`), interface (`view`) e controle (`controller`), facilitando manutenção e extensão futura.

---

## 🎮 Como Jogar

1. **Clone o repositório:**
```bash
git clone https://github.com/lucasfl22/SeuRepositorio.git
```
2. **Entre na pasta e acesse o**
3.  ```bash
4. SudokuLF.exe
5. ```
