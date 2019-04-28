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

(facts "encriptando uma palavra w com uma chave k utilizanado a cifra de César"
       (tabular
         (core/caesar-encrypt ?palavra ?chave) => ?result
         ?palavra ?chave ?result
         "apple"  20     "ujjfy"
         "abc"    3      "def"))

(facts "decripta uma palavra w com uma chave k utilizanado a cifra de César"
       (tabular
         (core/caesar-decrypt ?palavra ?chave) => ?result
         ?palavra ?chave ?result
         "ujjfy"  20     "apple"
         "def"    3      "abc"))

