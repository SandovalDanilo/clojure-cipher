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