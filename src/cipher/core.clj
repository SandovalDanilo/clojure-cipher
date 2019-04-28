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

(defn caesar-encrypt
  "encriptando uma palavra w com uma chave k utilizanado a cifra de César"
  [word key]
  (apply str (mapv #(shift % key) word)))

(defn caesar-decrypt
  "decripta uma palavra w com uma chava k utilizando a cifra de César"
  [word key]
  (apply str (mapv #(shift % (* -1 key)) word)))