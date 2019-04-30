(ns cipher.core-test
  (:require [clojure.test :refer :all]
            [cipher.core :as core]
            [midje.sweet :refer :all]))

(fact "this will fail"
  2 => 2)

(fact "função (g x y) => x vezes 10 mais y"
  (core/g 2 4) => 24)

(facts "recebe um caractere minúsculo e retorna sua posição no alfabeto: a = 0, b = 1, etc"
       (tabular
         (core/to-int ?char) => ?result
         ?char ?result
         \a    0
         \b    1
         \c    2
         \d    3))

(facts "recebe um inteiro entre 0 e 26 e retorna a letra do alfabado associada: 0 = a, 1 = b, etc."
       (tabular
         (core/to-char ?char) => ?result
         ?char ?result
         0    \a
         1    \b
         2    \c
         3    \d))

(facts "move uma letra em um dado número de posições"
       (tabular
         (core/shift ?letra ?chave) => ?result
         ?letra ?chave ?result
         \a     3      \d
         \b     20     \v
         \z     3      \c))

(facts "retorna apenas letras de uma frase"
       (tabular
         (core/get-letters ?frase) => ?result
         ?frase           ?result
         "hello"          [\h \e \l \l \o]
         "Hello!"         [\h \e \l \l \o]
         "Hello friend!"  [\h \e \l \l \o \f \r \i \e \n \d]))

(facts "encriptando uma palavra w com uma chave k utilizanado a cifra de César"
       (tabular
         (core/caesar-encrypt ?palavra ?chave) => ?result
         ?palavra ?chave ?result
         "apple"  20     "ujjfy"
         "abc"    3      "def"
         "Hello!" 3      "khoor"))

(facts "decripta uma palavra w com uma chave k utilizanado a cifra de César"
       (tabular
         (core/caesar-decrypt ?palavra ?chave) => ?result
         ?palavra ?chave ?result
         "ujjfy"  20     "apple"
         "def"    3      "abc"))

(facts "returna um hashmap contendo a quantidade de cada caracter numa string"
       (tabular
         (core/count-characters ?frase) => ?result
         ?frase    ?result
         "abc"     {\a 1, \b 1, \c 1}
         "aaabbc"  {\a 3, \b 2, \c 1}))

(facts "retorna as X letras mais frequentes na frase"
       (tabular
         (core/most-frequent ?frase ?x) => ?result
         ?frase       ?x  ?result
         "xyz"        3   [[\x 1] [\y 1] [\z 1]]
         "aaaabbbccd" 3   [[\a 4] [\b 3] [\c 2]]))

(facts "dados dois caracteres, retorna o primeiro encriptado com o segundo"
       (tabular
         (core/encrypt-letter ?c1 ?c2) => ?result
         ?c1 ?c2 ?result
         \w  \c  \y
         \u  \i  \c))
