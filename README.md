# Quiz Filosofia — 6º ano | Versão 1.0.1

Aplicativo Android educativo baseado nas cinco páginas fotografadas do Livro do Aluno SAE Digital enviadas nesta conversa. Projeto independente: não misturar com Quiz História, ArteMica, Português ou Lyravoxen.

## Conteúdo estudado
1. **Viver eticamente é reflexo da mesma ordem que governa o cosmos** — Nietzsche, sentido da vida, Kierkegaard, existencialismo, angústia, Camus, absurdo da existência, liberdade, revolta contra o absurdo e solidariedade.
2. **Carta ao cosmos e poema “O ser humano e o cosmos”** — pensamentos, dúvidas, sonhos, equilíbrio, cuidado com o lugar onde vivemos e com as pessoas.
3. **A beleza que o mundo tem é a beleza que enxergamos nele** — história, raízes culturais, língua, religião, artes, tradições, leis, normas sociais e diferentes visões de mundo.
4. **O futuro é ancestral** — Ailton Krenak, Terra como organismo vivo, crítica à exploração ambiental e cosmologia indígena.
5. **Davi Kopenawa e os Yanomami** — *A queda do céu*, floresta, queda do céu, antepassados e ensinamentos dos xamãs.
6. **Respeito cultural** — diálogo intercultural, empatia e respeito.

## Jogos e atividades
- Quiz principal com **72 perguntas**, quatro alternativas, explicação, ordem aleatória, cronômetro, vidas, dica e pular para o final da fila sem remover a pergunta.
- Verdadeiro ou falso com **32 itens**, sempre no formato de pergunta seguida de resposta/afirmação proposta para julgar.
- Jogo da memória com **8 pares (16 cartas)**.
- Associe pergunta e resposta com **8 pares**.
- Ligue as colunas com **8 pares**.
- Relacione palavras com **8 conceitos**.
- Caça-palavras com **10 termos** em grade 12×12, horizontal e vertical.
- Palavras cruzadas com **8 pistas** e grade de letras interligadas.
- Desafio adicional de raciocínio e interpretação com **10 situações** aplicadas aos conceitos do livro.

## Níveis do quiz
| Nível | Tempo por pergunta | Vidas |
|---|---:|---:|
| Fácil | 1 min 30 s | 3 |
| Normal | 1 min | 4 |
| Difícil | 30 s | 5 |

As perguntas são embaralhadas a cada nova partida. Pular uma pergunta a move para o final da fila.

## Música e efeitos
O aplicativo usa síntese instrumental original via Web Audio, com perfis musicais separados para a tela inicial, resumo, cada seção do resumo, níveis, galeria de jogos, quiz, resultado e cada minijogo. As melodias têm variações aleatórias a cada entrada. Inclui controle de volume, mute e efeitos diferentes de acerto/erro.

## Revisão corretiva 1.0.1
A versão anterior continha uma falha crítica em `setMusic()`: ao trocar de tela depois de iniciar a música, o código tentava chamar `music.play()`, método que não existia. A exceção interrompia a execução antes de preencher os conteúdos dinâmicos, deixando resumo e jogos vazios. A navegação agora usa o reinício real da trilha (`restartMusic()`), e os testes simulam explicitamente a situação “iniciar música e trocar de tela”.

Outras correções:
- Resumo completo baseado nas cinco páginas, com conteúdo estático inicial como proteção adicional.
- Banco principal ampliado para 72 perguntas e gabarito validado.
- Verdadeiro/falso ampliado para 32 perguntas + respostas propostas.
- Jogos com bancos completos e telas preenchidas.
- Caça-palavras horizontal/vertical e cruzadinha com grade interligada.
- Trilhas exclusivas por tela e jogo.
- Capturas ilustrativas recortadas das próprias páginas anexadas.

## Compilar o APK
O workflow `.github/workflows/build-android-apk.yml` compila o APK Debug e publica o artefato `Quiz-Filosofia-APK`.

1. Envie todo o conteúdo deste projeto para a raiz de um repositório GitHub novo chamado `QuizFilosofia`.
2. Abra **Actions**.
3. Execute **Build Quiz Filosofia APK**.
4. Baixe o artefato `Quiz-Filosofia-APK`.

## Arquivos gráficos
- `icone-filosofia-1024.png`: ícone PNG 1024×1024 com transparência.
- `launcher-filosofia-referencia.png`: referência visual do launcher.
- `app/src/main/res/`: ícones Android adaptativos, foreground, background, monocromático e splash.
