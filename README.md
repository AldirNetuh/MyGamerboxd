# 🎮 Gamerboxd

Um diário de jogos pessoal inspirado no Letterboxd. O projeto consome a API da RAWG para buscar títulos e permite gerenciar seu backlog e suas reviews de forma simples e visual.

## ✨ Funcionalidades

- 🔍 **Busca Global:** Pesquise qualquer jogo na base de dados da RAWG.
- ⏳ **Wishlist (Quero Jogar):** Salve jogos no seu backlog para não esquecer.
- ✍️ **Reviews & Notas:** Dê notas (1-5 estrelas), escreva sua análise e marque se platinou 🏆.
- 🔄 **Fluxo Inteligente:** Ao fazer a review de um jogo da wishlist, ele move automaticamente para o diário.
- 💾 **Persistência Local:** Seus dados ficam salvos no navegador (LocalStorage) e não somem ao fechar a aba.

## 🛠️ Tecnologias Utilizadas

- **HTML5 Semântico**
- **CSS3 Moderno** (Grid Layout, Flexbox, Variáveis CSS, Glassmorphism)
- **JavaScript Vanilla** (Fetch API, DOM Manipulation, Async/Await)
- **API Externa:** [RAWG.io](https://rawg.io/apidocs)

## 🚀 Como Rodar o Projeto

1. Clone este repositório.
2. Crie uma conta na [RAWG.io](https://rawg.io/apidocs) e pegue sua **API Key** (é grátis).
3. Abra o arquivo `script.js`.
4. Na linha 1, substitua `'SUA_CHAVE_AQUI'` pela sua chave real:
   ```javascript
   const API_KEY = 'insira-sua-chave-aqui';

---
Desenvolvido por [Aldir](https://github.com/AldirNetuh) 🚀