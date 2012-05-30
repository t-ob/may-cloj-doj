(ns for-the-glory-of-art
  (:use quil.core))

(def active-piece (atom [0 0]))
(def square-size 20)
(def board-height 600)
(def board-width 800)

(defn key-typed? []
  (swap! active-piece (fn [[x y]] [(min (- board-width square-size) (+ square-size x)) y])))

(defn tick []
  (swap! active-piece (fn [[x y]] [x (min (- board-height square-size) (+ square-size y))])))

(defn clear [] (background-float 0))

(defn tetris-draw []
  (let [[x y] @active-piece]
    (tick)
    (clear)
    (rect x y square-size square-size)))

(defn tetris-setup []
  (smooth)
  (frame-rate 2)                    
  (background 200))

(defsketch example
  :title "Game"
  :setup tetris-setup
  :draw tetris-draw
  :size [board-width board-height]
  :key-released key-typed?)
