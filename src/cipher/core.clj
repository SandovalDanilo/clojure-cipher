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

(defn get-letters
  "retorna apenas letras de uma frase"
  [sentence]
  (filterv #(Character/isLetter %) (clojure.string/lower-case sentence)))

(defn caesar-encrypt
  "encriptando uma frase com uma chave utilizanado a cifra de César"
  [sentence key]
  (apply str (mapv #(shift % key) (get-letters sentence))))

(defn caesar-decrypt
  "decripta uma frase com uma chava utilizando a cifra de César"
  [sentence key]
  (apply str (mapv #(shift % (* -1 key)) (get-letters sentence))))

(defn count-characters
  "returna um hashmap contendo a quantidade de cada caracter numa string"
  [sentence]
  (loop [frase       sentence
         frequencias {}]
    (if (= (count frase) 0)
      frequencias
      (let [letra (first frase)
            resto (filter #(not= letra %) frase)]
        (recur resto
               (assoc frequencias
                      letra
                      (count (filter #(= letra %) frase))))))))

(defn most-frequent
  "retorna as X letras mais frequentes na frase"
  [frase x]
  (take x (sort-by second > (count-characters frase))))

(defn encrypt-letter
  "dados dois caracteres, retorna o primeiro encriptado com o segundo"
  [c1 c2]
  (to-char (mod (+ (to-int c1) (to-int c2)) 26)))

(defn encrypt-with-word
  "encripa uma frase usando uma palavra"
  [frase chave]
  (map encrypt-letter frase (cycle chave)))

(def frase1 "welcometoclojurebridge")
(def frase2 "Welcome to ClojureBridge!")
(defn vigenere-encrypt
  "trata e encripa uma frase usando a cifra de Vigenère"
  [frase chave]
  (encrypt-with-word (get-letters frase) chave))