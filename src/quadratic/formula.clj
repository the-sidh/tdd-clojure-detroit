(ns quadratic.formula
  (:require [quadratic.discriminant :refer :all]
            [schema.core :as s])
  (:import (java.math MathContext)))

(s/defn quadratic-formula [a :- BigDecimal
                           b :- BigDecimal
                           c :- BigDecimal]
  (let [discriminant (discriminant a b c)
        sqrt-discriminant (.sqrt discriminant (new MathContext 10))
        minus-b (.negate b)
        two-times-a (* 2M a)]
    #{(-> minus-b (+ sqrt-discriminant) (/ two-times-a))
      (-> minus-b (- sqrt-discriminant) (/ two-times-a))}))