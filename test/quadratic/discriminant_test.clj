(ns quadratic.discriminant-test
  (:require [clojure.test :refer :all]
            [quadratic.discriminant :refer :all]
            [quadratic.fixtures :as f])
  (:import (clojure.lang ExceptionInfo)))

(use-fixtures :once f/schema-validation)

(deftest discriminant-test
  (testing "given a is not a BigDecimal should throw an exception"
    (is (thrown? ExceptionInfo (discriminant 1 -1M -12M))))
  (testing "given b is not a BigDecimal should throw an exception"
    (is (thrown? ExceptionInfo (discriminant 1M -1 -12M))))
  (testing "given c is not a BigDecimal should throw an exception"
    (is (thrown? ExceptionInfo (discriminant 1M -1M -12)))
    (testing "given a = 1. b=-1 and c=-12 when calculating the discriminant should get 49"
      (is (= 49M (discriminant 1M -1M -12M))))))