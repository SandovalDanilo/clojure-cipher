(ns cipher.core)

(defn g
  [x y]
  (+ y (* 10 x)))

(defn to-int
  "recebe uma letra minúscola e retorna sua posição no alfabeto: a = 0, b = 1, etc."
  [letter-char]
  (let [ascii-a (int \a)]
    (- (int letter-char) ascii-a)))

(defn to-char
  "recebe um inteiro entre 0 e 26 e retorna a letra do alfabado associada: 0 = a, 1 = b, etc."
  [letter-index]
  (let [ascii-a (int \a)]
    (char (+ ascii-a letter-index))))

(defn shift
  "move uma letra em um dado número de posições"
  [letra chave]
  (to-char (mod (+ chave (to-int letra)) 26)))