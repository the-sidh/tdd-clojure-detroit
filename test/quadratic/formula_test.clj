(ns quadratic.formula_test
  (:require [clojure.test :refer :all]
            [quadratic.formula :refer :all]
            [quadratic.fixtures :as f])
  (:import (clojure.lang ExceptionInfo)))

(use-fixtures :once f/schema-validation)

(deftest quadratic-formula-test
  (testing "given a is not a BigDecimal should throw an exception"
      (is (thrown? ExceptionInfo (quadratic-formula 1 -1M -12M))))
  (testing "given b is not a BigDecimal should throw an exception"
    (is (thrown? ExceptionInfo (quadratic-formula 1M -1 -12M))))
  (testing "given c is not a BigDecimal should throw an exception"
    (is (thrown? ExceptionInfo (quadratic-formula 1M -1M -12))))
  (testing "given a=1, b=-1 and c=-12 when using quadratic formula should return a set containing -3 and 4"
    (is (= #{-3M 4M} (quadratic-formula 1M -1M -12M)))))
