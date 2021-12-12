(ns quadratic.discriminant
  (:require [schema.core :as s]))

(s/defn discriminant [a :- BigDecimal
                      b :- BigDecimal
                      c :- BigDecimal]
  (let [square #(* % %)
        four-times #(* 4M %1 %2)]
    (-> (square b) (- (four-times a c)))))