# Atividade_Caixa_Branca
Atividade para matéria de "UI/UX e Testes de Software" do professor Daniel Ohata 


## 1. Notação de Grafo de Fluxo

| Nó  | Ação                                     |
| --- | ---------------------------------------- |
| N1  | Início do método                         |
| N2  | Montagem da SQL                          |
| N3  | Tentativa de conexão                     |
| N4  | Decisão: `conn != null`                  |
| N5  | Executa a consulta                       |
| N6  | Decisão: `rs.next()`                     |
| N7  | Retorna `true` (usuário encontrado)      |
| N8  | Retorna `false` (usuário não encontrado) |
| N9  | Tratamento de exceção                    |
| N10 | Retorno final `false`                    |


<img width="909" height="1032" alt="image" src="https://github.com/user-attachments/assets/22c7a860-54d8-4051-977b-dd3514145af5" />



## 2. Complexidade Ciclomática

A fórmula usada foi M = E – N + 2P, conforme mostrada em aula, onde E = total de arestas, N = total de nós e P = número de componentes conectados (1 método → P = 1).

Contagem:

Nós (N) = 10

Arestas (E) = 15

Componentes (P) = 1

Cálculo:
M = 15 – 10 + 2(1)
M = 15 – 10 + 2
M = 7

Complexidade Ciclomática = 7


## 3. Caminhos Básicos

1. Caminho 1 – Conexão nula

N1 → N2 → N3 → N4 (não) → N10

2. Caminho 2 – Conexão válida + usuário encontrado

N1 → N2 → N3 → N4 (sim) → N5 → N6 (sim) → N7 → N10

3. Caminho 3 – Conexão válida + usuário não encontrado

N1 → N2 → N3 → N4 (sim) → N5 → N6 (não) → N8 → N10

4. Caminho 4 – Exceção ao conectar

N1 → N2 → N3 → N9 → N10

5. Caminho 5 – Exceção após decisão conn != null

N1 → N2 → N3 → N4 → N9 → N10

6. Caminho 6 – Exceção ao executar consulta

N1 → N2 → N3 → N4 (sim) → N5 → N9 → N10

7. Caminho 7 – Exceção no processamento do ResultSet

N1 → N2 → N3 → N4 (sim) → N5 → N6 → N9 → N10
